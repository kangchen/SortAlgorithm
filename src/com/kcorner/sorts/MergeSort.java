package com.kcorner.sorts;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Runnable, Sort {

	private List<Integer> list;
	private List<Integer> temp = new ArrayList<Integer> ();
	private long time = 0;
	
	public MergeSort(List<Integer> item) {
		this.list = item;
		initializeTempList();
	}	
	
	public void run() {
		sort();
		System.out.println(this.toString());
	}
	
	private void initializeTempList() {
		for(int i=0; i<list.size(); i++) {
			temp.add(0);
		}
	}
    /*
     * Merge Sort Algorithm O(N*LOGN)
     */
    public void sort() {
        long starttime = System.nanoTime();
        mergePartition(0, list.size()-1);
        long endtime = System.nanoTime();
        time = endtime - starttime;
    }

    private void mergePartition(int low, int high) {

        if (low == high) return;
        else {
            int mid = (low + high) / 2;
            mergePartition(low, mid);
            mergePartition(mid+1, high);
            merge(low, mid+1, high);
        }
    }

    private void merge(int lowPtr, int midPtr, int highPtr) {
        int ci = 0;
        int ai = lowPtr;
        int mid = midPtr - 1;
        int bi = highPtr - ai + 1;
        
        while (lowPtr <= mid && midPtr <= highPtr) {
            if (list.get(lowPtr) < list.get(midPtr)) {
                temp.set(ci++, list.get(lowPtr++));
            }
            else {
                temp.set(ci++, list.get(midPtr++));
            }
        }

        /*
         * copy remaining sorted elements
         */
        while (lowPtr <= mid) {
            temp.set(ci++, list.get(lowPtr++));
        }

        /*
         * copy remaining sorted elements
         */
        while (midPtr <= highPtr) {
            temp.set(ci++, list.get(midPtr++));
        }

        /*
         * replace original elements with sorted elements
         */
         copy(ai, bi, temp);
    }

    private void copy(int from, int num, List<Integer> arrTemp) {
        for(int i=0; i<num; i++){
            list.set(from+i, arrTemp.get(i));
        }
    }
    
    public long getTime() {
        return time;
    }
    
    public String toString() {
    	return "Merge sort is completed in " + getTime() + " nanoseconds";
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
    
}
