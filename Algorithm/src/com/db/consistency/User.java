package com.db.consistency;

import java.util.HashMap;
import java.util.Random;

public class User implements Runnable{
	private static int num_ID = 0;
	private static HashMap<Integer, User> collection = new HashMap<Integer, User>();
	
	
	private int serial_ID = -1;
	private String doc = "";

	public void insert(char c, int pos){
		this.doc += c;
		System.out.println(serial_ID+":insert:"+c+":"+pos+"@"+collection.get(serial_ID).doc);
	}
	
	public void delete(char c, int pos){
		this.doc += c;
		System.out.println(serial_ID+":delete:"+c+":"+pos+"@"+collection.get(serial_ID).doc);
	}
	
	public User(){
		this.serial_ID = ++User.num_ID;
		this.collection.put(this.serial_ID, this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random(100);
		for(;;){
			if(random.nextInt()%2==0){
				insert('a', Math.abs(random.nextInt()));
			}else{
				delete('c', Math.abs(random.nextInt()));
			}
		}
	}
	
}
