package com.eugene.hospitalmanagementsystem.daos;

import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.Order;

public interface orderdao extends CrudRepository<Order, String> {
public Order getByordernumber(String ordernumber);
}
