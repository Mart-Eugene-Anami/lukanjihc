package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.Frequency;

@Service
public class frequencyservice {
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.frequencydao frequencydao;

	public void addFrequency(Frequency frequency) {
		frequencydao.save(frequency);
	
}
	public List<Frequency> getAllFrequencies(){
		return (List<Frequency>)frequencydao.findAll();
	}
	public Frequency getByFrequencyname(String frequencyname) {
		return frequencydao.getByfrequencyname(frequencyname);
	}
}
