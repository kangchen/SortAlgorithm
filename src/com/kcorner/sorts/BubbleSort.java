package com.kcorner.sorts;

import java.util.ArrayList;

public class BubbleSort implements Runnable{
		
	private ArrayList<Integer> item = new ArrayList<Integer> ();
	
	public BubbleSort(ArrayList<Integer> item) {
		this.item = item;
	}

	public void run() {
		sortIt();
	}
    
	public void sortIt() {
		
		for (int i=0; i<item.size()-1; i++){
			for (int j=0; j<item.size()-1; j++){
				if (item.get(j) > item.get(j+1)) {
					swap(j,j+1);
				}
			}
		}		
	}
	
    private void swap(int x, int y) {
        int tmp = item.get(x);
        item.set(x, item.get(y));
        item.set(y, tmp);
    }
    
    public String toString() {
    	return null;
    }
}
