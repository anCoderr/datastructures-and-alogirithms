package SolutionsInJAVA;

public class Leetcode9 {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        String buffer = Integer.toString(x);
        boolean ans = true;
        int front = 0;
        int end = buffer.length() - 1;
        while(front <= buffer.length()/2) {
            if(buffer.charAt(front) != buffer.charAt(end)) {
                ans = false;
            }
            front++;
            end--;
        }
        return ans;
    }
}
