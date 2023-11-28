package com.TestCentre.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyTest")
public class MyTest {
	@Id
	private int id;
	private String name;
	private String doctor;
	private String test;
	//private String imageName;
	
	public int getId() {
	 return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	
	
	

	/*public MyTest(int id, String name, String doctor, String test , String ) {
		super();
		this.id = id;
		this.name = name;
		this.doctor = doctor;
		this.test = test;
	}*/
	
	/*public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}*/
	public MyTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyTest(int id, String name, String doctor, String test ) {
		super();
		this.id = id;
		this.name = name;
		this.doctor = doctor;
		this.test = test;
		//this.imageName=imageName;
		
	}

	
	
}
