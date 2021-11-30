package com.eugene.hospitalmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.drugdao;
import com.eugene.hospitalmanagementsystem.models.Drug;
@Service
public class drugservice {
	@Autowired
	drugdao drugdao;
	
	
	
	
	public void addDrug(Drug drug) {
		drugdao.save(drug);}
	
	public Optional<Drug> getBydrugnumber(String drugidentity) {
			return drugdao.findById(drugidentity);}
	public Drug getBydrugidentity(String drugidentity) {
		return drugdao.findBydrugidentity(drugidentity);
	}
	
	public Drug getBydrugname(String drugname) {
		return drugdao.findBydrugname(drugname);
	}
		
	public List<Drug> getAllDrugs(){
	    return (List<Drug>) drugdao.findAll();}
	
	

}
