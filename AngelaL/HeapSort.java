//Angela Lin (w/ Jenny Baran)
//APCS2 pd. 9
//HW42: Dig a Hole, Fill it Up
//2014-05-21


import java.util.*;
import java.io.*;

public class HeapSort {

 
    public int[] hSort(int[] input){
	heapify(input);
	sort(input);
	return input;
    }
    //helper function that swaps two elements
    public void swap(int pos1, int pos2, int[] arr){
	int temp = arr[pos1];
	arr[pos1] = arr[pos2];
	arr[pos2] = temp;
    }

    public void heapify(int[] input){
	
	for (int i = 1; i<input.length; i++){
	    int parent = (i-1)/2;
	    int child = i;
	   
	    while (child > 0){
		if (input[parent] < input[child]){
		    swap(parent, child, input);
		    // System.out.println(child);
		}
		child = parent;
		parent = (child-1)/2;
	    }
	}
    }
 

    public void sort(int[] input){
	int partition = input.length-1;
	while (partition > 0){
	    int temp = input[0];
	    swap(partition, 0, input);
	
	    int parent = 0;
	    int child = findMaxChild(input, parent);

	    //System.out.println(child);
	    while (child < partition && child >= 0){
		if (input[parent] < input[child]){
		    swap(parent, child, input);
		}
		parent = child;
		child = findMaxChild(input, parent);
	    }
	    partition--;
	    
	}
    }

    public int findMaxChild(int[] a, int pos){
	int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= a.length || lc >= a.length )
	    retVal = -1;
	//if no right child, then left child is only option for min
	else if ( rc >= a.length || lc >= a.length)
	    retVal = lc;
	//have 2 children, so compare to find most
	else if (a[lc] > a[rc] )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }


    public static void main(String[] args){


	//System.out.println((1-2)/2);
	HeapSort test1 = new HeapSort();
	int[] testH = {12,545,17,69};
	int[] testF = {12,545,17,69,607,114,6678,1946,18};
	test1.heapify(testF);
	System.out.println(Arrays.toString(testF));
	test1.sort(testF);
	System.out.println(Arrays.toString(testF));

	//should print same thing :)
	System.out.println(Arrays.toString(test1.hSort(testF)));
	/*
	HeapSort test1 = new HeapSort();
	Integer[] testA = {34,1,5,0,23};
	System.out.println(Arrays.toString(testA));
	System.out.println(Arrays.toString(test1.hSort(testA)));


	Integer[] testB = {34,12,54,17,45,20,6,1,5,0,23};
	System.out.println(Arrays.toString(testB));
	System.out.println(Arrays.toString(test1.hSort(testB)));

	Integer[] testC = {34,1,5,10,33,11,21,0,23};
	System.out.println(Arrays.toString(testC));
	System.out.println(Arrays.toString(test1.hSort(testC)));
	*/


    }








}
