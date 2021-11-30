package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="orders")
public class Order {
	@OneToOne
	@JoinColumn(name="usernumber")
	private User officername;
	@OneToMany(targetEntity=orderitem.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="order")
	 
	private List<orderitem> orderitems=new ArrayList<>();
	@Id
	private String ordernumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="patientnumber")
	private Patient patient;
	@Transient
	private int totalorderamount;
	@Transient
	private String patientid;
	
	
	public Order() {
	
	}
	public Order(User officername, List<orderitem> orderitems, Date date) {
		
		this.officername = officername;
		this.orderitems = orderitems;
		this.date = date;
	}
	public void additem(orderitem orderitem) {orderitems.add(orderitem);orderitem.setOrder(this);}
	public void removeitem(orderitem orderitem) {orderitems.remove(orderitem);orderitem.setOrder(null);}
	public User getOfficername() {
		return officername;
	}
	public void setOfficername(User officername) {
		this.officername = officername;
	}
	public List<orderitem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTotalorderamount() {
		return totalorderamount;
	}
	public void setTotalorderamount(int totalorderamount) {
		this.totalorderamount = totalorderamount;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	
	
}
	