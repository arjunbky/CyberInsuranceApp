package com.cg.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.ICustomerDao;
import com.cg.dto.CustomerDto;
import com.cg.entity.CustomerDetails;
import com.cg.service.CustomerDetailService;


@RestController
@RequestMapping("/customer")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailService customerService;
	
	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerdto){
		customerService.addCustomer(customerdto);
		return new ResponseEntity<String>("Customer Added",HttpStatus.OK);

}
}
