package com.alg.top20.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {

	private static boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*")
				|| token.equals("/");
	}

	private static int priority(String op) {
		if (op.equals("+") || op.equals("-"))
			return 1;
		else if (op.equals("*") || op.equals("/"))
			return 2;
		return -1;
	}

	private static int eval(String op, int left, int right) {
		switch (op.charAt(0)) {
		case '+':
			return left + right;
		case '-':
			return left - right;
		case '*':
			return left * right;
		case '/':
			return left / right;
		}
		return 0;
	}

	private static List<String> parse(String in) {
		List<String> tokens = new LinkedList<String>();
		StringTokenizer st = new StringTokenizer(in, "+-*/", true);
		while(st.hasMoreElements())
			tokens.add(st.nextToken());
		return tokens;
	}
	public static int calculator1(String in) {
		Stack<Integer> operands = new Stack<Integer>();
		Stack<String> operators = new Stack<String>();

		List<String> tokens = parse(in);
		for (String token : tokens) {
			if (isOperator(token)) {
				while (!operators.isEmpty()
						&& priority(operators.peek()) >= priority(token)) {
					int right = operands.pop();
					int left = operands.pop();
					int res = eval(operators.pop(), left, right);
					operands.push(res);
				}
				operators.push(token);
			} else
				operands.push(Integer.parseInt(token));
		}
		while (!operators.isEmpty()) {
			int right = operands.pop();
			int left = operands.pop();
			int res = eval(operators.pop(), left, right);
			operands.push(res);
		}
		return operands.pop();
	}

	public static void main(String[] args) {
		System.out.println(calculator1(args[0]));
	}

}
