package SolutionsInJAVA;

public class Leetcode304 {
    int[][] sums;
    int maxRow, maxCol;
    public void NumMatrix(int[][] matrix) {
        int temp;
        maxRow = matrix.length;
        maxCol = matrix[0].length;
        sums = new int[maxRow+1][maxCol+1];
        for(int i = 1; i<=maxRow; i++) {
            temp = 0;
            for(int j = 1; j<=maxCol; j++) {
                temp += matrix[i-1][j-1];
                sums[i][j] = temp;
            }
        }
        for(int i = 1; i<=maxRow; i++) {
            for(int j = 1; j<=maxCol; j++) {
                sums[i][j] += sums[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int diag, upper, left, ans;
        diag = sums[row1][col1];
        upper = sums[row1][col2+1];
        left = sums[row2+1][col1];
        ans = sums[row2+1][col2+1];
        return ans - upper - left + diag;
    }
}
