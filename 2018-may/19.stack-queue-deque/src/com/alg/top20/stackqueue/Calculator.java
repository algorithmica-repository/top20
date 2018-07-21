package com.alg.top20.stackqueue;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calculator {

	public static int calculator1(String s) {
		return 0;
	}
	private static List<String> tokenize(String s) {
		List<String> tokens = new ArrayList<String>();
		String res = "";
		for(int i = 0; i < s.length(); ++i) {
			if(Character.isDigit(s.charAt(i))) {
				res = res + s.charAt(i);
			}
			else {
				if(res.trim().length() > 0)
					tokens.add(res);
				tokens.add(Character.toString(s.charAt(i)));
				res = "";
			}			
		}
		if(res.trim().length() > 0)
			tokens.add(res);
		return tokens;
	}
	private static int priority(String op) {
		if(op.equals("(")) return -4;
		else if(op.equals("*") || op.equals("/"))
			return -2;
		else 
			return -3;
	}
	private static void eval(Stack<String> operands, Stack<String> operators) {
		String op = operators.pop();
		
		int right = Integer.parseInt(operands.pop());
		int left = Integer.parseInt(operands.pop());
		if(op.equals("+"))
			operands.push(Integer.toString(left + right));
		else if(op.equals("-"))
			operands.push(Integer.toString(left - right));
		else if(op.equals("*"))
			operands.push(Integer.toString(left * right));
		else if(op.equals("/"))
			operands.push(Integer.toString(left / right));
		
	}
	public static int calculator2(String s) {
		Stack<String> operands = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		
		List<String> tokens = tokenize(s);
		System.out.println(tokens);
		for(String token: tokens) {
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ) {
				while(!operators.isEmpty() && priority(operators.peek()) >= priority(token))
					eval(operands, operators);
				operators.push(token);
			} else if(token.equals("(")) {
				operators.push(token);
			} else if(token.equals(")")) {
				while(!operators.peek().equals("("))
					eval(operands, operators);
				operators.pop();
			} else {
				operands.push(token);
			}			
		}
		while(!operators.isEmpty())
			eval(operands, operators);
		return Integer.parseInt(operands.peek());
	}
	public static void main(String[] args) {
		System.out.println(calculator2(args[0]));
	}

}
