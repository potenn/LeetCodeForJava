public class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		for(int i = 0 ; i < nums.length ; i++){
			priorityQueue.offer(nums[i]);
		}

		int j = 0;
		for(int i = 0 ; i < (nums.length - k) ; i++){
		    priorityQueue.poll();
		}

        return priorityQueue.peek();
    }
}
