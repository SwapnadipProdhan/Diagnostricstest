package com.TestCentre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestCentre.enitity.TestOrder;
import com.TestCentre.repository.TestRepository;

@Service
public class TestService {
	@Autowired
	private TestRepository testRepo;
	
	public void save(TestOrder testOrder)
	{
		testRepo.save(testOrder);
	}
	
	public List<TestOrder> getAllTest()
	{
		return testRepo.findAll();
	}
	
	public TestOrder getTestById(int id)
	{
		return testRepo.findById(id).get();
		
	}
	
	public void deleteById(int id)
	{
		testRepo.deleteById(id);
	}
}
