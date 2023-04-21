package com.manager.demo.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.manager.demo.entity.Medicine;

public class MedicineService {
	private int medicineIdCount= 1;
	private List< Medicine> medicineList =new CopyOnWriteArrayList<>();
	public   Medicine addManufacturer( Medicine medicine) {
		medicine.setId(medicineIdCount);
		medicineList.add(medicine);
		medicineIdCount++;
		return medicine;
	}

	public List<Medicine>getmanufacture(){
		return medicineList;
	}
	public Medicine getCustomer(int medicineId) {
		return medicineList.stream().filter(c -> c.getId()== medicineId)
				.findFirst().get();
	}
	public  Medicine updateMedicine(int medicineId,Medicine medicine) {
		medicineList.stream().forEach(c->{
			if(c.getId()== medicineId) {
				c.setName(medicine.getName());
				c.setDescription(medicine.getDescription());
				c.setDosage(medicine.getDosage());
				c.setPrice(medicine.getPrice());
				c.setManufacture_date(medicine.getManufacture_date());
				c.setExpiry_date(medicine.getExpiry_date());
				c.setCurrent_stock(medicine.getCurrent_stock());
				
				
			}
		});
		return medicineList.stream().filter(c->c.getId()== medicineId).findFirst().get();
	}
	public void deleteMedicine(int medicineId) {
		medicineList.stream().forEach(c->{
			if(c.getId()==medicineId) {
				medicineList.remove(c);
			}
		});
	}

}
