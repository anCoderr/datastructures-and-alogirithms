package SolutionsInJAVA;

public class Leetcode5 {
    int[] isPalindrome(String s, int start, int end) {
        int[] ans = new int[2];
        while(start >= 0 && end < s.length()  && s.charAt(start) == s.charAt(end)) {
            if(start == 0 || end == s.length() - 1) {
                ans[0] = start;
                ans[1] = end;
                break;
            }
            ans[0] = start;
            ans[1] = end;
            start--;
            end++;
        }
        return ans;
    }
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int max[] = new int[2];
        if(s.length() == 0) {
            return "";
        }
        for(int i = 1; i<s.length() - 1; i++) {
            if(s.charAt(i-1) == s.charAt(i+1)) {
                max = isPalindrome(s, i-1, i+1);
                if(end - start< max[1] - max[0]) {
                    end = max[1];
                    start = max[0];
                }
            }
        }
        for(int i = 0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                max = isPalindrome(s, i, i+1);
                if(end - start< max[1] - max[0]) {
                    end = max[1];
                    start = max[0];
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
