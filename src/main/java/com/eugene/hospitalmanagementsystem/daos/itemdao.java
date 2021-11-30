package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.Item;

public interface itemdao extends CrudRepository<Item, String> {
	public Item getByidentity(String identity);
}
