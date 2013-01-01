/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcorner.sorts;
import acm.program.*;

/**
 * make some codes change
 */
public class SortMain extends ConsoleProgram{

	private static final long serialVersionUID = 1L;
	private static final int XSCREENSIZE = 800;
    private static final int YSCREENSIZE = 600;
    public static int SIZE = 19;
    public static int MAXINT = 80;
    private int[] a = new int[SIZE];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
        }
    }

    @Override
    public void run() {
    	test();
    	println("Done");
    }
    
    private void test() {

      println(a);	
//    Sort mySort = new Sort(a); 
//    mySort.quickSort();
//    mySort.mergeSort();
//    mySort.selectionSort();
//    mySort.bubbleSort();      
   	
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

      println(a);
    }
    
    private void println(int[] ab) {
        for (int a:ab) print(a + "  ");
        println();
    }
    
}
