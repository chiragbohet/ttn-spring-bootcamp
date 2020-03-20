package com.chiragbohet.springintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIntroductionApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringIntroductionApplication.class, args);
		System.out.println("%%%%%%%%%%%%%%%%%%Application running!");
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);


		int result = binarySearch.binarySearch(new int[] {1,5,3,54,6},5);
		System.out.println(result);


	}

}
