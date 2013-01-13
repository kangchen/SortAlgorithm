package com.kcorner.sorts;

import java.util.List;
import java.util.ArrayList;

public class SelectionSort implements Runnable, Sort {
	
	private List<Integer> list = new ArrayList<Integer> ();
	private long time = 0;
	
	public SelectionSort(List<Integer> item) {
		this.list = item;
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

        for(int i=0; i<list.size()-1; i++) {
            tmp = list.get(i);
            for(int j=i; j<list.size(); j++) {
               if (list.get(j) <= tmp) {
                   tmp = list.get(j);
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
        int tmp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, tmp);
    }	
    
    public String toString() {
		return "Selection sort completed in " + getTime() + " nanoseconds";
    }
    
    public void reversedList() {
        int idx = list.size()/2;
        int high = list.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    }     
 
}
