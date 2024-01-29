package com.java8.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComperatorNumDemo {

	public static void main(String[] args) {
		
		// Use Comparator inerface to sort given list of numbers in reverse order
		List<Integer> list = Arrays.asList(4, 2, 5, 1, 3);
		list.sort(new ComperatorNumDemo().new ComperatorImpl());
		 System.out.println(list);
		 
		 //with lamda
		 Comparator<Integer> comperator = (o1,o2)->{
			 return o2 - o1;
		 };
		 list = Arrays.asList(4, 2, 5, 1, 3);
		 System.out.println("Before "+list);
		 list.sort(comperator);
		 System.out.println(list);
	}
	
	 class ComperatorImpl implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			System.out.println("In compare");
			return o2 - o1;
		}
		 
	 }

}
