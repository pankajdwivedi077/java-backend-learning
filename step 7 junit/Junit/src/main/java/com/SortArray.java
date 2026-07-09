package com;

import java.util.Arrays;

public class SortArray {

	public int[] sortingArray(int[] arr) {
		 Arrays.sort(arr);
		 return arr;
	}
	
	public int[] performance(int[] arr) {
		for(int i=0; i<10000; i++) {
			Arrays.sort(arr);
		}
		return arr;
	}
	
}
