package com.chiragbohet.springframeworkintroduction.q3_SpringManagedLooselyCoupled;

import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm implements SortingAlgorithm {
    /***
     * Sorts an integer array using Bubble sort
     * @param numbers an integer array
     * @return  an sorted integer array
     */
    @Override
    public int[] sort(int[] numbers)
    {
        for (int pass = 1; pass <= numbers.length - 1; pass++)
        {
            for(int currentIndex = 0; currentIndex <= numbers.length - 2; currentIndex++)
            {
                if(numbers[currentIndex] > numbers[currentIndex+1])
                {
                    //swapping
                    int temp = numbers[currentIndex];
                    numbers[currentIndex] = numbers[currentIndex+1];
                    numbers[currentIndex+1] = temp;
                }

            }
        }

        return numbers;
    }

}
