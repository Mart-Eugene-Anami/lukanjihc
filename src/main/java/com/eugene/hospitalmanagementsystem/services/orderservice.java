package com.eugene.hospitalmanagementsystem.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.daos.drugdao;
import com.eugene.hospitalmanagementsystem.daos.orderdao;
import com.eugene.hospitalmanagementsystem.models.Order;
import com.eugene.hospitalmanagementsystem.models.orderitem;
@Service
public class orderservice {
	@Autowired 
	drugdao drugdao;
	@Autowired 
	orderdao orderdao;
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.orderitemdao orderitemdao;

	
	public void addOrder(Order order) {
		orderdao.save(order);
		
	}
	public Order getByordernumber(String ordernumber) {
		Order order= orderdao.getByordernumber(ordernumber);
		
		
		int sum=0;
		for (orderitem orderitem: order.getOrderitems()) {
			sum+=orderitem.getAmount();
		}
		order.setTotalorderamount(sum);
		
		return order;
	}
	public List<Order>getAllOrders(){
		return (List<Order>) orderdao.findAll();
	}
}
