package com.alg.top20.list;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionEvaluator {

	private static int eval(int op1, int op2, String operator) {
		if(operator.equals("+")) return op1 + op2;
		if(operator.equals("-")) return op1 - op2;
		if(operator.equals("*")) return op1 * op2;
		if(operator.equals("/")) return op1 / op2;
		return 0;
	}
	private static boolean isOperator(String token) {
		if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") )
				return true;
		return false;
	}	
	private static int priority(String token) {
		if(token.equals("+") || token.equals("-") ) return 1;
		if(token.equals("*") || token.equals("/") ) return 2;
		return 0;
	}
	private static String[] tokenize(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s, "+-/*");
		while(tokenizer.hasMoreTokens())
			System.out.println(tokenizer.nextToken());
		return null;
	}
	public static int evalExpr1(String s) {
		String[] tokens = tokenize(s);		
		Stack<Integer> operand_stack = new Stack<Integer>();
		Stack<String> operator_stack = new Stack<String>();
		for(String token: tokens) {
			if(isOperator(token)) {				
				while(!operator_stack.isEmpty() && priority(token) <= priority(operator_stack.peek()) ) {
					int operand2 = operand_stack.pop();
					int operand1 = operand_stack.pop();
					operand_stack.push(eval(operand1, operand2, operator_stack.pop()) );
				}
				operator_stack.push(token);
			} else 
				operand_stack.push(Integer.parseInt(token));
		}
		return operand_stack.pop();
	}
	public static void main(String[] args) {
		tokenize(args[0]);


	}

}
