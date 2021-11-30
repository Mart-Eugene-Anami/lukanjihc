package com.eugene.hospitalmanagementsystem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="pharmacy")
public class Pharmform {
	@Id
	@Column(name="identity")	
private String id;
private String remarks;
private Date date;

@ManyToOne (fetch=FetchType.LAZY)
@JoinColumn(name="diagnosisnumber")
private Diagnosis diagnosis;
@OneToOne
@JoinColumn(name="ordernumber")
private Order order;
@OneToOne
@JoinColumn(name="usernumber")
private User pharmofficer;


public Pharmform() {}


public Pharmform(String remarks, Date date) {
	
	this.remarks = remarks;
	this.date = date;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}


public Diagnosis getDiagnosis() {
	return diagnosis;
}


public void setDiagnosis(Diagnosis diagnosis) {
	this.diagnosis = diagnosis;
}


public Order getOrder() {
	return order;
}


public void setOrder(Order order) {
	this.order = order;
}


public User getPharmofficer() {
	return pharmofficer;
}


public void setPharmofficer(User pharmofficer) {
	this.pharmofficer = pharmofficer;
}



}
