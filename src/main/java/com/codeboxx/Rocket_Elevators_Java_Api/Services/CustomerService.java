package com.codeboxx.Rocket_Elevators_Java_Api.Services;
import com.codeboxx.Rocket_Elevators_Java_Api.Models.Customer;
import com.codeboxx.Rocket_Elevators_Java_Api.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //for GET method
    public List<Customer> allCustomers() {

        return customerRepository.findAll();
    }

    //for GET method
    public Customer customerById(int id) {

        return customerRepository.findById(id).get();
    }

    //for POST method
    public void createCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }
}
