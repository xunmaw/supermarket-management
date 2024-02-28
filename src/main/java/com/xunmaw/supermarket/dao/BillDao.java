package com.xunmaw.supermarket.dao;

import com.xunmaw.supermarket.pojo.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDao {
	int add(Bill bill);
	
	List<Bill> getBillList(Bill bill);
	
	int deleteBillById(String delId);
	
	Bill getBillById(String id);
	
	int modify(Bill bill);
	
	int getBillCountByProviderId(String providerId);
}
