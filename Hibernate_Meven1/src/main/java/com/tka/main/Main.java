package com.tka.main;

import com.tka.service.Patient_Service;

public class Main {
	
	public static void main(String[] args) {
		
		Patient_Service p=new Patient_Service();
//		p.insertData();
//		p.deleteData();
//		p.updateData();
//      p.singleData();
        p.fetchAllData();
		
		
	}

	
}
