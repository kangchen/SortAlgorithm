package com.kcorner.sorts;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Runnable, Sort{
		
	private List<Integer> list = new ArrayList<Integer> ();
	private long time = 0;
	
	public BubbleSort(List<Integer> item) {
		this.list = item;
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
		for (int i=0; i<list.size()-1; i++){
			for (int j=0; j<list.size()-1; j++){
				if (list.get(j) > list.get(j+1)) {
					swap(j,j+1);
				}
			}
		}
        long endtime = System.nanoTime();
        time = endtime - starttime;
	}
	
    private void swap(int x, int y) {
        int tmp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, tmp);
    }
   
    public void reversedList() {
        int idx = list.size()/2;
        int high = list.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    } 
    
    public long getTime() {
        return time;
    }
    
    public String toString() {
    	return "Bubble sort completed in " + getTime() + " nanoseconds";
    }
 
}
