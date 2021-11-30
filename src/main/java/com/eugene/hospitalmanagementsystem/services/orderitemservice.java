package com.eugene.hospitalmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Frequency;
import com.eugene.hospitalmanagementsystem.models.orderitem;
@Service
public class orderitemservice {
	
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.orderitemdao orderitemdao;
	@Autowired 
	com.eugene.hospitalmanagementsystem.models.Order order;
    @Autowired
    com.eugene.hospitalmanagementsystem.daos.drugdao drugdao;
	
	public void addOrderItem(orderitem orderitem) {
		int unitamount=orderitem.getDose();
		int duration=orderitem.getDuration();
		int frequency=orderitem.getFrequency().getFrequencynumber();
	int amountdispensed=unitamount*duration*frequency;
	
	int existingamount=orderitem.getDrug().getQuantity();
	Drug drug1=orderitem.getDrug();
	if (existingamount<10) {System.out.println("Drug Quantity Too Low For Dispensing");}
	
	else {
		drug1.setQuantity(existingamount-amountdispensed);
		drugdao.save(drug1);
		orderitem.setAmount(amountdispensed*drug1.getUnitprice());
	orderitemdao.save(orderitem);}
	
    }
	public orderitem getOrderitem(String itemid ) {
		return orderitemdao.getByitemid(itemid);
	}
	
	/*public List<orderitem> getByOrderNumber(String ordernumber){
		List<orderitem> itemslist= orderitemdao.getByOrdernumber(ordernumber);
		int sum=0;
		for (orderitem oi: itemslist) {sum+=oi.getDrug().getUnitprice();}
		order.setTotalorderamount(sum);
		return itemslist;
	}*/
}
