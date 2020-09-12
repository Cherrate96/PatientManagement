package com.api;

import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.beans.Patient;

public interface PatientControllerApi {
	public ArrayList<Patient> getAllPatients();

	public ResponseEntity<?> getPatient(int id, UriComponentsBuilder uri);

	public ResponseEntity<?> enrollPatient(Patient P, UriComponentsBuilder uriBuilder);

	public ResponseEntity<?> updatePatient(Patient p,UriComponentsBuilder uri);
	
	public ResponseEntity<?> deletePatient(Patient p,UriComponentsBuilder uri);
}
