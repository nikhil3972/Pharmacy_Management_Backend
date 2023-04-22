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
				c.setMedicineName(medicine.getMedicineName());
				c.setDescription(medicine.getDescription());
				c.setDosage(medicine.getDosage());
				c.setPrice(medicine.getPrice());
				c.setManufactureDate(medicine.getManufactureDate());
				c.setExpiryDate(medicine.getExpiryDate());
				c.setCurrentStock(medicine.getCurrentStock());
				
				
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
