package com.coding.test.queue;

import java.util.concurrent.BlockingQueue;

public class Prime implements Runnable {

	private BlockingQueue<Integer> queue1; // queue from randomizer containing input
	private BlockingQueue<String> queue2;


	public Prime(BlockingQueue<Integer> queue1, BlockingQueue<String> queue2) {
		super();
		this.queue1 = queue1;
		this.queue2 = queue2;
	}


	@Override
	public void run() {
		if(queue1 != null && queue1.size() >0){
			try {
				int number =queue1.take();
				if(prime(number)){
					queue2.put(number+" ---> is prime");
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

	/**
	 *
	 * checking if the number is prime or not
	 *
	 * @param num
	 * @return
	 */
	private Boolean prime(int num){

		if(num == 0 || num == 1 || num < 0) return false;

		if (num%2==0) return false;

		for(int i=3;i*i<=num;i+=2) {
			if(num%i==0){
				return false;
			}
		}

		return true;
	}

}
