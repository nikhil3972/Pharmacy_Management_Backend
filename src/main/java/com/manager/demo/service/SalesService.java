package com.manager.demo.service;

import com.manager.demo.dao.SalesDao;

import com.manager.demo.entity.Manufacturer;
import com.manager.demo.entity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class SalesService {
    @Autowired

    private SalesDao dao;
    public String addSales(Sales sales){
        dao.save(sales);
        return "Sales added";
    }
    public String deleteSales(int id){
       Sales sale=dao.getById(id);
        dao.delete(sale);
        return "Sales deleted "+id;
    }
    public String updateSales(Sales sale){
        dao.save(sale);
        return "Sales Updated";
    }
    public List<Sales> getSale(){
        List<Sales> sale=dao.findAll();
        return sale;
    }


}
