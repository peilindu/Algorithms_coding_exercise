public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        
        if (numbers == null || numbers.length < 3) {
            return results;
        }
        
        Arrays.sort(numbers);
        
        for (int i = 0; i + 2 < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            
            int left = i + 1, right = numbers.length - 1;
            int target = 0 - numbers[i];
            
            twoSum(numbers, left, right, target, results);
        }
        
        return results;
    }
    
    private void twoSum(int[] numbers, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) {
                List<Integer> result = new ArrayList<Integer>();
                result.add(0-target);
                result.add(numbers[left]);
                result.add(numbers[right]);
                results.add(result);
                
                // I always forget to update the pointer when I get what I wanted.
                left++;
                right--;
                
                while (left < right && numbers[left] == numbers[left-1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right+1]) {
                    right--;
                }
            } else if (temp > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}