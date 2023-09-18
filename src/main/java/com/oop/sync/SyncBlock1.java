package com.oop.sync;

import java.util.ArrayList;

public class SyncBlock1 {
	public ArrayList<Integer> mList = new ArrayList<>();
	
	public static void main(String[] agrs) throws InterruptedException {
		SyncBlock1 syncblock1 = new SyncBlock1();
		System.out.println("Test start!");
		Thread t1 = new Thread(() -> {
			for (int i = 0; i<10000; i++) {syncblock1.add(i);}			
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i<10000; i++) {syncblock1.add(i);}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(syncblock1.mList.size());
		System.out.println("Test end!");
		
	}
	
	public void add(int val) {
		/*
		 * Code for synchronization is not needed
		 * 
		 */
		synchronized(this) {
			if (!mList.contains(val)) {
				mList.add(val);				
			}			
		}
	}
}