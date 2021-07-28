package com.example.application.repositories;


import com.example.application.persistence.Billing;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
 
public interface BillingRepository extends CrudRepository<Billing, Long> {
    
    @Modifying
    @Query(value = "UPDATE billing SET total_charge = ?1 WHERE billing_id = ?2", nativeQuery = true)
    @Transactional(rollbackFor = Exception.class)
    int setBillingTotalCharge(Long billing, Long id);
    
    @Modifying
    @Query(value = "UPDATE billing SET status = ?1 WHERE billing_id = ?2", nativeQuery = true)
    @Transactional(rollbackFor = Exception.class)
    int setStatusOfBillingCharge(Long status, Long id);
    
}
