package com.kcorner.sorts;

import java.util.ArrayList;

public class BubbleSort implements Runnable{
		
	private ArrayList<Integer> item = new ArrayList<Integer> ();
	private long time = 0;
	
	public BubbleSort(ArrayList<Integer> item) {
		this.item = item;
	}

	public void run() {
		sort();
		System.out.println(this.toString());
	}
 
    /*
     * Bubble Sort Algorithm O(N*N)
     */	
	public void sort() {
		long starttime = System.nanoTime();
		for (int i=0; i<item.size()-1; i++){
			for (int j=0; j<item.size()-1; j++){
				if (item.get(j) > item.get(j+1)) {
					swap(j,j+1);
				}
			}
		}
        long endtime = System.nanoTime();
        time = endtime - starttime;
	}
	
    private void swap(int x, int y) {
        int tmp = item.get(x);
        item.set(x, item.get(y));
        item.set(y, tmp);
    }
   
    private long getTime() {
        return time;
    }
    
    public String toString() {
    	return "BubbleSort is completed in " + getTime() + " nanoseconds";
    }
}
