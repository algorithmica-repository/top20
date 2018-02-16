package com.alg.top20.ds.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Calculator {
	
	public static int priority(char op) {
		if (op == '*' || op == '/')
			return 2;
		else if (op == '+' || op == '-')
			return 1;
		else
			return 0;
	}
	private static List<String> tokenize(String s) {
		List<String> tokens = new LinkedList<String>();
		String number = "";
		for(int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) 
				number += c;
			else {
				if(number.length() > 0) {
					tokens.add(number);
					number ="";
				}
				tokens.add(""+c);
			}				
		}
		tokens.add(number);
		return tokens;
	}
	
	//evaluate straight with infix order
	public static int calculate1(String s) {
		List<String> tokens = tokenize(s);
		int sign = 1;
		int res = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(String token: tokens) {
			token = token.trim();
			if(token.equals("+"))
				sign = 1;
			else if(token.equals("-"))
				sign = -1;
			else if(token.equals("(")) {
				st.push(res);
				st.push(sign);
				res = 0;
				sign = 1;
			} else if(token.equals(")")) {
				res = st.pop() * res + st.pop();
			} else {
				res += sign*Integer.parseInt(token);
			}
		}
		return res;
    }
	
	private static void eval(char op, Stack<Integer> operands) {
		int right = operands.pop();
		int left = operands.pop();
		if(op =='+') operands.push(left+right);
		else if(op == '-') operands.push(left-right);
		else if(op == '*') operands.push(left*right);
		else if(op =='/') operands.push(left/right);
		else System.out.println("Invalid operator");
	}
	
	//convert infix to postfix and evaluate on the fly while doing conversion
	public static int calculate2(String s) {
		Stack<Character> operators = new Stack<Character>();
		Stack<Integer> operands = new Stack<Integer>();
		
		List<String> tokens = tokenize(s);
		for (String token : tokens) {
			token = token.trim();
			if (!Character.isDigit(token.charAt(0))) {
				char op = token.charAt(0);
				if (op == '+' || op == '-' || op == '*' || op == '/') {
					while (!operators.empty() && priority(op) <= priority(operators.peek()))
						eval(operators.pop(), operands);
					operators.push(op);
				} else if (op == '(')
					operators.push(op);
				else {
					while (!operators.empty()) {
						char tmp = operators.pop();
						if (tmp == '(')
							break;
						eval(tmp, operands);
					}
				}
			} else
				operands.push(Integer.parseInt(token));
		}
		while(! operators.empty())
			eval(operators.pop(), operands);
		return operands.pop();
	}
	
	public static void main(String[] args) {
		System.out.println(calculate2(args[0]));
	}
}
