package com.manager.demo.service;
import com.manager.demo.entity.PurchaseOrder;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
public class PurchaseOrderService {
	private int purchaseOrderIdCount= 1;
	private List< PurchaseOrder> purchaseOrderList =new CopyOnWriteArrayList<>();
	public  PurchaseOrder addManufacturer( PurchaseOrder  purchaseOrder) {
		 purchaseOrder.setId( purchaseOrderIdCount);
		 purchaseOrderList.add( purchaseOrder);
		 purchaseOrderIdCount++;
		return  purchaseOrder;
	}

	public List< PurchaseOrder>getmanufacture(){
		return  purchaseOrderList;
	}
	public 	 PurchaseOrder getPurchaseOrder(int  purchaseOrderId) {
		return  purchaseOrderList.stream().filter(c -> c.getId()==  purchaseOrderId)
				.findFirst().get();
	}
	public  PurchaseOrder updatePurchaseOrder(int  purchaseOrderId,PurchaseOrder  purchaseOrder) {
		 purchaseOrderList.stream().forEach(c->{
			if(c.getId()==  purchaseOrderId) {
				c.setPurchaseDate( purchaseOrder.getPurchaseDate());
				c.setExpectedDeliveryDate( purchaseOrder.getExpectedDeliveryDate());
				c.setTotalCost( purchaseOrder.getTotalCost());
				
			}
		});
		return  purchaseOrderList.stream().filter(c->c.getId()==  purchaseOrderId).findFirst().get();
	}
	public void deletePurchaseOrder(int  purchaseOrderId) {
		 purchaseOrderList.stream().forEach(c->{
			if(c.getId()== purchaseOrderId) {
				 purchaseOrderList.remove(c);
			}
		});
	}

}
