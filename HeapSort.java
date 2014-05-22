// ANGELA LIN & JENNY BARAN
// APCS2 pd 9
// HW42
// 2014-05-21

/**********
 First we made the array match the constraints of a heap. 
 *********/

import java.util.ArrayList;

public class HeapSort {

    //returns a sorted version of data, data unchanged
    public static int [] sort( int[] data ) {
	heapify( data );
	sortHelper( data );
	return data;
    } //O(nlogn)



    public static void sortHelper(int[] input){
	int partition = input.length-1;
	while (partition > 0){
	    int temp = input[0];
	    swap(input, partition, 0);
	
	    int parent = 0;
	    int child = findMaxChild(input, parent);

	    //System.out.println(child);
	    while (child < partition && child >= 0){
		if (input[parent] < input[child]){
		    swap(input, parent, child);
		}
		parent = child;
		child = findMaxChild(input, parent);
	    }
	    partition--;
	    
	}
    }

    public static int findMaxChild(int[] a, int pos){
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


    private static void heapify( int[] data ) {
	for ( int i = 1; i < data.length; i++ ) {
	    int pos = i;
	    int parentPos;
	    while ( pos > 0 ) {
		parentPos = ( pos - 1 ) / 2;
		
		if( data[pos] > data[parentPos] ) {
		    swap( data, pos, parentPos );
		    pos = parentPos;
		}
		else {
		    break;
		}
	    }
	}
    }

    private static void swap( int[] data, int pos1, int pos2 ) {
	int temp = data[pos1];
	data[pos1] = data[pos2];
	data[pos2] = temp;
    }

    public static void main( String[] args ) {

	int[] yo = { 4, 13, 1, 8, 9, 7, 10, 6 };
	System.out.println( "orig: " + java.util.Arrays.toString(yo) );
	heapify( yo );
	System.out.println( "heapified: " + java.util.Arrays.toString(yo) );
	System.out.println( "sorted: " + java.util.Arrays.toString(sort(yo)) );

	int[] yoo = { 12, 545, 17, 69, 607, 114, 6678, 1946, 18};
	System.out.println( "orig: " + java.util.Arrays.toString(yoo) );
	heapify( yoo );
	System.out.println( "heapified: " + java.util.Arrays.toString(yoo) );
	System.out.println( "sorted: " + java.util.Arrays.toString(sort(yoo)) );

    }//end main

}//end class HeapSort
