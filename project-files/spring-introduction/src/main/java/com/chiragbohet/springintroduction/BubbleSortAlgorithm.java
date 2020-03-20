package com.chiragbohet.springintroduction;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{

    public BubbleSortAlgorithm()
    {
        System.out.println("%%%%%%%%%%%%%%%%%Constructor : BubbleSortAlgorithm");
    }

    @Override
    public int[] sort(int[] numbers) {

        return numbers;
    }
}
