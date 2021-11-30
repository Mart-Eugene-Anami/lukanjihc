package com.eugene.hospitalmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="frequencies")
public class Frequency {
@Id
private String frequencyname;
private int frequencynumber;


public Frequency() {}

public Frequency(String frequencyname, int frequencynumber) {
	
	this.frequencyname = frequencyname;
	this.frequencynumber = frequencynumber;
}

public String getFrequencyname() {
	return frequencyname;
}

public void setFrequencyname(String frequencyname) {
	this.frequencyname = frequencyname;
}

public int getFrequencynumber() {
	return frequencynumber;
}
public void setFrequencynumber(int frequencynumber) {
	this.frequencynumber = frequencynumber;
}



}
