package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Student;
import com.example.service.Std_Service;

@RestController
@RequestMapping("/student")
public class Controller {

	@Autowired
	Std_Service service;

	@PostMapping("/add") // Changed from @GetMapping to @PostMapping for data submission
	public String add(@RequestBody Student student) {
		return service.add(student);
	}

	@DeleteMapping("/delete/{id}")
	public String add(@PathVariable("id") int id) {
		return service.delete(id);
	}
	
	@PutMapping("/changDetail/{id}")
    public String updateData(@RequestBody Student student, @PathVariable("id") int id) {
        return service.updateData(student, id);
    }
	
	@GetMapping("/singleStudentDetail/{id}")
	 public Student getSingleData(@PathVariable("id") int id) {
	        return service.getSingleData(id);
	    }
	
	
	
	@GetMapping("/AllStudentDetail")
	  public List<Student> getAllData() {
	        return service.getAllData();
	    }
	
	
	
	
	
	
	
}
