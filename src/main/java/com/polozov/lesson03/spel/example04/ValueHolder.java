package com.polozov.lesson03.spel.example04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueHolder {

	private String value;

	public ValueHolder(@Value("#{systemProperties['java.home']}") String value) {
		System.out.println("created with value " + value);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ValueHolder{" +
				"value='" + value + '\'' +
				'}';
	}
}
