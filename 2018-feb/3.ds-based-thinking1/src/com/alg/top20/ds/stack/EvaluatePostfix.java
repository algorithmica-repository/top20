package com.alg.top20.ds.stack;

import java.util.Stack;

public class EvaluatePostfix {

	//time:O(n) space:O(n)
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		int left, right;
        for(int i = 0; i < tokens.length; ++i) {
        	if(tokens[i].equals("+")) {
        		right = stack.pop();
        		left = stack.pop();
        		stack.push(left+right);
        	} else if(tokens.equals("-")) {
        		right = stack.pop();
        		left = stack.pop();
        		stack.push(left-right);
        	} else if(tokens.equals("*")) {
        		right = stack.pop();
        		left = stack.pop();
        		stack.push(left*right);
        	} else if(tokens.equals("/")) {
        		right = stack.pop();
        		left = stack.pop();
        		stack.push(left/right);
        	} else {
        		stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        return stack.pop();
    }
}
