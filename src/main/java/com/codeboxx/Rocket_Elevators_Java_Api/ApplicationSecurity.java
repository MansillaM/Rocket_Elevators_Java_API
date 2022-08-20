package com.codeboxx.Rocket_Elevators_Java_Api;

import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return (UserDetails) userRepository.findByEmail(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User " + username + " not   found."));
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // This will be changed later to restrict access.
        http.authorizeRequests()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/swagger-ui/index.html").permitAll()
                .antMatchers("/swagger-ui/favicon-32x32.png?v=3.0.0").permitAll()
                .antMatchers("/swagger-ui/springfox.js?v=3.0.0").permitAll()
                .antMatchers("/swagger-ui-standalone-preset.js?v=3.0.0").permitAll()
                .antMatchers("/swagger-ui/swagger-ui-bundle.js?v=3.0.0").permitAll()
                .antMatchers("/swagger-ui/favicon-16x16.png?v=3.0.0").permitAll()
                .antMatchers("/swagger-ui/swagger-ui.css?v=3.0.0").permitAll()
                .antMatchers("/swagger-ui/springfox.css?v=3.0.0").permitAll()
                .anyRequest().authenticated();
        http.exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                );

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}