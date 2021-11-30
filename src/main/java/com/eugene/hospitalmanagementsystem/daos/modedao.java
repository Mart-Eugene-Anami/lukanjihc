package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.Mode;
import com.eugene.hospitalmanagementsystem.models.Patient;

public interface modedao extends CrudRepository<Mode, String>{
	public Mode getBymodeid(String modeid);
}
