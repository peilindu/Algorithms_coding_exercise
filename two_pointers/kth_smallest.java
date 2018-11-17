public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        
        //treat the k as index of array to avoid calculating it according to the region 
        return findKth(nums, 0, nums.length - 1, k - 1);
    }
    
    private int findKth(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];
        
        int oldleft = left, oldright = right;
        int pivot = nums[(left + right)/2];
        
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        
        if (right >= k && oldleft <= right) {
            return findKth(nums, oldleft, right, k);
        } else if (left <= k && left <= oldright) {
            return findKth(nums, left, oldright, k);
        } else {
            return nums[k];
        }
    }
}