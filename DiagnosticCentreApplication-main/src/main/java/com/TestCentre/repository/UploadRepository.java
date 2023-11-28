package com.TestCentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestCentre.enitity.Image;
public interface UploadRepository extends JpaRepository<Image , Integer>{

}
