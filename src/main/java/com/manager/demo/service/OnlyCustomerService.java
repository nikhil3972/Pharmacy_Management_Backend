package com.manager.demo.service;

import com.manager.demo.dao.OnlyCustomerDao;
import com.manager.demo.dao.customerDao;
import com.manager.demo.entity.Customer;
import com.manager.demo.entity.Sales;
import com.manager.demo.entity.onlyCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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

    int totalPrice=0;
    public String totalCost(List<onlyCustomer> sale){

        List<onlyCustomer>saleList=sale;
        Iterator<onlyCustomer> iterator = saleList.iterator();
        while(iterator.hasNext()) {
            totalPrice=totalPrice+iterator.next().getPrice();

        }
        System.out.println( " Total Price :");
return "Total price "+Integer.toString(totalPrice);
    }


    public int getTotalCost(){
        List<onlyCustomer> dataNew=getCustomer();
       String data= totalCost(dataNew);
       return totalPrice;
    }

}
