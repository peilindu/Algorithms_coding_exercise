public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 3) {
            return -1;
        }
        
        Arrays.sort(nums);
        
        int bestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i + 2 < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum;
                }
                
                //no relation to the twoSum question, only a way to move on
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return bestSum;
    }
}