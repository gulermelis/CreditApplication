package com.kocfinans.creditapp.repository;

import com.kocfinans.creditapp.domain.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditAppRepository extends JpaRepository<CustomerInfo, Long> {
	
	
}