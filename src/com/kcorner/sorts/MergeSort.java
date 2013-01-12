package com.kcorner.sorts;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Runnable, Sort {

	private List<Integer> item = new ArrayList<Integer> ();
	private List<Integer> temp = new ArrayList<Integer> ();;
	private long time = 0;
	
	public MergeSort(List<Integer> item) {
		this.item = item;
		initializeTempList();
	}	
	
	public void run() {
		sort();
		System.out.println(this.toString());
	}
	
	private void initializeTempList() {
		for(int i=0; i<item.size(); i++) {
			temp.add(0);
		}
	}
    /*
     * Merge Sort Algorithm O(N*LOGN)
     */
    public void sort() {
        long starttime = System.nanoTime();
        mergePartition(0, item.size()-1);
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
        
//        System.out.println("Debug 02: " + lowPtr + " " + midPtr + " " + highPtr);
        while (lowPtr <= mid && midPtr <= highPtr) {
            if (item.get(lowPtr) < item.get(midPtr)) {
                temp.set(ci++, item.get(lowPtr++));
            }
            else {
                temp.set(ci++, item.get(midPtr++));
            }
        }

        /*
         * copy remaining sorted elements
         */
        while (lowPtr <= mid) {
            temp.set(ci++, item.get(lowPtr++));
        }

        /*
         * copy remaining sorted elements
         */
        while (midPtr <= highPtr) {
            temp.set(ci++, item.get(midPtr++));
        }

        /*
         * replace original elements with sorted elements
         */
         copy(ai, bi, temp);
    }

    private void copy(int from, int num, List<Integer> arrTemp) {
        for(int i=0; i<num; i++){
            item.set(from+i, arrTemp.get(i));
        }
    }
    
    private long getTime() {
        return time;
    }
    
    public String toString() {
    	return "Merge sort is completed in " + getTime() + " nanoseconds";
    }
 
    private void swap(int x, int y) {
        int tmp = item.get(x);
        item.set(x, item.get(y));
        item.set(y, tmp);
    }
    
    public void reversedList() {
        int idx = item.size()/2;
        int high = item.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    } 
}
