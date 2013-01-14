/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcorner.sorts;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import acm.program.*;

/**
 * 
 */
public class SortMain extends ConsoleProgram{

	private static final long serialVersionUID = 1L;
	private static final int XSCREENSIZE = 800;
    private static final int YSCREENSIZE = 600;
    private static final int PRINTSIZELIMIT = 50;
    public static int SIZE = 19;
    public static int MAXINT = 80;
    private List<Integer> pts; // = Collections.synchronizedList( new ArrayList<Integer> ();
    private Sort sort;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //application entrance
        new SortMain().start(args);
    }

    @Override
    public void init() {

    	pts = new ArrayList<Integer>();
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

        testSort(3, true);
        
        println(pts);
        print("Elapsed Time : " + TimeUnit.MICROSECONDS.convert(sort.getTime(), TimeUnit.NANOSECONDS) + " microseconds");

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

      sort = new QuickSort(pts);
      //////////////////////////////
      //Using new thread
      if (useNewThread) {      
    	  Thread t = new Thread((Runnable) sort);
    	  try{
    		  t.start();
    		  t.join();
    	  }catch(Exception e){
    		  System.out.println(e.getMessage());
    	  }
      }
      //////////////////////////////
      //Using main thread
      else sort.sort();
      //////////////////////////////
    }

    private void mergeSort(boolean useNewThread) {
    	
    	sort = new MergeSort(pts);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread((Runnable) sort);
        	try{
        		t.start();
        		t.join();
        	}catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        }
        //////////////////////////////
        //Using main thread
        else sort.sort();
        //////////////////////////////
    }     
    
    private void selectionSort(boolean useNewThread) {
    	
    	sort = new SelectionSort(pts);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread((Runnable) sort);
        	try{
        		t.start();
        		t.join();
        	}catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        }
        //////////////////////////////
        //Using main thread
        else sort.sort();
        //////////////////////////////
    }  
    
    private void bubbleSort(boolean useNewThread) {
    	
    	sort = new BubbleSort(pts);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread((Runnable) sort);
        	try{
        		t.start();
        		t.join();
        	}catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        }
        //////////////////////////////
        //Using main thread
        else sort.sort();
        //////////////////////////////
    }    

    private void println(List<Integer> ab) {
    	if (ab.size() < PRINTSIZELIMIT) {
    		for (Integer a:ab) print(a + "  ");
    	}
    	println();    	
    }    
}
