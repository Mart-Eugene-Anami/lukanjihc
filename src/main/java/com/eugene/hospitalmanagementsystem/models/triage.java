package com.eugene.hospitalmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="triage")
public class triage {
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="patientnumber")	
private Patient patient;
private String temperature;
private String bloodpressure;
private String respiratoryrate;
private String pulse;
@Id
private String triagenumber;
@Transient
private String patientid;
	
 





public triage() {
	
}

public triage(Patient patient, String temperature, String bloodpressure, String respiratoryrate, String pulse) {
	
	this.patient = patient;
	this.temperature = temperature;
	this.bloodpressure = bloodpressure;
	this.respiratoryrate = respiratoryrate;
	this.pulse = pulse;
}


public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}

public String getTemperature() {
	return temperature;
}

public void setTemperature(String temperature) {
	this.temperature = temperature;
}

public String getBloodpressure() {
	return bloodpressure;
}

public void setBloodpressure(String bloodpressure) {
	this.bloodpressure = bloodpressure;
}

public String getRespiratoryrate() {
	return respiratoryrate;
}

public void setRespiratoryrate(String respiratoryrate) {
	this.respiratoryrate = respiratoryrate;
}

public String getPulse() {
	return pulse;
}

public void setPulse(String pulse) {
	this.pulse = pulse;
}

public String getTriagenumber() {
	return triagenumber;
}
public void setTriagenumber(String triagenumber) {
	this.triagenumber = triagenumber;
}

public String getPatientid() {
	return patientid;
}

public void setPatientid(String patientid) {
	this.patientid = patientid;
}


}
