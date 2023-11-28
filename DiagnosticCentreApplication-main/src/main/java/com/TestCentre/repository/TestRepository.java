package com.TestCentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TestCentre.enitity.TestOrder;
@Repository
public interface TestRepository extends JpaRepository<TestOrder, Integer>{

}
