package SolutionsInJAVA;

public class Leetcode7 {
    public int reverse(int x) {
        boolean isNegative = false;
        long ans = 0;
        int y = x;
        if(y < 0) {
            y = -y;
            isNegative = true;
        }
        int i = (int)(Math.log10(y));
        while(y > 0) {
            ans = ans + (y%10)*(long)Math.pow(10,i);
            y/=10;
            i--;
        }
        if(ans>2147483647 || ans<-214748348)
            return 0;
        return isNegative? -(int)ans:(int)ans;
    }
}
