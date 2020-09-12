package com.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.api.PatientControllerApi;
import com.api.PatientServiceApi;
import com.beans.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController implements PatientControllerApi {
	@Autowired
	private PatientServiceApi pService;

	@RequestMapping(value = "/getallpatients", method = RequestMethod.GET)
	public ArrayList<Patient> getAllPatients() {
		ArrayList<Patient> pList = new ArrayList<>();
		pList = pService.getAllPatients();
		return pList;
	}

	@RequestMapping(value = "/getpatient/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPatient(@PathVariable("id") int id, UriComponentsBuilder uri) {
		Patient p = null;
		ResponseEntity<?> entity = null;
		HttpHeaders header = new HttpHeaders();
		if (pService.checkPatient(id) == true) {
			p = pService.getPatient(id);
			entity = new ResponseEntity<Patient>(p, HttpStatus.FOUND);
		} else if (pService.checkPatient(id) == false) {
			header.setLocation(uri.path("/patient/repatient/{id}").buildAndExpand(id).toUri());
			//entity = new ResponseEntity<String>(header, HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body("PATIENT NOT FOUND");
		}
		return entity;
	}

	@RequestMapping(value = "/enrollpatient", method = RequestMethod.POST)
	public ResponseEntity<?> enrollPatient(@RequestBody Patient P, UriComponentsBuilder uriBuilder) {
		ResponseEntity<String> entity = null;
		HttpHeaders header = new HttpHeaders();
		Boolean status = pService.checkPatient(P.getpId());
		if (status == true) {
			header.setLocation(uriBuilder.path("/patient/getpatient/{id}").buildAndExpand(P.getpId()).toUri());
			entity = new ResponseEntity<String>(header, HttpStatus.CONFLICT);
		} else if (status == false) {
			Patient p2 = pService.enrollPatient(P);
			header.setLocation(uriBuilder.path("/patient/getpatient/{id}").buildAndExpand(p2.getpId()).toUri());
			entity = new ResponseEntity<String>(header, HttpStatus.CREATED);
		}
		return entity;
	}

	@RequestMapping(value = "/updatepatient", method = RequestMethod.PUT)
	public ResponseEntity<?> updatePatient(@RequestBody Patient p, UriComponentsBuilder uri) {
		ResponseEntity<?> entity = null;
		Patient p1 = null;
		HttpHeaders header = new HttpHeaders();
		if (pService.checkPatient(p.getpId()) == true) {
			p1 = pService.updatePatient(p);
			entity = new ResponseEntity<Patient>(p1, HttpStatus.OK);
		} else if (pService.checkPatient(p.getpId()) == false) {
			header.setLocation(uri.path("/patient/updatepatient/{id}").buildAndExpand(p.getpId()).toUri());
			entity = new ResponseEntity<String>(header, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/deletepatient", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePatient(@RequestBody Patient p, UriComponentsBuilder uri) {
		ResponseEntity<?> entity = null;
		HttpHeaders header = new HttpHeaders();
		if (pService.checkPatient(p.getpId()) == true) {
			pService.deletePatient(p);
			entity = new ResponseEntity<Patient>(p, HttpStatus.OK);
		} else if (pService.checkPatient(p.getpId()) == false) {
			header.setLocation(uri.path("/patient/updatepatient/{id}").buildAndExpand(p.getpId()).toUri());
			entity = new ResponseEntity<String>(header, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/deletepatient/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePatient(@PathVariable("id") int id, UriComponentsBuilder uri) {
		ResponseEntity<?> entity = null;
		HttpHeaders header = new HttpHeaders();
		if (pService.checkPatient(id) == true) {
			header.setLocation(uri.path("/patient/updatepatient/{id}").buildAndExpand(id).toUri());
			Patient p1 = pService.getPatient(id);
			pService.deletePatient(p1);
			entity = new ResponseEntity<String>(header, HttpStatus.OK);
		} else if (pService.checkPatient(id) == false) {
			header.setLocation(uri.path("/patient/updatepatient/{id}").buildAndExpand(id).toUri());
			entity = new ResponseEntity<String>(header, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

}
