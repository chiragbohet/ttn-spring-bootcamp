package com.chiragbohet.springframeworkintroduction;


import com.chiragbohet.springframeworkintroduction.q3_SpringManagedLooselyCoupled.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

//Q2
//import com.chiragbohet.springframeworkintroduction.q2_LooselyCoupled.BinarySearchImpl;
//import com.chiragbohet.springframeworkintroduction.q2_LooselyCoupled.BubbleSortAlgorithm;
//		BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
//		BinarySearchImpl binarySearch = new BinarySearchImpl(bubbleSortAlgorithm);
//		int result = binarySearch.binarySearch(new int[]{1,2,3,4,5},4);
//		System.out.println(result);