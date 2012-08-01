package com.db.consistency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.TestCase;

public class Test extends TestCase{
	public void test1(){
		System.out.println("test1");
	}
	
	public void test2(){
		System.out.println("test2");
		int count = 2;
		ExecutorService executorService = Executors.newFixedThreadPool(count);
		for (int i = 0; i < count; i++)  
            executorService.execute(new User());
		
		executorService.shutdown();
		while (!executorService.isTerminated()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
