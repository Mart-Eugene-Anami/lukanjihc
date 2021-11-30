package com.eugene.hospitalmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Pharmform;

@Service
public class pharmservice {
	
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.pharmdao pharmdao;
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.drugdao drugdao;
	
	
public void savePharmForm(Pharmform pharmform) {}	
public Optional<Pharmform> getByid(String id) {
	return pharmdao.findById(id);
	
}
public List<Pharmform> getAllPharmRecords(){
	return (List<Pharmform>) pharmdao.findAll();
}
public List<Drug> getLowQuantities() {
	return (List<Drug>)drugdao.getAllDepletedDrugs();
}
}
