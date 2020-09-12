package com.api;

import java.util.ArrayList;

import com.beans.Patient;

public interface PatientDaoApi {
	public ArrayList<Patient> getAllPatients();

	public boolean checkPatient(int pId);

	public Patient enrollPatient(Patient p);

	public Patient getPatient(int pId);
	
	public Patient updatePatient(Patient p);
	
	public void deletePatient(Patient p);

}
