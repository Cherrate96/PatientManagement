package com.interfaces;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beans.Patient;

@Repository
public interface DbConnector extends JpaRepository<Patient, Integer> {
	@Query("select p from Patient p")
	public ArrayList<Patient>getAllPatientsUsingQuery();
	
}
