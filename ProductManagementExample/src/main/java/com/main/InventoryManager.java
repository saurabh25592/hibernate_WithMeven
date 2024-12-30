package com.main;

import java.util.Scanner;

import com.dao.Inventory;

public class InventoryManager {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = sc.nextInt();
//		System.out.println("Enter the name:");
//		String name = sc.next();

		Inventory i = new Inventory();
//		i.addProduct(id, name);
		i.removeProduct(id);
		
	}

}
