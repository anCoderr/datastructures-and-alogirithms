package SolutionsInJAVA;

public class Leetcode1137 {
    int[] mem = new int[37];
    public int tribonacci(int n) {
        if(n <= 2)
            return n == 0 ? 0 : 1;
        for(int i = 1; i<=3; i++)
            if(mem[n-i] == 0)
                mem[n-i] = tribonacci(n-i);
        return mem[n-1]+mem[n-2]+mem[n-3];
    }
}
