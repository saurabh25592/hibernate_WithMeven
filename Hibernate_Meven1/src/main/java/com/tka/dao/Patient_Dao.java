package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Patient;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Patient_Dao {

	public void insert() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		Patient p = new Patient();
		p.setName("swagat");
		p.setEmail("swagat12@gmail.com");
		p.setPass("h");

		ss.persist(p);
		System.out.println("data is save");
		tx.commit();
		ss.close();
	}

	public void delete() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		Patient p = new Patient();
		p.setId(1);
		ss.remove(p);
		System.out.println("data is remove....");

		tx.commit();
		ss.close();
	}

	public void update() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();

		Patient p = new Patient();
		p.setId(3);
		p.setName("om");
		p.setEmail("om21@gmail.com");
		p.setPass("321");

		ss.merge(p);
		System.out.println("data is updated..........");
		tx.commit();
		ss.close();

	}

	public void singleFletchData() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		int id=4;
		Patient p=ss.get(Patient.class, id);
	   System.out.println(p);
	   tx.commit();
	   System.out.println("single data is get");
	   ss.close();
	   
	}

	public void fletchAllData() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Patient.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		CriteriaBuilder cb=ss.getCriteriaBuilder();
		CriteriaQuery  cq=cb.createQuery();
		Root<Patient> root=cq.from(Patient.class);
		cq.select(root);
		
		Query q = ss.createQuery(cq);

		List<Patient> list=q.getResultList();
		
		for (Patient patient : list) {
			System.out.println(patient);
		}
		
		
		
		
	}

}
