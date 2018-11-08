public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int start = 1, end = m * n;
        int x = 0, y = 0;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int[] index = convert(mid, n);
            x = index[0]; y = index[1];
            
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        int[] start_index = convert(start, n);
        int x_start = start_index[0],  y_start = start_index[1];
        if (x_start < m && y_start < n && matrix[x_start][y_start] == target) {
            return true;
        }
        
        int[] end_index = convert(end, n);
        int x_end = end_index[0],  y_end = end_index[1];
        if (x_end < m && y_end < n && matrix[x_end][y_end] == target) {
            return true;
        }
        
        return false;
        
    }
    
    private int[] convert(int index, int columns) {
        int[] result = new int[2];
        result[0] = index / columns;
        result[1] = index % columns - 1;
        
        if (result[1] < 0) {
            result[0]--;
            result[1] += columns;
        }
        
        return result;
    }
}