package com.manager.demo.service;

import com.manager.demo.dao.OnlyCustomerDao;
import com.manager.demo.dao.customerDao;
import com.manager.demo.entity.Customer;
import com.manager.demo.entity.onlyCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OnlyCustomerService {
    @Autowired
    private OnlyCustomerDao dao;
    public String addCustomer(onlyCustomer customer){
        dao.save(customer);
        return "CustomerMedicine added";
    }
    public String deleteCustomer(int id){
        onlyCustomer customer=dao.getById(id);
        dao.delete(customer);
        return "Customer deleted "+id;
    }
    public String updateCustomer(onlyCustomer customer){
        dao.save(customer);
        return "customer Updated";
    }
    public List<onlyCustomer> getCustomer(){
        List<onlyCustomer> customers=dao.findAll();
        return customers;
    }

}
