package com.xunmaw.supermarket.dao;

import com.xunmaw.supermarket.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderDao {
	int countProvider();
	
	Provider getProviderById(String id);
	
	List<Provider> getAllProvider();
	
	List<Provider> getAllProvider(@Param("proName") String proName, @Param("proCode") String proCode);
	
	Provider getProviderAndBillListById(@Param("pid") int id);
	
	int add(Provider provider);
	
	int modify(Provider provider);
	
	int delete(@Param("id") String id);
}
