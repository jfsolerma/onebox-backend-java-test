package com.onebox.cartmanagement.config.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.onebox.cartmanagement.shedule.ExpiredCart;

@Configuration
@EnableScheduling
public class Schedule {

	@Bean
	public ExpiredCart expiredCart() {
		return new ExpiredCart();
	}

}
