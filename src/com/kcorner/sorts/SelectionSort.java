package com.kcorner.sorts;

import java.util.ArrayList;

public class SelectionSort implements Runnable {
	
	private ArrayList<Integer> item = new ArrayList<Integer> ();
	private long time = 0;
	
	public SelectionSort(ArrayList<Integer> item) {
		this.item = item;
	}

	public void run() {
		sort();
		System.out.println(this.toString());
	}
 
    /*
     * Selection Sort Algorithm O((N*N)/2)
     */
	public void sort() {
        long starttime = System.nanoTime();
        int idx=0;          //location of smallest number
        int tmp=0;          //find smallest number

        for(int i=0; i<item.size()-1; i++) {
            tmp = item.get(i);
            for(int j=i; j<item.size(); j++) {
               if (item.get(j) <= tmp) {
                   tmp = item.get(j);
                   idx = j;
               }
            }
            swap(i,idx);
        }

        long endtime = System.nanoTime();
        time = endtime - starttime;
	}
	
    private long getTime() {
        return time;
    }
    
    private void swap(int x, int y) {
        int tmp = item.get(x);
        item.set(x, item.get(y));
        item.set(y, tmp);
    }	
    
    public String toString() {
    	return "Selection sort is completed in " + getTime() + " nanoseconds";
    }    
}
