package SolutionsInJAVA;

public class Leetcode509 {
    public int fib(int n) {
        if(n <= 1)
            return n;
        int a = 0, b = 1, sum;
        while(n-- > 1) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return b;
    }
}
