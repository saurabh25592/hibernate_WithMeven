package com.example.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class Student_Dao {

    @Autowired
    SessionFactory factory;

    public String add(Student student) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        return "Data is transferred.";
    }

    public String delete(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
            transaction.commit();
        } else {
            transaction.rollback();
            return "Student not found.";
        }
        session.close();
        return "Data is deleted.";
    }

    public String updateData(Student student, int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student existingStudent = session.get(Student.class, id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            session.merge(existingStudent);
            transaction.commit();
        } else {
            transaction.rollback();
            return "Student not found.";
        }
        session.close();
        return "Data is updated.";
    }

    public Student getSingleData(int id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public List<Student> getAllData() {
        Session session = factory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        List<Student> students = session.createQuery(cq).getResultList();
        session.close();
        return students;
    }
}
