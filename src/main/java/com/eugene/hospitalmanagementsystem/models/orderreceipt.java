package com.eugene.hospitalmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="orderreceipt")
public class orderreceipt {
	@OneToOne
	@JoinColumn(name="usernumber")
	private User staff;
	
	
	private int total;
	@Transient
	private String ordernumber;
	@Transient
	private String usernumber;
	@OneToOne
	@JoinColumn(name="ordernumber")
	private Order order;
	@Id
	private String receiptnumber;
	
	
	
	
	
	
	
	
	
	
	public orderreceipt() {
		
	}
	public orderreceipt(int total, Order order, String receiptnumber) {
		
		
		this.total = total;
		this.order = order;
		this.receiptnumber = receiptnumber;
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
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getReceiptnumber() {
		return receiptnumber;
	}
	public void setReceiptnumber(String receiptnumber) {
		this.receiptnumber = receiptnumber;
	}
	
	
	
	
}
