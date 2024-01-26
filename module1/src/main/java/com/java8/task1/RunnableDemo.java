package com.java8.task1;

public class RunnableDemo {

	private class RunnableImpl implements Runnable {

		@Override
		public void run() {
			System.out.println("I am in " + Thread.currentThread().getName().toUpperCase() + " method executing run()");
			for (int num = 0; num < 10; num++)
				System.out.println(num);
		}

	}

	public static void main(String[] args) {
		System.out.println("I am in " + Thread.currentThread().getName().toUpperCase() + " method");
		Thread thread = new Thread(new RunnableDemo().new RunnableImpl());
		thread.start();
	}

}
