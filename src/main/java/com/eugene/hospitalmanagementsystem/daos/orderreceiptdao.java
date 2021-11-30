package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.orderreceipt;
import com.eugene.hospitalmanagementsystem.models.receipt;

public interface orderreceiptdao extends CrudRepository<orderreceipt, String> {
	public orderreceipt getByreceiptnumber(String receiptnumber);
}
