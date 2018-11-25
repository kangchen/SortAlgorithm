/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcorner.sorts;
//import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import acm.program.*;

/**
 * 
 */
public class SortMain extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	private static final int XSCREENSIZE = 800;
    private static final int YSCREENSIZE = 600;
    private static final int PRINTSIZELIMIT = 50;
    public static int SIZE = 30;
    public static int MAXINT = 89; //random number between 10 - 99;
    private List<Integer> list;
    private Sort sort;
    private int pickSort=3; //default QuickSort

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //application entrance
        new SortMain().start(args);
    }

    @Override
    public void init() {

    	list = Collections.synchronizedList(new ArrayList<Integer>());
        setFont("verdana-12");
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
    	String cont = null;
    	do{
        	setRandomNumber();
	        println(SIZE + " unsorted integers");
	        println(list);  //print only if size of list is least than PRINTSIZELIMIT
	        pickSort=menu();
	        goSort(pickSort, false);
	        
	        while(!sort.isSortCompleted()); //wait for a sorting to be completed
	        println(list);  //print only if size of list is less than PRINTSIZELIMIT
	       	println("Elapsed Time : " + TimeUnit.MICROSECONDS.convert(sort.getTime(), TimeUnit.NANOSECONDS) + " microseconds");
	       	println();
	       	list.clear();
	       	
	       	cont=readLine("Do you want to continue another sort? (y/n): ");
			cont=cont.toUpperCase();
			if (cont.matches("N")) {pickSort = 5;}
			println();
			
    	}while(pickSort!=5); //End of do-while loop
    	System.exit(0);
    }
    
    
    private void goSort(int index, boolean newThread){
   	
		switch(index) {    	
    		case 1: println("Bubble Sort");bubbleSort(newThread); break;
    		case 2: println("Selection Sort");selectionSort(newThread); break;
    		case 3: println("Merge Sort");mergeSort(newThread); break;
    		case 4: println("Quick Sort");quickSort(newThread); break;
    		case 5: System.exit(0); break;
    		default:println("Quick Sort");quickSort(newThread);
		}
    	
    }
    
    private int menu(){
    	int item;
    	println("\t\t\t\t===================");
    	println("\t\t\t\t1: Bubble Sort");
    	println("\t\t\t\t2: Selection Sort");
    	println("\t\t\t\t3: Merge Sort");
    	println("\t\t\t\t4: Quick Sort");
    	println("\t\t\t\t5: Exit");
    	println("\t\t\t\t===================");
    	item=readInt("\t\t\t\tEnter one of options: ");
    	return item;
    }
    

    private void quickSort(boolean useNewThread) {     

      sort = new QuickSort(list);
      //////////////////////////////
      //Using new thread
      if (useNewThread) {      
    	  Thread t = new Thread((Runnable) sort);
    	  try{
    		  t.start();
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
