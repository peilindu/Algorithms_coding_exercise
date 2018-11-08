public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        long result = 1, base = a;
        
        while (n != 0) {
            if (n % 2 == 1) {
                result = (result * base) % b;
            }
            base = (base * base) % b;
            n = n / 2;
        }
        
        return (int)result % b;
    }
}