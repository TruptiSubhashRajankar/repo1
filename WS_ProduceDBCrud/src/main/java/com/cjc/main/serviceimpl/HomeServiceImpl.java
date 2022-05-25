package com.cjc.main.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService {

@Autowired
HomeRepository hr;
@Override
public void saveData(Student s)
{hr.save(s);

}
@Override
public Student logincheck(String un, String ps) {
	// TODO Auto-generated method stub
 return	hr.findAllByUnameAndPassword( un, ps);	
}
@Override
public List<Student> displayData() {
	// TODO Auto-generated method stub
	return (List<Student>) hr.findAll() ;
}
@Override
public void deleteData(int uid) {
	// TODO Auto-generated method stub
	hr.deleteById(uid);
}

}
