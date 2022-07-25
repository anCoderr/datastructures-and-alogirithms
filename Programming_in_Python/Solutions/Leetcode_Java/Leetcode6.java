package SolutionsInJAVA;

public class Leetcode6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int factor = 2*numRows - 2;
        int size = s.length();
        for(int i = 0 ; i < numRows; i++) {
            for(int j = 0; j + i < size; j += factor) {
                ans.append(s.charAt(j + i ));
                if(i != 0 && i != numRows - 1 && j + factor - i < size) {
                    ans.append(s.charAt(j + factor - i));
                }
            }
        }
        return ans.toString();
    }
}
