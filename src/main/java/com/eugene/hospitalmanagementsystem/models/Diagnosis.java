package com.eugene.hospitalmanagementsystem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="diagnosis")
public class Diagnosis {
@ManyToOne (fetch=FetchType.LAZY)
@JoinColumn(name="patientnumber")
private Patient patient;

@Column(name="complaint")
private String complaint;
private String presentingillness;
private String genexam;
private String cardiovascular;
private String cns;
private String rs;
private String mss;
@Column(name="recommendations")
private String recommendations;


@OneToMany(mappedBy="diagnosis", cascade=CascadeType.ALL)
private List<Labform> lablist;
@OneToMany(mappedBy="diagnosis", cascade=CascadeType.ALL)
private List<Pharmform> pharmlist;

@Id
@Column(name="diagnosisnumber")
private String diagnosisnumber;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date date;
@Transient
private String patientid;


public Diagnosis() {
	
}


public Diagnosis(Patient patient,  String diagnosisnumber, Date date) {
	
	this.patient = patient;
	
	this.diagnosisnumber = diagnosisnumber;
	this.date = date;
}


public Patient getPatient() {
	return patient;
}


public void setPatient(Patient patient) {
	this.patient = patient;
}





public String getComplaint() {
	return complaint;
}


public void setComplaint(String complaint) {
	this.complaint = complaint;
}


public String getPresentingillness() {
	return presentingillness;
}


public void setPresentingillness(String presentingillness) {
	this.presentingillness = presentingillness;
}


public String getGenexam() {
	return genexam;
}


public void setGenexam(String genexam) {
	this.genexam = genexam;
}


public String getCardiovascular() {
	return cardiovascular;
}


public void setCardiovascular(String cardiovascular) {
	this.cardiovascular = cardiovascular;
}


public String getCns() {
	return cns;
}


public void setCns(String cns) {
	this.cns = cns;
}


public String getRs() {
	return rs;
}


public void setRs(String rs) {
	this.rs = rs;
}


public String getMss() {
	return mss;
}


public void setMss(String mss) {
	this.mss = mss;
}


public String getRecommendations() {
	return recommendations;
}


public void setRecommendations(String recommendations) {
	this.recommendations = recommendations;
}



public String getDiagnosisnumber() {
	return diagnosisnumber;
}


public void setDiagnosisnumber(String diagnosisnumber) {
	this.diagnosisnumber = diagnosisnumber;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public String getPatientid() {
	return patientid;
}


public void setPatientid(String patientid) {
	this.patientid = patientid;
}


public List<Labform> getLablist() {
	return lablist;
}


public void setLablist(List<Labform> lablist) {
	this.lablist = lablist;
}


public List<Pharmform> getPharmlist() {
	return pharmlist;
}


public void setPharmlist(List<Pharmform> pharmlist) {
	this.pharmlist = pharmlist;
}

}











