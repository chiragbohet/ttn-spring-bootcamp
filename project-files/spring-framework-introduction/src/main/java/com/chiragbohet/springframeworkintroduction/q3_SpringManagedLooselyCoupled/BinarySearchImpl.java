package com.chiragbohet.springframeworkintroduction.q3_SpringManagedLooselyCoupled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    // SortingAlgorithm is now a dependency of BinarySearchImpl
    @Autowired
    SortingAlgorithm sortingAlgorithm;

    // Constructor Injection of Dependency
    public BinarySearchImpl(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    /***
     * A binary search implementation which searches for a number inside a given array.
     * @param numbers   a array of integers in which the number is to be searched.
     * @param numberToSearch the number which is needed to be searched.
     * @return index of the number in array.
     */
    public int binarySearch(int[] numbers, int numberToSearch) {

        // Checking if the array is already sorted
        boolean isSorted = isSortedIntegerArrayUtility(numbers);

        // If not sorted, first sort
        if (!isSorted) {

            numbers = sortingAlgorithm.sort(numbers);

        }

        return binarySearchUtility(numbers, numberToSearch, 0, numbers.length - 1);

    }

    /***
     * A utility function which checks if the already sorted or not (in increasing order)
     * @param numbers an integer array
     * @return
     *      true : if array is sorted
     *      false : if array is not sorted
     */
    private boolean isSortedIntegerArrayUtility(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1)
            return true;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /***
     * A utility function which performs the actual Binary Search.
     * @param numbers an integer array in which the number is to be searched.
     * @param numberToSearch the number which is to be searched
     * @param low the lower index of the array
     * @param high the higher index of the array
     * @return index where element is found
     */
    private int binarySearchUtility(int[] numbers, int numberToSearch, int low, int high) {

        if (high >= low)    // for cases if number is not in array
        {
            int mid = low + ( high - low ) / 2;

            if (numberToSearch == numbers[mid])
                return mid; // base case
            else if (numberToSearch > numbers[mid])
                return binarySearchUtility(numbers, numberToSearch, mid + 1, high);
            else if (numberToSearch < numbers[mid])
                return binarySearchUtility(numbers, numberToSearch, low, mid - 1);

        }

        return -1;
    }
}
