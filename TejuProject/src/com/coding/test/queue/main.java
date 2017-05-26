package com.coding.test.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class main {
	public static void main(String[] args) throws InterruptedException {
		//Creating shared object
	     BlockingQueue<Integer> sharedQueue1 = new LinkedBlockingQueue<Integer>(); // Queue one to post random numbers
	     BlockingQueue<String> sharedQueue2 = new LinkedBlockingQueue<String>(); // Queue two to post Prime Number check result
	     Prime prime = new Prime(sharedQueue1,sharedQueue2); //Creating Prime class object
	     Randomizer randomizer = new Randomizer(sharedQueue1,sharedQueue2); //Creating Randomizer Class object

	        new Thread(randomizer).start(); //Randomizer Thread Starts
	        new Thread(prime).start();//Prime Thread Starts

	        Thread.sleep(5000); // Main Thread sleep for 5 secs



	}
}
