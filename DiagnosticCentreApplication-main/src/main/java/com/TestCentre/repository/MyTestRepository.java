package com.TestCentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestCentre.enitity.MyTest;
@Repository
public interface MyTestRepository extends JpaRepository<MyTest, Integer>
{
	

}
