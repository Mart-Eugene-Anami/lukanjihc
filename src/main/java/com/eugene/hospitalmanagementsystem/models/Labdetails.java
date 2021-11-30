package com.eugene.hospitalmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="labdetails")
public class Labdetails {
	@Id
	private String formnumber;
	private String findings;
	@OneToOne
	@JoinColumn(name="usernumber")
	private User staff;
	private String labnotes;
	@OneToOne
	@JoinColumn(name="formid")
	private Labform labform;
	
	
	
	
	
	
	
	
	
	public Labdetails() {
		
	}
	public Labdetails(String findings, User staff, String labnotes) {
		
		this.findings = findings;
		this.staff = staff;
		this.labnotes = labnotes;
	}
	public String getFindings() {
		return findings;
	}
	public void setFindings(String findings) {
		this.findings = findings;
	}
	
	public User getStaff() {
		return staff;
	}
	public void setStaff(User staff) {
		this.staff = staff;
	}
	public String getLabnotes() {
		return labnotes;
	}
	public void setLabnotes(String labnotes) {
		this.labnotes = labnotes;
	}
	public Labform getLabform() {
		return labform;
	}
	public void setLabform(Labform labform) {
		this.labform = labform;
	}
	public String getFormnumber() {
		return formnumber;
	}
	public void setFormnumber(String formnumber) {
		this.formnumber = formnumber;
	}
	
	
	
	

}
