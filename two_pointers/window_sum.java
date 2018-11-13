public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        // k <= 0 not k < 0
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }
        
        int[] sums = new int[nums.length - k + 1];
        
        //sums[0] is like the zero case in mathematical induction
        for (int i = 0; i < k; i++) {
            sums[0] += nums[i];
        }
        //all that matters is the index of the array
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i - 1 + k];
        }
        
        return sums;
    }
}
