package com.kcorner.sorts;

import java.util.List;

/**
 * @author Kang Chen
 * @version 2.0.0
 */

public final class SelectionSort implements Runnable, Sort {
	
	/**
	 * A list of integers
	 */
	private List<Integer> list;
	
	/**
	 * An elapsed sorting time in nanoseconds
	 */
	private long time = 0;
	private boolean sortCompleted = false;	
	/**
	 * Constructor
	 * @param item : an integer list
	 */
	public SelectionSort(List<Integer> item) {
		this.list = item;
	}

	@Override
	public void run() {
		sort();
		System.out.println(this.toString());
	}
 
    /**
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
        sortCompleted = true;
	}
	
    /**
     * Get the elapsed sorting time
     * @return long
     */ 	
    public long getTime() {
        return time;
    }
    
    /**
     * Swap two values
     * @param x : a value to swap from
     * @param y : a value to swap to
     */    
    private void swap(int x, int y) {
        int tmp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, tmp);
    }
    
    /**
     * Return a string of an elapsed time in nanoseconds
     * @return String
     */   
    public String toString() {
		return "Selection sort completed in " + getTime() + " nanoseconds";
    }
    
    /**
     * Swap the list in reverse order
     */    
    public void reversedList() {
        int idx = list.size()/2;
        int high = list.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    }     

	public boolean isSortCompleted() {
		return sortCompleted;
	}
}
