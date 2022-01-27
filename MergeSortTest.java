package algorithms_in_java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;

class MergeSortTest {

	private MergeSort mergeSort;

	private int[] nums;
	
	private int[] sorted;
	
	private Random randomNumberGenerator;

	private MergeSortTest given_n_arbitrary_numbers(int n){
		nums = new int[n];
		for(int i = 0;i<n;i++) {
			nums[i] = randomNumberGenerator.nextInt();
		}
		sorted = Arrays.copyOf(nums, n);
		Arrays.sort(sorted);
		return this;
	}
	
	
	private MergeSortTest given_n_equal_numbers(int n){
		nums = new int[n];
		int num = randomNumberGenerator.nextInt();
		for(int i = 0;i<n;i++) {
			nums[i] = num;
		}
		
		sorted = Arrays.copyOf(nums, n);
		return this;
	}
	
	private MergeSortTest given_null_input(){
		nums = null;
		sorted = null;
		return this;
	}
	
	private MergeSortTest given_empty_input(){
		nums = new int[0];
		sorted = new int[0];
		return this;
	}
	
	
	private MergeSortTest when_sort_applied() {
		if(nums!=null && nums.length > 0) {
			mergeSort.sort(nums);
		}
		return this;
	}
	private MergeSortTest then_sorted() {
		assertArrayEquals(sorted, nums);
		return this;
	}
	private MergeSortTest then_null_output() {
		assertNull(nums);
		return this;
	}
	private MergeSortTest then_empty_output() {
		assertEquals(nums.length, 0);
		return this;
	}
	
	
	@BeforeEach
	void setUp() throws Exception {
		mergeSort = new MergeSort();
		randomNumberGenerator = new Random();
	}

	@AfterEach
	void tearDown() throws Exception {
		nums = null;
		sorted = null;
	}


	@Test
	void test_sorted_two_numbers() {
		given_n_arbitrary_numbers(2).when_sort_applied().then_sorted();
	}
	
	@Test
	void test_sorted_one_number() {
		given_n_arbitrary_numbers(1).when_sort_applied().then_sorted();
	}

	@Test
	void test_sorted_large_size() {
		given_n_arbitrary_numbers(10).when_sort_applied().then_sorted();
	}
	
	@Test
	void test_sorted_two_equal_numbers() {
		given_n_equal_numbers(2).when_sort_applied().then_sorted();
	}
	
	@Test
	void test_null_input() {
		given_null_input().when_sort_applied().then_null_output();
	}
	
	@Test
	void test_empty_input() {
		given_empty_input().when_sort_applied().then_empty_output();
	}

}
