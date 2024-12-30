package com.dao;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Product;

public class Inventory {

	public void addProduct(int id, String name) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Product product = new Product(id, name);

		ss.save(product);
		tr.commit();
	}

	public void removeProduct(int id) {
		SessionFactory sf = new Configuration().addAnnotatedClass(Product.class).configure().buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Product p = ss.load(Product.class, id);
		ss.remove(p);
		tr.commit();
		ss.close();
	}
}
