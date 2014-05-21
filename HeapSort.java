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
    public static Integer[] sort( Integer[] data ) {
	heapify( data );
	return data;
    } //O(nlogn)

    private static void heapify( Integer[] data ) {
	for ( int i = 1; i < data.length; i++ ) {
	    int pos = i;
	    int parentPos;
	    while ( pos > 0 ) {
		parentPos = ( pos - 1 ) / 2;
		
		if( data[pos] < data[parentPos] ) {
		    swap( data, pos, parentPos );
		    pos = parentPos;
		}
		else {
		    break;
		}
	    }
	}
    }

    private static void swap( Integer[] data, int pos1, int pos2 ) {
	int temp = data[pos1];
	data[pos1] = data[pos2];
	data[pos2] = temp;
    }

    public static void main( String[] args ) {

	Integer[] yo = { 1, 7, 8, 3, 4, 9, 10, 13, 6 };
	System.out.println( "orig: " + java.util.Arrays.toString(yo) );
	heapify( yo );
	System.out.println( "heapified: " + java.util.Arrays.toString(yo) );

    }//end main

}//end class HeapSort