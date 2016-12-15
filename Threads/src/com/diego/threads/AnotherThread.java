package com.diego.threads;

public class AnotherThread extends Thread{

	@Override
	public void run() {
		System.out.println("Hello from "+ currentThread().getName());
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			System.out.println(currentThread().getName()+": Another thread woke my up");
			return;
		}
		
		System.out.println(currentThread().getName()+": Three seconds have passed and I'm awake");
	}

}
