package com.polozov.lesson03;

import com.polozov.lesson03.aop.service.PredefinedService;
import com.polozov.lesson03.aop.service.RndService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson03Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lesson03Application.class, args);

		System.out.println("*****************************");
		RndService rndService = context.getBean(RndService.class);
		System.out.println(rndService.getString());
		System.out.println("*****************************");

		System.out.println("*****************************");
		PredefinedService predefinedService = context.getBean(PredefinedService.class);
		System.out.println(predefinedService.getString());
		System.out.println("*****************************");

		System.out.println("*****************************");
		System.out.println(predefinedService.getStringThroughSelfLink());
		System.out.println("*****************************");

		System.out.println("*****************************");
		try {
			String error = predefinedService.getError();
		} catch (Exception e) {}
		System.out.println("*****************************");
	}

}
