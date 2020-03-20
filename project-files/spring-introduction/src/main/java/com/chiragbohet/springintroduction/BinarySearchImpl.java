package com.chiragbohet.springintroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    //3 (the solution)
    @Autowired
    private SortAlgorithm sortAlgorithm;

//    public BinarySearchImpl()
//    {
//        System.out.println("%%%%%%%%%%%%%%%%%Constructor : BinarySearchImpl default ");
//    }
//
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
        System.out.println("%%%%%%%%%%%%%%%%%Constructor : BinarySearchImpl parameterized");
    }


//    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }

    public int binarySearch(int[] numbers, int numberToSearch)
    {
        // sort the numbers
        // Two ways :

        // 1
        // can implement sorting directly here, no in future if I needed to change my sorting algorithm ill have to change this code.
        // very tighly coupled

        //2
        //BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        //int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
        // better but still I need to change the code manually if I want to change the algorithm example quicksort
        // what if I want to dynamically change the sorting algorithms
        // sometime I want to use bubblesort, othertime quicksort.

        //3 (the solution)
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println("Using :" + sortAlgorithm);

        // find in sorted numbers

        // return the result

        return 3;
    }
}
