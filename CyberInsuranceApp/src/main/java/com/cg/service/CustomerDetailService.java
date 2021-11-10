package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ICustomerDao;
import com.cg.dto.CustomerDto;
import com.cg.entity.CustomerDetails;
@Service
public class CustomerDetailService {
	@Autowired 
	ICustomerDao customerDao;
	
	  public void addCustomer(CustomerDto customerdto ) {
		CustomerDetails customer=new CustomerDetails();
		customer.setFirstName(customerdto.getFirstName());
		customer.setLastName(customerdto.getLastName());
		customer.setPhoneNo(customerdto.getPhoneNo());
		customer.setCity(customerdto.getCity());
		customer.setState(customerdto.getState());
		customer.setAddress(customerdto.getAddress());
		customer.setCountry(customerdto.getCountry());
		customer.setZipCode(customerdto.getZipcode());
		customer.setTermType(customerdto.getTermType());
		customer.setEffectiveDate(customerdto.getEffectiveDate());
		
		customerDao.save(customer);
		
		  
		  
		  
	  }
}
