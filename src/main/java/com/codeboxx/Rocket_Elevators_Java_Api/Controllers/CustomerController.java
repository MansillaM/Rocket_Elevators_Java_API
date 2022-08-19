package com.codeboxx.Rocket_Elevators_Java_Api.Controllers;

import java.nio.file.FileSystemNotFoundException;
import java.security.Principal;
import java.util.List;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Customer;
import com.codeboxx.Rocket_Elevators_Java_Api.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {

        return customerService.allCustomers();
    }

    @GetMapping("/{id}")
    public Customer getByCustomerId(@PathVariable int id) {

        return customerService.customerById(id);
    }

    @PostMapping("/new")
    public void saveCustomer(@RequestBody Customer newCustomer) {
        customerService.createCustomer(newCustomer);
    }

    @GetMapping("/current")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
