package com.kcorner.sorts;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Runnable, Sort {
	
	private List<Integer> item = new ArrayList<Integer> ();
	private long time = 0;
	private int pivotPos=0;
	
	public QuickSort(List<Integer> item) {
		this.item = item;
	}
	
	public void run() {		
		sort();	
		System.out.println(this.toString());
	}
	
    /*
     * Quick Sort Algorithm
     */
    public void sort() {
    	
        long starttime = System.nanoTime(); 
        if (!isSorted()){
            doQuickSort(0, item.size()-1);
        }
        long endtime = System.nanoTime();
        time = endtime - starttime;
    }

    private void doQuickSort(int leftIdx, int rightIdx) {

        if (rightIdx <= leftIdx) {
            return;
        }
        else {
            pivotPos = quickPartition(leftIdx, rightIdx);
            doQuickSort(leftIdx, pivotPos-1);
            doQuickSort(pivotPos+1, rightIdx);
        }

    }

    private int quickPartition(int leftIdx, int rightIdx)
    {

        int pivot = item.get(leftIdx);
        int pivotIdx = leftIdx;
        
        while (rightIdx > leftIdx) {

            while (item.get(rightIdx) > pivot) {
                if (rightIdx == leftIdx) break;
                else rightIdx--;
            }

            while (item.get(leftIdx) <= pivot) {
                if (leftIdx == rightIdx) break;
                else leftIdx++;
            }

            if(leftIdx < rightIdx){
                swap(leftIdx, rightIdx);
                rightIdx--;
            }

            if(leftIdx == rightIdx) {
                if(item.get(leftIdx) < pivot) {
                    swap(pivotIdx, leftIdx);
                }
                pivotIdx = leftIdx;
                break;
            }
        }

        return pivotIdx;
    }
 

    public boolean isSorted(){
        long starttime = System.currentTimeMillis();
        long endtime = 0;

        if(item.get(0) < item.get(item.size()-1)) {
            for(int i=0; i<item.size()-1; i++){
                if(item.get(i) > item.get(i+1)) {
                    endtime = System.currentTimeMillis();
                    time = endtime - starttime;
                    return false;
                }
            }
        }
        else {
            for(int i=0; i<item.size()-1; i++){
                if(item.get(i) < item.get(i+1)) {
                    endtime = System.currentTimeMillis();
                    time = endtime - starttime;
                    return false;
                }
            }
        }

        endtime = System.currentTimeMillis();
        time = endtime - starttime;
        return true;
    }
    

    private void swap(int x, int y) {
        int tmp = item.get(x);
        item.set(x, item.get(y));
        item.set(y, tmp);
    }
    
    public String toString() {
    	return "Quick sort is completed in " + getTime() + " nanoseconds";
    }

    private long getTime() {
        return time;
    }

    public void reversedList() {
        int idx = item.size()/2;
        int high = item.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    }    
}
