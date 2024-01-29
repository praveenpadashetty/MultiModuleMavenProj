package com.java8.task1;

import java.util.function.Function;

public class Palindrome {
	
	public static boolean isPalindrome(String str)
    {
        String rev = "";
        boolean ans = false;
 
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        if (str.equals(rev)) {
            ans = true;
        }
        return ans;
    }

	public static void main(String[] args) {
        String str = "Malayalam";
 
        str = str.toLowerCase();
        boolean A = isPalindrome(str);
        System.out.println(A);
        
        //With Lambda
        Function<String, Boolean> function = (string)-> {
        	String rev = "";
            boolean ans = false;
     
            for (int i = string.length() - 1; i >= 0; i--) {
                rev = rev + string.charAt(i);
            }
            if (string.equals(rev)) {
                ans = true;
            }
            return ans;
        };
        System.out.println(function.apply("abcd"));
        System.out.println(function.apply("ababa"));
	}

}
