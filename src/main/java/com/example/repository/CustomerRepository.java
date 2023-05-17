package com.example.repository;
import com.example.dto.Orders;
import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer,Long> {

    @Query("SELECT new com.example.dto.Orders(c.cName , p.pName) FROM Customer c JOIN c.productList p")
    public List<Orders> getOrderedData();


    @Query("SELECT c FROM Customer c WHERE c.productList IS EMPTY")
    List<Customer> findAllCustomersWithoutProducts();


}
