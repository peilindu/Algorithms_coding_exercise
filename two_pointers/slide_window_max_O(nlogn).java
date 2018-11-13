public class Solution {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
	// this solution is O(nlogn)
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer> () {
                public int compare(Integer x, Integer y) {
                    return y - x;
                }
            });
        
        int curMax;
        if (k > 1) {
            for (int i = 0; i < k - 1; i++) {
                maxHeap.add(nums[i]);
            }
            curMax = maxHeap.peek();
        } else {
            curMax = nums[0];
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            curMax = maxHeap.peek();
            res.add(curMax);
            maxHeap.remove(nums[i-k+1]);
        }
        
        return res;
    }
}

