package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.Student;

public interface HomeService {

	public void saveData(Student s);
	public Student logincheck(String un,String ps);
	public List<Student> displayData();
	public void deleteData(int uid);
	
}
