package com.kcorner.sorts;

import java.util.List;

/**
 * @author Kang Chen
 * @version 2.0.0
 */
public class BubbleSort implements Runnable, Sort{
	
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
	public BubbleSort(List<Integer> item) {
		this.list = item;
	}

	public boolean isSortCompleted() {
		return sortCompleted;
	}

	@Override
	public void run() {
		sort();
		System.out.println(this.toString());
	}
 
    /**
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
        sortCompleted = true;
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
     * Swap the list in reverse order
     */    
    public void reversedList() {
        int idx = list.size()/2;
        int high = list.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    } 
    
    /**
     * Get an elapsed sorting time in nanoseconds
     * @return long
     */   
    public long getTime() {
        return time;
    }
    
    /**
     * Return a string of an elapsed time in nanoseconds
     * @return String
     */  
    public String toString() {
    	return "Bubble sort completed in " + getTime() + " nanoseconds";
    }

}
