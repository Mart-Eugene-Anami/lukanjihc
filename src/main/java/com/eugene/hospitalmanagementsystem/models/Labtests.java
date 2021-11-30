package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="labtests")
public class Labtests {
	private String testname;
	@Id
	private String testid;
	private int charges;
	private String description;
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="labtestslist")
	private List<Labform> labforms=new ArrayList<>();
	
	
	
	
	public Labtests() {
		
	}
	public Labtests(String testname, String testid, int charges, String description) {
		
		this.testname = testname;
		this.testid = testid;
		this.charges = charges;
		this.description = description;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getTestid() {
		return testid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
