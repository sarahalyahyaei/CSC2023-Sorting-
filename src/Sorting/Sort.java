package Sorting;
/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/19   ***/
/***     Extended by: Sarah Al Yahyaei  19/10/19   ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

    /**
     * Size of array
     **/
    private int size;

    /**
     * Number of used elements in array
     **/
    private int usedSize;

    /**
     * Array of integers
     **/
    private int[] A;

    /**
     * Global variables for counting sort comparisons
     **/
    public int compIS;
    /**
     * Global comparison count for Insertion Sort
     **/
    public int compQS;
    /**
     * Global comparison count for Quicksort
     **/
    public int compNS;

    /**
     * Global comparison count for newsort
     **/

    //Getter method to let the outside class get the size of an array to be used in quick sort method
    public int getSize() {
        return size;
    }

    /***************/
    /** Constructor **/
    /*****************/
    public Sort(int max) {
        /** Initialiase global sort count variables **/
        compIS = 0;
        compQS = 0;
        compNS = 0;

        /** Initialise size variables **/
        usedSize = 0;
        size = max;

        /** Create Array of Integers **/
        A = new int[size];
    }

/*********************************************/
/*** Read a file of integers into an array ***/
    /*********************************************/

    public void readIn(String file) {

        try {
            /** Initialise loop variable **/
            usedSize = 0;

            /** Set up file for reading **/
            FileReader reader = new FileReader(file);
            Scanner in = new Scanner(reader);

            /** Loop round reading in data while array not full **/
            while (in.hasNextInt() && (usedSize < size)) {
                A[usedSize] = in.nextInt();
                usedSize++;
            }

        } catch (IOException e) {
            System.out.println("Error processing file " + file);
        }

    }

/**********************/
/*** Display array  ***/
    /**********************/
    public void display(int line, String header) {
        /*** Integer Formatter - three digits ***/
        NumberFormat FI = NumberFormat.getInstance();
        FI.setMinimumIntegerDigits(3);

        /** Print header string **/
        System.out.print("\n" + header);

        /** Display array data **/
        for (int i = 0; i < size; i++) {
            /** Check if new line is needed **/
            if (i % line == 0) {
                System.out.println();
            }

            /** Display an array element **/
            System.out.print(FI.format(A[i]) + " ");
        }
    }


    /**
     * This Area Is Extended By Sarah Al Yahyaei
     */

    /*********************************************
     * Sort number 1
     *********************************************/
    //Insertion method to sort:
    public void insertionSort() {
        //This loop to find the smallest value in each iterate
        for (int i = 0; i < size; i++) {
            //Store the value to insert
            int key = A[i];
            int j = i; // J represent the current index

        /*
            Finding the correct position to insert the key
         */

            while (j > 0 && key < A[j - 1]) {
                compIS++; //increment if it goes inside the loop
                A[j] = A[j - 1]; // move the space to the left space and A[j] to the right
                j = j - 1;
            }
            compIS++; //Increment the number of comparisons if while loop was false
            A[j] = key; // Insert key into its correct position
        }
    }

    /**
     * Sort number 2
     *
     * @param l
     * @param r
     */
    //Quick Sort method to sort
    public void quickSort(int l, int r) {
        if (r > l) {
            int p = partitioning(l, r);
            quickSort(l, p - 1); //  the elements before pivot on the left
            quickSort(p + 1, r); // the elements after the pivot on the right side
        }
    }

    //Method to do the partitioning that is associate with quicksort method
    public int partitioning(int l, int r) {
        int pivot = A[r]; //last element
        int pL = l; // left pointer
        int pR = r ; // right pointer start on the previous element for the pivot

        //While pointer on the left side less than the pointer on the last element
        while (pL < pR) {
            while (A[pL] < pivot) { //while pointer on the left less than the pivot
                compQS++; //Increment the counter if it true on while
                pL = pL + 1; // Increment the left pointer
            }
            compQS++; //if while A(pL) < pivot is false
            while (A[pR] >= pivot && pR > l) {
                compQS++;// Increment the counter
                pR = pR - 1; //Decrease the pointer to go to its left side element
            }
            if (pL < pR) {
                //When the pointers on the left is less than the pointer on the right
                swap(A, pL, pR);
            }
        }
        //Return pivot on its correct position
        swap(A, pL, r);
        return pL;
    }
    /**
     * Sort number 3
     */
    //New sort algorithm
    public  void newSort() {
        int pos = 0; //Current index
        while (pos < A.length) {
            int min = findMinFrom(A, pos); // To return the min value in each iteration
            for (int i = pos; i <A.length; i++) {
                if (A[i] == min) {
                    compNS++; //One comparison has made so counter should be increased by 1
                    swap(A,i, pos);
                    pos = pos+1;

                }
                // if false
                compNS++;
            }
        }
    }

    // Method to return the min value in the element
    public  int findMinFrom(int[] A, int pos) {
        int min = A[pos];
        for (int i = pos+1; i <A.length; i++) {
            if (A[i] < min) {
                compNS++;
                min = A[i];
            }
            //if false
            compNS++;
        }
        return min;


    }

    /**
     * General method to be used in sorting 2 and 3
     * To swap elements
     * @param
     * @param i
     * @param pos
     */
    //Swap elements method
    public static void swap(int A[],int i, int pos) {
        int tem = A[i];
        A[i] = A[pos];
        A[pos] = tem;
    }

}  /**
 * End of Sort Class
 **/
