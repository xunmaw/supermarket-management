package com.xunmaw.supermarket.service.provider;

import com.xunmaw.supermarket.pojo.Provider;

import java.util.List;

public interface ProviderService {
 
	boolean add(Provider provider);
	
	List<Provider> getProviderList(String proName, String proCode);
	
	int deleteProviderById(String delId);
	
	Provider getProviderById(String id);
	
	boolean modify(Provider provider);
}
