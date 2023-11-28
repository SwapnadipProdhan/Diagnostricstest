package com.TestCentre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestCentre.enitity.MyTest;
import com.TestCentre.repository.MyTestRepository;

@Service
public class MyTestService {
	@Autowired
	private MyTestRepository mytestRepo; 
	
	public void saveMyTest(MyTest test)
	{
	   mytestRepo.save(test);	
	}
	
	public List<MyTest> getAllMyTest()
	{
		return mytestRepo.findAll();
	}
	
	public void deleteById(int id)
	{
		mytestRepo.deleteById(id);
	}
	
	
	
}
