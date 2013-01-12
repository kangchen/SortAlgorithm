/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcorner.sorts;
import java.util.ArrayList;

import acm.program.*;

/**
 * 
 */
public class SortMain extends ConsoleProgram{

	private static final long serialVersionUID = 1L;
	private static final int XSCREENSIZE = 800;
    private static final int YSCREENSIZE = 600;
    public static int SIZE = 19;
    public static int MAXINT = 80;
    private ArrayList<Integer> pts = new ArrayList<Integer> ();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //application entrance
        new SortMain().start(args);
    }

    @Override
    public void init() {

    	setRandomNumber();
        setFont("verdana-bold-14");
        setSize(XSCREENSIZE, YSCREENSIZE);
        setTitle("Sort Algorithms");
        
    }
    
    private void setRandomNumber() {
        for(int i=0;i<SIZE;i++){
            pts.add((int)(Math.random()*MAXINT) + 10);
        }
    }

    @Override
    public void run() {
        println("Unsorted Array:");
        println(pts);

        testSort(1, true);
 
        println(pts);
    }
    
    
    private void testSort(int index, boolean newThread) {
    	
    	switch(index) {    	
    		case 0: println("Bubble Sort");bubbleSort(newThread); break;
    		case 1: println("Selection Sort");selectionSort(newThread); break;
    		case 2: println("Merge Sort");mergeSort(newThread); break;
    		case 3: println("Quick Sort");quickSort(newThread); break;
    		default:println("Quick Sort");quickSort(newThread);
    	}
    	
    }
    

    private void quickSort(boolean useNewThread) {     

      QuickSort myQuickSort = new QuickSort(pts);
      //////////////////////////////
      //Using new thread
      if (useNewThread) {      
    	  Thread t = new Thread(myQuickSort);
    	  try{
    		  t.start();
    		  t.join();
    	  }catch(Exception e){
    		  System.out.println(e.getMessage());
    	  }
      }
      //////////////////////////////
      //Using main thread
      else myQuickSort.run();
      //////////////////////////////
    }

    private void mergeSort(boolean useNewThread) {
    	
        MergeSort mergeSort = new MergeSort(pts);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread(mergeSort);
        	try{
        		t.start();
        		t.join();
        	}catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        }
        //////////////////////////////
        //Using main thread
        else mergeSort.run();
        //////////////////////////////
    }     
    
    private void selectionSort(boolean useNewThread) {
    	
        SelectionSort mySelectionSort = new SelectionSort(pts);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread(mySelectionSort);
        	try{
        		t.start();
        		t.join();
        	}catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        }
        //////////////////////////////
        //Using main thread
        else mySelectionSort.run();
        //////////////////////////////
    }  
    
    private void bubbleSort(boolean useNewThread) {
    	
        BubbleSort mybubbleSort = new BubbleSort(pts);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread(mybubbleSort);
        	try{
        		t.start();
        		t.join();
        	}catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        }
        //////////////////////////////
        //Using main thread
        else mybubbleSort.run();
        //////////////////////////////
    }    

    private void println(ArrayList<Integer> ab) {
    	for (Integer a:ab) print(a + "  ");
        println();
    }    
}
