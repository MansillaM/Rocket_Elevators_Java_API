package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.util.Base64;
import java.util.List;

import com.codeboxx.Rocket_Elevators_Java_Api.Models.Customer;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.CustomerRepository;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.CustomerService;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final UserService userService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService, UserService userService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.userService = userService;
    }

    //for GET method
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {

        return customerService.allCustomers();
    }

    //for GET method
    @GetMapping("/{id}")
    public Customer getByCustomerId(@PathVariable int id) {

        return customerService.customerById(id);
    }

    //for POST method
    @PostMapping("/new")
    public void saveCustomer(@RequestBody Customer newCustomer) {
        customerService.createCustomer(newCustomer);
    }

    //for GET method
    /* Return information about currently logged in customer */
    @GetMapping("/current")
    List<Customer> user(HttpServletRequest request) {
        String encodedUser = request.getHeader("Authorization").split("\\.")[1];
        byte[] decodedBytes = Base64.getDecoder().decode(encodedUser);
        String decodedUser = new String(decodedBytes);
        Integer decodedUser_Id = Integer.parseInt(decodedUser.split("(:)|(\")|(,)")[4]);
        return customerRepository.findByUser_Id(decodedUser_Id);
    }

}
