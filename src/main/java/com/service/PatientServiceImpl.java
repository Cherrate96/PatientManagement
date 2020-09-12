package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.PatientDaoApi;
import com.api.PatientServiceApi;
import com.beans.Patient;
import com.dao.PatientDaoImpl;

@Service
public class PatientServiceImpl implements PatientServiceApi {
	@Autowired
	private PatientDaoApi pDao;

	public ArrayList<Patient> getAllPatients() {
		ArrayList<Patient> pList = new ArrayList<>();
		pList = pDao.getAllPatients();
		return pList;
	}

	public Patient enrollPatient(Patient p) {
		Patient p1 = pDao.enrollPatient(p);
		return p1;
	}

	public boolean checkPatient(int pId) {
		boolean status = pDao.checkPatient(pId);
		return status;
	}
	public Patient getPatient(int pId) {
		Patient p=new Patient();
		p=pDao.getPatient(pId);
		return p;
	}

	public Patient updatePatient(Patient p) {
		Patient p1=new Patient();
		p1=pDao.updatePatient(p);
		return p1;
	}
	
	public void deletePatient(Patient p) {
		pDao.deletePatient(p);

	}
}
