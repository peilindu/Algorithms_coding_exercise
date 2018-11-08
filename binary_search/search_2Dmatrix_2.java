public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix[0].length, n = matrix.length;
        int x = n - 1, y = 0;
        int count = 0;
        
        while (x >= 0 && y < m) {
            if (matrix[x][y] == target) {
                x--;
                y++;
                count++;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        } 
        
        return count;
    }
}