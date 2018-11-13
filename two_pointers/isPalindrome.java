public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isValid(s.charAt(front))) {
                front++;
            }
            
            if (front == s.length()) {
                return true;
            }
            
            while (end >= 0 && !isValid(s.charAt(end))){
                end--;
            }
            
            if (end == 0) {
                return true;
            }
            
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }
        
        // the while loop ends when front >= end or break
        // front == end when the string length is odd, otherwise even
        return end <= front;
    }
    
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
