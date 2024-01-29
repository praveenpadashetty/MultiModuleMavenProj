package com.java8.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiFunction;

public class StringRotation {

	static boolean check_Rotation(String sourceString, String goal) {
		if (sourceString.length() != goal.length())
			return false;

		Queue<Character> q1 = new LinkedList<>();
		for (int i = 0; i < sourceString.length(); i++) {
			q1.add(sourceString.charAt(i));
		}

		Queue<Character> q2 = new LinkedList<>();
		for (int i = 0; i < goal.length(); i++) {
			q2.add(goal.charAt(i));
		}

		int k = goal.length();
		while (k > 0) {
			k--;
			char ch = q2.peek();
			q2.remove();
			q2.add(ch);
			if (q2.equals(q1))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(check_Rotation("ABCD", "CDAB"));
		
		
		//With lambda
		BiFunction<String, String, Boolean> biFunc = (sourceString,goal)->{
			if (sourceString.length() != goal.length())
				return false;

			Queue<Character> q1 = new LinkedList<>();
			for (int i = 0; i < sourceString.length(); i++) {
				q1.add(sourceString.charAt(i));
			}

			Queue<Character> q2 = new LinkedList<>();
			for (int i = 0; i < goal.length(); i++) {
				q2.add(goal.charAt(i));
			}

			int k = goal.length();
			while (k > 0) {
				k--;
				char ch = q2.peek();
				q2.remove();
				q2.add(ch);
				if (q2.equals(q1))
					return true;
			}
			return false;
		};
		
		System.out.println(biFunc.apply("ABCD", "CDAB"));
		System.out.println(biFunc.apply("ABCD", "CDBA"));
		
	}

}
