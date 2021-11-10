package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.CustomerDetails;

public interface ICustomerDao extends JpaRepository<CustomerDetails, Integer> {

}
