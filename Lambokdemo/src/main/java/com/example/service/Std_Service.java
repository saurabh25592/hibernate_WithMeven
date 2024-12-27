package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.Student_Dao;
import com.example.demo.entity.Student;

@Service
public class Std_Service {

    @Autowired
    Student_Dao dao;

    public String add(Student student) {
        return dao.add(student);
    }

    public String delete(int id) {
        return dao.delete(id);
    }

    public String updateData(Student student, int id) {
        return dao.updateData(student, id);
    }

    public Student getSingleData(int id) {
        return dao.getSingleData(id);
    }

    public List<Student> getAllData() {
        return dao.getAllData();
    }
}
