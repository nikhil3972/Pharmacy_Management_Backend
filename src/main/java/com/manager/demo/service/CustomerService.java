package com.manager.demo.service;

import com.manager.demo.dao.customerDao;
import com.manager.demo.entity.Customer;

import com.manager.demo.entity.CustomerMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private customerDao dao;
    public String addCustomer(Customer customer){
        dao.save(customer);
        return "CustomerMedicine added";
    }
    public String deleteCustomer(int id){
        Customer customer=dao.getById(id);
        dao.delete(customer);
        return "Customer deleted "+id;
    }
    public String updateCustomer(Customer customer){
        dao.save(customer);
        return "customer Updated";
    }
    public List<Customer> getCustomer(){
       List<Customer> customers=dao.findAll();
       return customers;
    }
}
