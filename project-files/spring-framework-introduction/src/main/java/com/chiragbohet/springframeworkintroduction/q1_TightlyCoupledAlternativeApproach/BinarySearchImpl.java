package com.chiragbohet.springframeworkintroduction.q1_TightlyCoupledAlternativeApproach;

public class BinarySearchImpl {

    /***
     * Searches for an integer in a integer array.
     * Does not require input to be sorted, sorts input the array internally if not already sorted.
     * @param numbers an integer array in which the number is to be searched.
     * @param numberToSearch the number which is to be searched
     * @return the index of number if found, else -1
     */
    public int binarySearch(int[] numbers, int numberToSearch) {

        // Checking if the array is already sorted
        boolean isSorted = isSortedIntegerArrayUtility(numbers);
        System.out.println("is sorted : " + isSorted);

        // If not sorted, first sort
        if (!isSorted) {

            // Tight Coupling : Alternative approach
            BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
            bubbleSortAlgorithm.sort(numbers);

        }

        return binarySearchUtility(numbers, numberToSearch, 0, numbers.length - 1);

    }

    /***
     * A utility function which checks if the array is sorted or not (in increasing order)
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
     * @return index of the element if found, else -1
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
