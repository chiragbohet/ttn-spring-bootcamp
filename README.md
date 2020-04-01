## Exercise : Spring Framework

#### Q1. Write a program to demonstrate Tightly Coupled code. 

### [BinarySearchImpl](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q1_TightlyCoupled/BinarySearchImpl.java)

```java
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

            // Tight Coupling : Bubble sort logic is used internally
            for (int pass = 1; pass <= numbers.length - 1; pass++)  // n - 1 passes
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
```

##### The above class is tightly coupled with BubbleSort logic. If we wanted to make any changes to the BubbleSort logic or use any other sorting algorithm other than Bubble Sort we have to change the code inside ```binarySearch()``` manually. 

##### An alternative approach could be as shown below

[BinarySearchImpl](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q1_TightlyCoupledAlternativeApproach/BinarySearchImpl.java)

```java
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
```

[BubbleSortAlgorithm](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q1_TightlyCoupledAlternativeApproach/BubbleSortAlgorithm.java)

```java
public class BubbleSortAlgorithm {
    
    /***
     * Sorts an integer array using Bubble sort
     * @param numbers an integer array
     * @return  an sorted integer array
     */
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
```

##### In the alternative approach we have moved out the logic of Bubble Sort algorithm to a seperate class. Now if we want to modify the logic of Bubble Sort algorithm we can do that easily. 
##### But, we are still left with 2 issues. 
##### 1. If we wanted to use Quick Sort instead of Bubble Sort we can't do that still. 
##### 2. If we wanted to dynamically change the sorting algorithm we can't do that.

#### Q2. Write a program to demonstrate Loosely Coupled code.

[BinarySearchImpl](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q2_LooselyCoupled/BinarySearchImpl.java)

```java
public class BinarySearchImpl {

    // Loose Coupling : SortingAlgorithm is now a dependency of BinarySearchImpl
    SortingAlgorithm sortingAlgorithm;
    
    // Passing in dependency using constructor 
    public BinarySearchImpl(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

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

```

[SortingAlgorithm](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q2_LooselyCoupled/SortingAlgorithm.java)

```java
public interface SortingAlgorithm {
    int[] sort(int[] numbers);
}
```

[BubbleSortAlgorithm](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q2_LooselyCoupled/BubbleSortAlgorithm.java)

```java
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
```

##### The above implementation of Binary Search is loosely coupled with sorting logic. We can make changes to our sorting logic (in isolation, without making any internal changes to binary search) as well change the sorting algorithm dynamically by passing it as an constructor argument as shown below.

```java
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		BinarySearchImpl binarySearch = new BinarySearchImpl(bubbleSortAlgorithm);
		int result = binarySearch.binarySearch(new int[]{1,2,3,4,5},4);
		System.out.println(result);
```

#### Q3. Use @Component and @Autowired annotations in Loosely Coupled code for dependency management

[BinarySearchImpl](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q3_SpringManagedLooselyCoupled/BinarySearchImpl.java)

```java
@Component
public class BinarySearchImpl {

    // SortingAlgorithm is now a dependency of BinarySearchImpl
    @Autowired
    SortingAlgorithm sortingAlgorithm;

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
```

[BubbleSortAlgorithm](com/chiragbohet/springframeworkintroduction/q3_SpringManagedLooselyCoupled/BubbleSortAlgorithm.java)

```java
@Component
public class BubbleSortAlgorithm implements SortingAlgorithm {

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
```

#### Q4. Get a Spring Bean from application context and display its properties.

```java
@SpringBootApplication
public class SpringFrameworkIntroductionApplication {

	public static void main(String[] args) {

	ApplicationContext applicationContext =	SpringApplication.run(SpringFrameworkIntroductionApplication.class, args);
	BinarySearchImpl binarySearchBean =  applicationContext.getBean(BinarySearchImpl.class);
	System.out.println("Object hashcode : " + binarySearchBean.hashCode());

	int result =  binarySearchBean.binarySearch(new int[]{0,1,2,3,4},3);
	System.out.println("Found at index : " + result);
	
	}

}
```

#### Q5 Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)
##### Ambiguity occurs when two or more matching beans are found for one dependency. We can give priority to one bean in such case using ```@Primary```  annotation. 
##### Suppose we add another QuickSortAlgorithm class which implements SortAlgorithm interface  and annotated it using ```@Component``` annotation.

### Suppose we add another matching ```@Component``` QuickSortAlgorithm for ```SortingAlgorithm``` interface.

```java
@Component
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

```

##### Now if we try to run the program we will get an error as ***required a single bean, but 2 were found***

##### We can resolve this error by adding ```@Primary``` annotation to one of the beans. 
##### Suppose we make QuickSortAlgorithm our primary bean as shown below : 

[QuickSortAlgorithm](project-files/spring-framework-introduction/src/main/java/com/chiragbohet/springframeworkintroduction/q3_SpringManagedLooselyCoupled/QuickSortAlgorithm.java)

```java
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
```

#### Now the program will run without any errors. 

#### Q6 Perform Constructor Injection in a Spring Bean

#### Constructor injection means passing in Dependencies using constructor. 

```java
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

```