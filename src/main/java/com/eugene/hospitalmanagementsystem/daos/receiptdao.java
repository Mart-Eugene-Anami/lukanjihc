package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.receipt;

public interface receiptdao extends CrudRepository<receipt, String> {
	public receipt getByreceiptnumber(String receiptnumber);
}
