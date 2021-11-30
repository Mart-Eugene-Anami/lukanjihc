package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.orderitem;

public interface orderitemdao extends CrudRepository<orderitem, String> {
	public orderitem getByitemid(String itemid);
	
}
