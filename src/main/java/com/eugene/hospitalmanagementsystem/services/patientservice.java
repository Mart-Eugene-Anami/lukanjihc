package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.patientdao;
import com.eugene.hospitalmanagementsystem.models.Patient;

@Service
public class patientservice {
	@Autowired
	patientdao patientdao;
	
	
	public void addPatient(Patient patient) {
	patientdao.save(patient);}
	
	public Patient getBypatientnumber(String patientnumber) {
		return patientdao.getBypatientnumber(patientnumber);
		
	}
     public List<Patient> getAllPatientRecords(){
    	 return patientdao.getAllPatientRecords();
    	 
     }
     public Patient getPatients(String patientname){
    	 return patientdao.getBypatientname(patientname);
    	 
     }
}
