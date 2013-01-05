package com.kcorner.sorts;

public class QuickSort implements Runnable{
	
	private int[] intArray;
	private long time = 0;
	private int pivotPos=0;
	
	public QuickSort(int[] arr) {
		intArray = arr;
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
            doQuickSort(0, intArray.length-1);
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

        int pivot = intArray[leftIdx];
        int pivotIdx = leftIdx;
        
        while (rightIdx > leftIdx) {

            while (intArray[rightIdx] > pivot) {
                if (rightIdx == leftIdx) break;
                else rightIdx--;
            }

            while (intArray[leftIdx] <= pivot) {
                if (leftIdx == rightIdx) break;
                else leftIdx++;
            }

            if(leftIdx < rightIdx){
                swap(leftIdx, rightIdx);
                rightIdx--;
            }

            if(leftIdx == rightIdx) {
                if(intArray[leftIdx] < pivot) {
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

        if(intArray[0] < intArray[intArray.length-1]) {
            for(int i=0; i<intArray.length-1; i++){
                if(intArray[i] > intArray[i+1]) {
                    endtime = System.currentTimeMillis();
                    time = endtime - starttime;
                    return false;
                }
            }
        }
        else {
            for(int i=0; i<intArray.length-1; i++){
                if(intArray[i] < intArray[i+1]) {
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
        int tmp = intArray[x];
        intArray[x] = intArray[y];
        intArray[y] = tmp;
    }
    
    public String toString() {
    	return "QuickSort is completed in " + getTime() + " nanoseconds";
    }

    private long getTime() {
        return time;
    }
	
}
