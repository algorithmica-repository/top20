package com.alg.top20.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class EvaluatePostFix {

	public static int evalPostfix1(String[] in) {
		List<String> list = new LinkedList<String>();
		for(String x: in)  
			list.add(x);
		for(int i = 0; i < list.size(); ++i) {
			String x = list.get(i);
			if(x.equals("+")) {
				int op2 = Integer.parseInt(list.remove(i-1));
				int op1 = Integer.parseInt(list.remove(i-1));
				list.set(i, Integer.toString(op1+op2));
			}
			else if(x.equals("-")){
				int op2 = Integer.parseInt(list.remove(i-1));
				int op1 = Integer.parseInt(list.remove(i-1));
				list.set(i, Integer.toString(op2-op1));
			}
			else if(x.equals("*")){
				int op2 = Integer.parseInt(list.remove(i-1));
				int op1 = Integer.parseInt(list.remove(i-1));
				list.set(i, Integer.toString(op1*op2));
			}
			else if(x.equals("/")){
				int op2 = Integer.parseInt(list.remove(i-1));
				int op1 = Integer.parseInt(list.remove(i-1));
				list.set(i, Integer.toString(op2/op1));
			}
		}
		return Integer.parseInt(list.remove(0));
	}
	
	public static int evalPostfix2(String[] in) {
		Stack<Integer> st = new Stack<Integer>();
		for(String x: in)  {
			if(x.equals("+")) 
				st.push(st.pop() + st.pop());
			else if(x.equals("-"))
				st.push(-st.pop() + st.pop());
			else if(x.equals("*"))
				st.push(st.pop() * st.pop());
			else if(x.equals("/"))
				st.push(1/st.pop() * st.pop());
			else
				st.push(Integer.parseInt(x));		
		}
		return st.pop();		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
