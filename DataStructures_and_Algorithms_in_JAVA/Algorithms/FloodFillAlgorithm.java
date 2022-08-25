package Algorithms;

import java.util.Arrays;

public class FloodFillAlgorithm {
    static int[] dR = new int[] {1,-1,0,0};
    static int[] dC = new int[] {0,0,1,-1};

    static class Runner {
        public static void main(String[] args) {
            int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 0, 0},
                              {1, 0, 0, 1, 1, 0, 1, 1},
                              {1, 2, 2, 2, 2, 0, 1, 0},
                              {1, 1, 1, 2, 2, 0, 1, 0},
                              {1, 1, 1, 2, 2, 2, 2, 0},
                              {1, 1, 1, 1, 1, 2, 1, 1},
                              {1, 1, 1, 1, 1, 2, 2, 1},};
            for(int[] arr : screen)
                System.out.println(Arrays.toString(arr));
            floodFill(screen, 3, 4, 8);
            floodFill(screen, 0, 0, 9);
            System.out.println("\nAfter colouring :\n");
            for(int[] arr : screen)
                System.out.println(Arrays.toString(arr));
        }
    }

    public static void floodFill(int[][] screen, int sourceRow, int sourceCol, int targetColor) {
        dfsUtility(screen, sourceRow, sourceCol, screen.length, screen[0].length, targetColor, screen[sourceRow][sourceCol]);
    }
    public static void dfsUtility(int[][] screen, int row, int col, int maxRow, int maxCol, int targetColor, int startingColor) {
        screen[row][col] = targetColor;
        int r,c;
        for(int i = 0; i<4; i++) {
            r = row+dR[i];
            c = col+dC[i];
            if(r>=0 && r<maxRow && c>=0 && c<maxCol && screen[r][c] == startingColor)
                dfsUtility(screen, r, c, maxRow, maxCol, targetColor, startingColor);
        }
    }
}
