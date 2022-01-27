package algorithms_in_java;

public class MergeSort {

	void merge(int[] nums, int low, int mid, int high) {
		
		int[] copy = new int[nums.length];
		for(int i = 0;i<copy.length;i++) {
			copy[i] = nums[i];
		}
		
		int first = low;
		int second = mid+1;
		int ptr = low;
		
		while(first <= mid && second <= high) {
			if(nums[first] <= nums[second]) {
				copy[ptr] = nums[first];
				first++;
			}
			else {
				copy[ptr] = nums[second];
				second++;
			}
			ptr++;
		}
		while(first <= mid) {
			copy[ptr] = nums[first];
			first++;
			ptr++;
		}
		
		while(second <= high) {
			copy[ptr] = nums[second];
			second++;
			ptr++;
		}
		for(int i = 0;i<copy.length;i++) {
			nums[i] = copy[i];
		}
		
	}

	
	void sort(int[] nums, int low, int high) {
		
		if(low < high) {
			int mid = low + (high-low)/2;
			sort(nums, low, mid);
			sort(nums, mid+1, high);
			merge(nums, low, mid, high);
		}
	}
	
	void sort(int[] nums){
		if(nums == null || nums.length == 0) return;
		sort(nums, 0, nums.length-1);
	}
	

	
}
