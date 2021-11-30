package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.Frequency;
import com.eugene.hospitalmanagementsystem.models.Patient;

public interface frequencydao extends CrudRepository<Frequency, String> {
	public Frequency getByfrequencyname(String frequencyname);
}
