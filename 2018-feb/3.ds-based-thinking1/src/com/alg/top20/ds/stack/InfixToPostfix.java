package com.alg.top20.ds.stack;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class InfixToPostfix {
	public static int priority(char op) {
		if (op == '*' || op == '/')
			return 2;
		else if (op == '+' || op == '-')
			return 1;
		else
			return 0;
	}

	public static void infixToPostfix(List<String> tokens) {
		Stack<Character> st = new Stack<Character>();
		for (String token : tokens) {
			token = token.trim();
			if (!Character.isDigit(token.charAt(0))) {
				char op = token.charAt(0);
				if (op == '+' || op == '-' || op == '*' || op == '/') {
					while (!st.empty() && priority(op) <= priority(st.peek()))
						System.out.print(st.pop()+" ");
					st.push(op);
				} else if (op == '(')
					st.push(op);
				else {
					while (!st.empty()) {
						char tmp = st.pop();
						if (tmp == '(')
							break;
						System.out.print(tmp+" ");
					}
				}
			} else
				System.out.print(token+ " ");
		}
		while(! st.empty())
			System.out.print(st.pop()+ " ");
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
	public static void main(String[] args) {
		List<String> tokens = tokenize(args[0]);
		System.out.println(tokens);
		infixToPostfix(tokens);
	}
}
