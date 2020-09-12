package com.api;

import java.util.ArrayList;

import com.beans.Patient;

public interface PatientServiceApi {

	public ArrayList<Patient> getAllPatients();

	public Patient enrollPatient(Patient p);

	public boolean checkPatient(int pId);
	
	public Patient getPatient(int pId);
	
	public Patient updatePatient(Patient p);

	public void deletePatient(Patient p);


}
