package com.manager.demo.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


import com.manager.demo.entity.Manufacturer;

public class  ManufacturerService {

	private int manufactureIdCount= 1;
	private List< Manufacturer> manufactureList =new CopyOnWriteArrayList<>();
	public   Manufacturer addManufacturer( Manufacturer manufacture) {
		manufacture.setId(manufactureIdCount);
		manufactureList.add(manufacture);
		manufactureIdCount++;
		return manufacture;
	}

	public List< Manufacturer>getManufacture(){
		return manufactureList;
	}
	public 	 Manufacturer getCustomer(int manufactureId) {
		return manufactureList.stream().filter(c -> c.getId()== manufactureId)
				.findFirst().get();
	}
	public  Manufacturer updateManufacture(int manufactureId,	 Manufacturer manufacture) {
		manufactureList.stream().forEach(c->{
			if(c.getId()== manufactureId) {
				c.setManufacturerName(manufacture.getManufacturerName());
				
				c.setMedicine(manufacture.getMedicine());
				
			}
		});
		return manufactureList.stream().filter(c->c.getId()== manufactureId).findFirst().get();
	}
	public void deleteManufacturer(int manufactureId) {
		manufactureList.stream().forEach(c->{
			if(c.getId()==manufactureId) {
				manufactureList.remove(c);
			}
		});
	}
}
