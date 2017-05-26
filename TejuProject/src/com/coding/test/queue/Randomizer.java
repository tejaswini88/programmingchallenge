package com.coding.test.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
/*
 *
 */
public class Randomizer implements Runnable{

	private BlockingQueue<Integer> queue1;

	private BlockingQueue<String> queue2;

	public Randomizer(BlockingQueue<Integer> queue1, BlockingQueue<String> queue2) {
		super();
		this.queue1 = queue1;
		this.queue2 = queue2;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			int randNumber = generateRandomNumber();
			queue1.put(randNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(queue2!=null && queue2.size() > 0){
			try {
				String numToBeStored = queue2.take();
				String[] arrayOfNumbers = numToBeStored.split(":");
				if(arrayOfNumbers!=null && arrayOfNumbers.length >0){
					System.out.println(arrayOfNumbers[0]);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			run();
		}
	}


	/*
	 * random number generator method
	 */
	private  int generateRandomNumber() {
		Random randomNum = new Random();
		return ( 1 + randomNum.nextInt((100 - 1) + 1));
	}
	}

