package com.chiragbohet.springframeworkintroduction.q3_SpringManagedLooselyCoupled;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortingAlgorithm {

    /***
     * Sorts an integer array using Quick sort
     * @param numbers an integer array
     * @return  an sorted integer array
     */
    @Override
    public int[] sort(int[] numbers)
    {
        QuickSortUtility(numbers, 0, numbers.length - 1);
        return numbers;
    }

    /***
     * Performs the partition process of Quicksort
     * @param arr an integer array
     * @param low the lower index of the array
     * @param high the higher index array
     * @return the array partitioned around pivot element
     */
    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    /***
     * Performs the actual quicksort.
     * @param arr an integer array
     * @param low the lower index of the array
     * @param high the higher index of the array
     */
    private void QuickSortUtility(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            QuickSortUtility(arr, low, pi-1);
            QuickSortUtility(arr, pi+1, high);
        }
    }

}
