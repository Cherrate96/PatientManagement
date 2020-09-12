package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.api.PatientDaoApi;
import com.beans.Patient;
import com.interfaces.DbConnector;

@Component
@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
public class PatientDaoImpl implements PatientDaoApi {
	@Autowired
	private DbConnector dbTool;

	public ArrayList<Patient> getAllPatients() {
		ArrayList<Patient> pList = new ArrayList<>();
		//pList = (ArrayList<Patient>) dbTool.findAll();
		pList = (ArrayList<Patient>) dbTool.getAllPatientsUsingQuery();
		/*
		 * Patient p1=new Patient(); p1.setpId(01); p1.setpFirstName("RAM");
		 * p1.setpLastName("KUMAR"); p1.setPgender("MALE"); p1.setpContactNumber((long)
		 * 123456787); pList.add(p1);
		 */ return pList;
	}

	public boolean checkPatient(int pId) {
		boolean status = false;
		if (dbTool.existsById(pId)) {
			status = true;
		}
		return status;
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Patient enrollPatient(Patient p) {
		dbTool.save(p);
		if(p.getpId()==110) {
			throw new RuntimeException("ROLL BACK TEST");
		}
		return p;
	}
	
	public Patient getPatient(int pId) {
		Patient p=new Patient();
		p=dbTool.getOne(pId);
		return p;
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Patient updatePatient(Patient p) {
		Patient p1=new Patient();
		p1=dbTool.save(p);
		return p1;
	}
	public void deletePatient(Patient p) {
		dbTool.delete(p);
	}
}
