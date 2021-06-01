package com.polozov.lesson03.spel.example05;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Map;

public class ExampleRun {
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();

		{
			Expression expression = parser.parseExpression("{1,2,3,4}");
			Object value = expression.getValue();
			System.out.println(value.getClass() + " - " + value);
		}

		{
			Expression expression = parser.parseExpression("{name: 'Piter', date:'01-06-2021'}");
			Object value = expression.getValue();
			System.out.println(value.getClass() + " - " + value);
		}

		{
			Expression expression =
					parser.parseExpression("{name: {first:'Piter', last:'Jason'}, date:'01-06-2021'}");
			Map value = expression.getValue(Map.class);
			System.out.println(value.getClass() + " - " + value);
			System.out.println(value.get("name").getClass() + " - " + value.get("name"));
		}
	}
}
