package com.tka.service;

import com.tka.dao.Patient_Dao;

public class Patient_Service {

	public void insertData() {
		Patient_Dao p = new Patient_Dao();
		p.insert();
	}

	public void deleteData() {
		Patient_Dao p = new Patient_Dao();
        p.delete();
	}

	public void updateData() {
		Patient_Dao p = new Patient_Dao();
         p.update(); 
	}

	public void singleData() {
		Patient_Dao p = new Patient_Dao();
        p.singleFletchData(); 	
	}

	public void fetchAllData() {
		Patient_Dao p = new Patient_Dao();
		p.fletchAllData();
	}
}
