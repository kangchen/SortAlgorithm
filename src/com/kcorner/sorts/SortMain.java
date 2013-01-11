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
    public static int SIZE = 15;
    public static int MAXINT = 50;
    private int[] a = new int[SIZE];
    private ArrayList<Integer> bs = new ArrayList<Integer> ();
    private ArrayList<Integer> ss = new ArrayList<Integer> ();
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
            a[i] = (int)(Math.random()*MAXINT) + 10;
            bs.add(a[i]);
            ss.add(a[i]);
        }
    }

    @Override
    public void run() {
        println("Unsorted Array:");
        println(a);

        bubbleSort(true);
        selectionSort(true);
//        quickSort();

    }

    private void quickSort() {     

      //Using thread
      QuickSort myQuickSort = new QuickSort(a);
      Thread t = new Thread(myQuickSort);
      try{
    	  t.start();
    	  t.join();
      }catch(Exception e){
    	  System.out.println(e.getMessage());
      }
      //////////////////////////////
      println("Quick Sort:");
      println(a);
    }

    private void selectionSort(boolean useNewThread) {
    	
        SelectionSort mySelectionSort = new SelectionSort(ss);
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
        
        println("Selection Sort:");
        println(ss);
    }  
    
    private void bubbleSort(boolean useNewThread) {
    	
        BubbleSort mybubbleSort = new BubbleSort(bs);
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
        
        println("Bubble Sort:");
        println(bs);
    }    
    
    
    private void println(int[] ab) {
        for (int a:ab) print(a + "  ");
        println();
    }
   
    private void println(ArrayList<Integer> ab) {
    	for (Integer a:ab) print(a + "  ");
        println();
    }    
}
