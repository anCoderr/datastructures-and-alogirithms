package SolutionsInJAVA;

public class Leetcode633 {
    public boolean judgeSquareSum(int c) {
        int j = (int)Math.sqrt((double)c), i = 0;
        int sum;
        while(i <= j) {
            sum = i*i + j*j;
            if(sum == c)
                return true;
            else if(sum > c)
                j--;
            else
                i++;
        }
        return false;
    }
}
