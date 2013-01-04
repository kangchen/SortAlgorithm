package com.kcorner.sorts;

public class BubbleSort implements Runnable{
	
	
	private int[] item;
	
	public BubbleSort() {
		
	}

	public void run() {
		sortIt();
	}
    
	public void sortIt() {
		
		for (int i=0; i<item.length-1; i++){
			for (int j=0; j<item.length-1; j++){
				if (item[j] > item[j+1]) {
					swap(j,j+1);
				}
			}
		}		
	}
	
    private void swap(int x, int y) {
        int tmp = item[x];
        item[x] = item[y];
        item[y] = tmp;
    }
    
    public String toString() {
    	return null;
    }
}
