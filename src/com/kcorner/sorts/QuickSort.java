package com.kcorner.sorts;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Runnable, Sort {
	
	private List<Integer> list = new ArrayList<Integer> ();
	private long time = 0;
	private int pivotPos=0;
	
	public QuickSort(List<Integer> item) {
		this.list = item;
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
            doQuickSort(0, list.size()-1);
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

        int pivot = list.get(leftIdx);
        int pivotIdx = leftIdx;
        
        while (rightIdx > leftIdx) {

            while (list.get(rightIdx) > pivot) {
                if (rightIdx == leftIdx) break;
                else rightIdx--;
            }

            while (list.get(leftIdx) <= pivot) {
                if (leftIdx == rightIdx) break;
                else leftIdx++;
            }

            if(leftIdx < rightIdx){
                swap(leftIdx, rightIdx);
                rightIdx--;
            }

            if(leftIdx == rightIdx) {
                if(list.get(leftIdx) < pivot) {
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

        if(list.get(0) < list.get(list.size()-1)) {
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i) > list.get(i+1)) {
                    endtime = System.currentTimeMillis();
                    time = endtime - starttime;
                    return false;
                }
            }
        }
        else {
            for(int i=0; i<list.size()-1; i++){
                if(list.get(i) < list.get(i+1)) {
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
        int tmp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, tmp);
    }
    
    public String toString() {
    	return "Quick sort is completed in " + getTime() + " nanoseconds";
    }

    private long getTime() {
        return time;
    }

    public void reversedList() {
        int idx = list.size()/2;
        int high = list.size()-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    }
   
}
