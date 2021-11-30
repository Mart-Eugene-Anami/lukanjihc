package com.eugene.hospitalmanagementsystem.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="patients")
public class Patient {
	

@Column(name="gender")
private String gender;
@Column(name="patientname")
private String patientname;

@Column(name="patientcontact")
private String patientcontact;
@Id
@Column(name="patientnumber")
private String patientnumber;


@OneToMany(mappedBy="patient", cascade=CascadeType.ALL)
private List<bill>bills;
@OneToMany(mappedBy="patient", cascade=CascadeType.ALL)
private List<Order> orders;
@OneToMany(mappedBy="patient", cascade=CascadeType.ALL)
private List<Diagnosis>diagnosislist;



public Patient() {
	
}






public Patient(String gender, String patientname, String patientcontact,
		String patientnumber) {
	
	this.gender = gender;
	this.patientname = patientname;

	this.patientcontact = patientcontact;
	this.patientnumber = patientnumber;
}






public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

public String getPatientname() {
	return patientname;
}






public void setPatientname(String patientname) {
	this.patientname = patientname;
}






public String getPatientcontact() {
	return patientcontact;
}
public void setPatientcontact(String patientcontact) {
	this.patientcontact = patientcontact;
}

public String getPatientnumber() {
	return patientnumber;
}

public void setPatientnumber(String patientnumber) {
	this.patientnumber = patientnumber;
}

public List<bill> getBills() {
	return bills;
}






public void setBills(List<bill> bills) {
	this.bills = bills;
}






public List<Order> getOrders() {
	return orders;
}






public void setOrders(List<Order> orders) {
	this.orders = orders;
}






public List<Diagnosis> getDiagnosislist() {
	return diagnosislist;
}






public void setDiagnosislist(List<Diagnosis> diagnosislist) {
	this.diagnosislist = diagnosislist;
}








}
