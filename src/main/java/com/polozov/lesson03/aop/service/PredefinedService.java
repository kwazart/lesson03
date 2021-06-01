package com.polozov.lesson03.aop.service;

import com.polozov.lesson03.aop.aspect.MeasureMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*

class MyClass {
	@Transactional
	public String methodA() {
		methodB();
	}

	@Transactional
	public String methodB(){
	}
 */

@Service
public class PredefinedService {

	private PredefinedService selfLink;

	public PredefinedService() {
		System.out.println("construction");
	}

	@Autowired
	public void setSelfLink(PredefinedService selfLink) {
		System.out.println("Set self link");
		this.selfLink = selfLink;
	}

	@MeasureMethod
	public String getString() {
		System.out.println("called PredefinedService.getString");
		return "someString";
	}

	public String getError() {
		System.out.println("called PredefinedService.getError");
		getString();
		if (1 == 1) {
			throw  new RuntimeException("Test RE");
		}
		return "";
	}

	public String getStringThroughSelfLink() {
		System.out.println("called PredefinedService.getStringThroughSelfLink");
		return selfLink.getString();
	}
}
