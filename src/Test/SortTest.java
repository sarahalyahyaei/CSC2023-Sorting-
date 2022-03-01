package Test;

import Sorting.Sort;

/***
 * @Produced by Sarah Al Yahyaei
 * @Date: 19/10/19
 */
public class SortTest {

    public static void main(String[] args) {
        /**
         * Testing Number 1 to display array before and after using the three
         * methods with file test1.txt
         */

        Sort sortTest1 = new Sort(51);
        Sort sortTest2 = new Sort(51);
        Sort sortTest3 = new Sort(51);

        /**
         * Insertion sort method
         */

        System.out.println("Insertion method");
        sortTest1.readIn("test1.txt");
        //Display array without sorting
        sortTest1.display(15, "Array before sorting");
        System.out.println("\nNumber of comparisons is: " + sortTest1.compIS);
        //After that
        sortTest1.insertionSort();
        sortTest1.display(15, "Array after sorting");
        System.out.println("\nNumber of comparisons is :" + sortTest1.compIS);

        /**
         * Quick Sort method
         */
        System.out.println("\nQuick Sort method");
        sortTest2.readIn("test1.txt");
        //Display before sorting
        sortTest2.display(15, "Array before sorting");
        System.out.println("\nNumber of comparisons: " + sortTest2.compQS);
        //Apply the sorting method
        sortTest2.quickSort(0, sortTest2.getSize() - 1);
        sortTest2.display(15, "Array after sorting");
        System.out.println("\nNumber of comparisons: " + sortTest2.compQS);

        /**
         * New sort method
         */

        System.out.println("\nNew sort method");
        sortTest3.readIn("test1.txt");
        //display before sorting
        sortTest3.display(15, "Array before sorting");
        System.out.println("\nNumber of comparisons :" + sortTest3.compNS);
        sortTest3.newSort();
        sortTest3.display(15, "Array after sorting");
        System.out.println("\nNumber of comparisons :" + sortTest3.compNS + "\n");

        /**
         * Second test
         * will test the other 5 files and show the number of comparisons that
         * has been made on each array with the three sorting methods
         */


        /**
         * files from test2 to test6 will be tested with insertion method
         */
        System.out.println("Insertion method ");
        // 1) test2.txt file
        Sort sort = new Sort(51);
        sort.readIn("test2.txt");
        sort.insertionSort();
        System.out.println("Number of comparisons in test2.txt: " + sort.compIS);

        // 2) test3.txt file
        Sort sort1 = new Sort(51);
        sort1.readIn("test3.txt");
        sort1.insertionSort();
        System.out.println("Number of comparisons in test3.txt: " + sort1.compIS);

        // 3) test4.txt file
        Sort sort2 = new Sort(1001);
        sort2.readIn("test4.txt");
        sort2.insertionSort();
        System.out.println("Number of comparisons in test4.txt: " + sort2.compIS);


        // 4) test5.txt file
        Sort sort3 = new Sort(1001);
        sort3.readIn("test5.txt");
        sort3.insertionSort();
        System.out.println("Number of comparisons in test5.txt: " + sort3.compIS);

        // 5) test6.txt file
        Sort sort4 = new Sort(1001);
        sort4.readIn("test6.txt");
        sort4.insertionSort();
        System.out.println("Number of comparisons in test6.txt: " + sort4.compIS + "\n");

        /**
         * files from test2 to test 6 with quick sort method
         */

        System.out.println("Quick sort method");
        //1) test2.txt
        Sort sort11 = new Sort(51);
        sort11.readIn("test2.txt");
        sort11.quickSort(0, sort11.getSize() - 1);
        System.out.println("Number of comparisons in test2.txt: " + sort11.compQS);

        //2) test3.txt
        Sort sort22 = new Sort(51);
        sort22.readIn("test3.txt");
        sort22.quickSort(0, sort22.getSize() - 1);
        System.out.println("Number of comparisons in test3.txt: " + sort22.compQS);

        //3) test4.txt
        Sort sort33 = new Sort(1001);
        sort33.readIn("test4.txt");
        sort33.quickSort(0, sort33.getSize() - 1);
        System.out.println("Number of comparisons in text4.txt: " + sort33.compQS);

        //4) test5.txt
        Sort sort44 = new Sort(1001);
        sort44.readIn("test5.txt");
        sort44.quickSort(0, sort44.getSize() - 1);
        System.out.println("Number of comparisons in test5.txt: " + sort44.compQS);
        //5) test6.txt
        Sort sort55 = new Sort(1001);
        sort55.readIn("test6.txt");
        sort55.quickSort(0, sort55.getSize() - 1);
        System.out.println("Number of comparisons in test6.txt: " + sort55.compQS);

        /**
         * Files from test2 to test6 with be tested with new sort method
         *
         */
        System.out.println("\nNew sort method");
        //1) test2.txt
        Sort sort111 = new Sort(51);
        sort111.readIn("test2.txt");
        sort111.newSort();
        System.out.println("Number of comparisons in test2.txt: " + sort111.compNS);
        //2) test3.txt
        Sort sort222 = new Sort(51);
        sort222.readIn("test3.txt");
        sort222.newSort();
        System.out.println("Number of comparisons in test3.txt: " + sort222.compNS);
        //3)test4.txt
        Sort sort333 = new Sort(1001);
        sort333.readIn("test4.txt");
        sort333.newSort();
        System.out.println("Number of comparisons in test4.txt: " + sort333.compNS);

        //4 test5.txt
        Sort sort444 = new Sort(1001);
        sort444.readIn("test5.txt");
        sort444.newSort();
        System.out.println("Number of comparisons in test5.txt: " + sort444.compNS);

        //5 test6.txt
        Sort sort555 = new Sort(1001);
        sort555.readIn("test6.txt");
        sort555.newSort();
        System.out.println("Number of comparisons in test6.txt: " + sort555.compNS);
    }

}
