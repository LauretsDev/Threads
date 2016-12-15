package com.diego.threads;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello from the main thread.");
		
		Thread anotherThread = new AnotherThread();
		anotherThread.setName("== Another Thread ==");
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println("Hello from the anonymous class thread.");
				try {
					anotherThread.join();
					System.out.println(currentThread().getName()+": AnotherThread terminated, or timed out, so I'm running again");
				} catch(InterruptedException e) {
					System.out.println("I couldn't wait after all. I was interrupted");
				}
			}
		}.start();  
		
	/*	Thread myRunnableThread = new Thread(new MyRunnable());
		myRunnableThread.start(); */
		
		Thread myRunnableThreadAnonymous = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println("Hello from the anonymous class's implementation of run()");
			}
		});
		
		myRunnableThreadAnonymous.start();
		
		System.out.println("Hello again from the main thread.");

	}

}
