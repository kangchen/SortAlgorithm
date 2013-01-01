/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kcorner.sorts;

/**
 *
 */
public class Sort {

    private int[] item;
    private long time = 0;
    private String sortName = null;
    private int[] temp;
    private int pivotPos=0;

    public Sort(int[] arr) {
        item = arr;
    }

    /*
     * Bubble Sort Algorithm O(N*N)
     */
    public void bubbleSort() {
    	sortName = "Bubble Sort";
        long starttime = System.currentTimeMillis();

        for (int i=0; i<item.length-1; i++){
            for (int j=0; j<item.length-1; j++){
                if (item[j] > item[j+1]) {
                    swap(j,j+1);
                }
            }
        }

        long endtime = System.currentTimeMillis();
        time = endtime - starttime;
    }

    /*
     * Selection Sort Algorithm O((N*N)/2)
     */
    public void selectionSort() {
    	sortName = "Selection Sort";
        long starttime = System.currentTimeMillis();
        int idx=0;          //location of smallest number
        int tmp=0;          //find smallest number

        for(int i=0; i<item.length-1; i++) {
            tmp = item[i];
            for(int j=i; j<item.length; j++) {
               if (item[j] <= tmp) {
                   tmp = item[j];
                   idx = j;
               }
            }
            swap(i,idx);
        }

        long endtime = System.currentTimeMillis();
        time = endtime - starttime;
    }


    /*
     * Merge Sort Algorithm O(N*LOGN)
     */
    public void mergeSort() {
    	sortName = "Merge Sort";
        temp = new int[item.length];
        long starttime = System.currentTimeMillis();
        mergePartition(0, item.length-1);
        long endtime = System.currentTimeMillis();
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
            if (item[lowPtr] < item[midPtr]) {
                temp[ci++] = item[lowPtr++];
            }
            else {
                temp[ci++] = item[midPtr++];
            }
        }

        /*
         * copy remaining sorted elements
         */
        while (lowPtr <= mid) {
            temp[ci++] = item[lowPtr++];
        }

        /*
         * copy remaining sorted elements
         */
        while (midPtr <= highPtr) {
            temp[ci++] = item[midPtr++];
        }

        /*
         * replace original elements with sorted elements
         */
         copy(ai, bi, temp);
    }

    private void copy(int from, int num, int[] arrTemp) {
        for(int i=0; i<num; i++){
            item[from+i] = arrTemp[i];
        }
    }

    /*
     * Quick Sort Algorithm
     */
    public void quickSort() {

    	sortName = "Quick Sort";
        long starttime = System.currentTimeMillis();
        if (!isSorted()){
            doQuickSort(0, item.length-1);
        }
        long endtime = System.currentTimeMillis();
        time = endtime - starttime;
    }

    public void doQuickSort(int leftIdx, int rightIdx) {

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

        int pivot = item[leftIdx];
        int pivotIdx = leftIdx;
        
        while (rightIdx > leftIdx) {

            while (item[rightIdx] > pivot) {
                if (rightIdx == leftIdx) break;
                else rightIdx--;
            }

            while (item[leftIdx] <= pivot) {
                if (leftIdx == rightIdx) break;
                else leftIdx++;
            }

            if(leftIdx < rightIdx){
                swap(leftIdx, rightIdx);
                rightIdx--;
            }

            if(leftIdx == rightIdx) {
                if(item[leftIdx] < pivot) {
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

        if(item[0] < item[item.length-1]) {
            for(int i=0; i<item.length-1; i++){
                if(item[i] > item[i+1]) {
                    endtime = System.currentTimeMillis();
                    time = endtime - starttime;
                    return false;
                }
            }
        }
        else {
            for(int i=0; i<item.length-1; i++){
                if(item[i] < item[i+1]) {
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
        int tmp = item[x];
        item[x] = item[y];
        item[y] = tmp;
    }

    public long getTime() {
        return time;
    }
    
    public String getSortName() {
    	return sortName;
    }

    public void reverse() {
        int idx = item.length/2;
        int high = item.length-1;
        for(int low=0; low<idx; low++) {
            swap(low, high--);
        }
    }
}
