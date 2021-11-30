package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.Labtests;

public interface labtestsdao extends CrudRepository <Labtests, String>{
	public Labtests getBytestid(String testid);
}
