package com.manager.demo.service;
import com.manager.demo.dao.PurchasesOrderDao;
import com.manager.demo.entity.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class PurchaseOrderService {
	@Autowired
	private PurchasesOrderDao dao ;
	public String addPurchaseOrder(PurchaseOrder purchaseOrder){
		dao.save(purchaseOrder);
		return "PurchaseOrder added";
	}
	public String deletePurchaseOrder(int id){
		PurchaseOrder purchaseOrder=dao.getById(id);
		dao.delete(purchaseOrder);
		return "PurchaseOrder deleted "+id;
	}
	public String updatePurchaseOrder(PurchaseOrder purchaseOrder){
		dao.save(purchaseOrder);
		return "PurchaseOrder Updated";
	}
	public List<PurchaseOrder> getPurchaseOrder(){
		List<PurchaseOrder> purchaseOrder=dao.findAll();
		return purchaseOrder;
	}
}
