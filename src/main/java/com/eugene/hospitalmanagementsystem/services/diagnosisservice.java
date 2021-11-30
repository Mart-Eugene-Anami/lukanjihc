package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.diagnosisdao;
import com.eugene.hospitalmanagementsystem.models.Diagnosis;

@Service
public class diagnosisservice {
	
	@Autowired
	diagnosisdao diagnosisdao;
 
	
	
	public List<Diagnosis> getAllDiagnosisRecords(){
	 return diagnosisdao.getAllDiagnosisRecords();
 }
	
	public void addDiagnosis(Diagnosis diagnosis) {
		diagnosisdao.save(diagnosis);
	}
	
	public Diagnosis getBydiagnosisnumber(String diagnosisnumber) {
		return diagnosisdao.getBydiagnosisnumber(diagnosisnumber);
		
	}
}
