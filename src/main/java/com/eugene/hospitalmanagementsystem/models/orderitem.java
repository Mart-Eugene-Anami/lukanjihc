package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="orderitems")
public class orderitem {
	   
	   @OneToOne
	   @JoinColumn(name="drugidentity")
		private Drug drug;
		
	    @OneToOne
	    @JoinColumn(name="modeid")
		private Mode mode;
		private int dose;
		@OneToOne
		@JoinColumn(name="frequencyname")
		private Frequency frequency;
		private int duration;
		@Id
		@Column(name="itemid")
		private String itemid;
		@ManyToOne(targetEntity=Order.class, fetch=FetchType.LAZY)
		@JoinColumn(name="ordernumber")
		private Order order;
		private int amount;
		@Transient
		private String ordernumber;
		
		
		public orderitem() {
			
		}
		
		
		


	public orderitem(Drug drug, Mode mode, int dose, Frequency frequency, int duration) {
			
			this.drug = drug;
			this.mode = mode;
			this.dose = dose;
			this.frequency = frequency;
			this.duration = duration;
		}





		


	




		





		public Order getOrder() {
		return order;
	}





	public void setOrder(Order order) {
		this.order = order;
	}





		public void setOrdernumber(String ordernumber) {
			this.ordernumber = ordernumber;
		}




public Drug getDrug() {
			return drug;
		}





		public void setDrug(Drug drug) {
			this.drug = drug;
		}





		public Mode getMode() {
			return mode;
		}





		public void setMode(Mode mode) {
			this.mode = mode;
		}





		public Frequency getFrequency() {
			return frequency;
		}





		public void setFrequency(Frequency frequency) {
			this.frequency = frequency;
		}





public int getDose() {
			return dose;
		}
public void setDose(int dose) {
			this.dose = dose;
		}

public int getDuration() {
			return duration;
		}
public void setDuration(int duration) {
			this.duration = duration;
		}

public String getItemid() {
	return itemid;
}
public void setItemid(String itemid) {
	this.itemid = itemid;
}


public String getOrdernumber() {
	return ordernumber;
}


public void setOrderid(String ordernumber) {
	this.ordernumber = ordernumber;
}










public int getAmount() {
	return amount;
}





public void setAmount(int amount) {
	this.amount = amount;
}




}

