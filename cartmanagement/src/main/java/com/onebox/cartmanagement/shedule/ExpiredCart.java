package com.onebox.cartmanagement.shedule;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.onebox.cartmanagement.repository.CartRepository;


public class ExpiredCart {
    
    @Autowired
    CartRepository cartRepository;

    @Scheduled(fixedRate=10000)
    @Transactional
	public void ExpiredCartTask(){
        cartRepository.deleteExpiredCart(new Date().getTime());
	}
}
