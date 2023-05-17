package com.example.controller;
import com.example.dto.Orders;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addData(@RequestBody Customer customer){
        customerRepository.save(customer);
        return"data saved ...";
    }

    @GetMapping
    public List<Orders> getAllData(){
        return customerRepository.getOrderedData();
    }

    @GetMapping("/emptyCustomer")
    public List<Customer> findCustomersWithNoPurchases(){
        return customerRepository.findAllCustomersWithoutProducts();
    }



}
