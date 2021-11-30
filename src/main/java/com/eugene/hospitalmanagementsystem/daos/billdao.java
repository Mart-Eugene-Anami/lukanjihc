package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.bill;

public interface billdao extends CrudRepository<bill,String> {
	public bill getBybillnumber(String billnumber);
}
