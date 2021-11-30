package com.eugene.hospitalmanagementsystem.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="billreceipt")
public class receipt {
	@OneToOne
	@JoinColumn(name="usernumber")
	private User staff;
	
	
	private int total;
	@Transient
	private String billnumber;
	@Transient
	private String usernumber;
	@OneToOne
	@JoinColumn(name="billnumber")
	private bill bill;
	@Id
	private String receiptnumber;
	
	
	
	
	
	
	
	public receipt() {
		
	}
	public receipt(User staff, com.eugene.hospitalmanagementsystem.models.bill bill) {
		
		this.staff = staff;
		
		this.bill = bill;
	}
	public User getStaff() {
		return staff;
	}
	public void setStaff(User staff) {
		this.staff = staff;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public bill getBill() {
		return bill;
	}
	public void setBill(bill bill) {
		this.bill = bill;
	}
	public String getReceiptnumber() {
		return receiptnumber;
	}
	public void setReceiptnumber(String receiptnumber) {
		this.receiptnumber = receiptnumber;
	}
	public String getBillnumber() {
		return billnumber;
	}
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	
	
	
	
	
	

}
