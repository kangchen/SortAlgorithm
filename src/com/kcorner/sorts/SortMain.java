/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcorner.sorts;
import java.util.ArrayList;
import java.util.Collections;
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
    public static int SIZE = 25;
    public static int MAXINT = 89; // random number between 10 - 99;
    private List<Integer> list;
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

    	list = Collections.synchronizedList(new ArrayList());
    	setRandomNumber();
        setFont("verdana-bold-14");
        setSize(XSCREENSIZE, YSCREENSIZE);
        setTitle("Sort Algorithms");
        
    }
    
    private void setRandomNumber() {
        for(int i=0;i<SIZE;i++){
            list.add((int)(Math.random()*MAXINT) + 10);
        }
    }

    @Override
    public void run() {
        println("Unsorted Array:");
        println(list);  //print only if size of list is least than PRINTSIZELIMIT

        testSort(0, true);
        
        while(!sort.isSortCompleted()); //wait for a sorting to be completed
        println(list);  //print only if size of list is least than PRINTSIZELIMIT
        println("Elapsed Time : " + TimeUnit.MICROSECONDS.convert(sort.getTime(), TimeUnit.NANOSECONDS) + " microseconds");

    }
    
    
    private void testSort(int index, boolean newThread){
   	
		switch(index) {    	
    		case 0: println("Bubble Sort");bubbleSort(newThread); break;
    		case 1: println("Selection Sort");selectionSort(newThread); break;
    		case 2: println("Merge Sort");mergeSort(newThread); break;
    		case 3: println("Quick Sort");quickSort(newThread); break;
    		default:println("Quick Sort");quickSort(newThread);
		}
    	
    }
    

    private void quickSort(boolean useNewThread) {     

      sort = new QuickSort(list);
      //////////////////////////////
      //Using new thread
      if (useNewThread) {      
    	  Thread t = new Thread((Runnable) sort);
    	  try{
    		  t.start();
    		  //t.join();
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
    	
    	sort = new MergeSort(list);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread((Runnable) sort);
        	try{
        		t.start();
        		//t.join();
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
    	
    	sort = new SelectionSort(list);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread((Runnable) sort);
        	try{
        		t.start();
        		//t.join();
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
    	
    	sort = new BubbleSort(list);
        //////////////////////////////
        //Using new thread
        if (useNewThread) {
        	Thread t = new Thread((Runnable) sort);
        	try{
        		t.start();
        		//t.join();
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

    	synchronized(list){
    		if (ab.size() <= PRINTSIZELIMIT) {
    			for (Integer a:ab) print(a + "  ");
    		}
    		println();
    	}
    }    

}
