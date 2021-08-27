package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class LeeAlgorithm {
    // The BFS based approach is what is known as LEE'S ALGORITHM.
    static int[] dr = new int[] {1,0,0,-1};
    static int[] dc = new int[] {0,1,-1,0};
    /*
    We can find how many times the recursive or iterative execution starts using static
    int ops. In almost all cases we will find that BFS based solution works better than
    the DFS one. It is because we are committing to every single branch till we find
    target or reach a deadened. In BFS we rather than committing to a single branch check
    possible branches and branch outwards.

    The DFS base solution might work better for smaller test cases but for an averagely sized
    test case the average time complexity of BFS is a lot better than DFS.

    One may also say that we are sort of "Playing It Safe" with BFS approach.
    */
    static int ops = 0;
    static class Runner {
        public static void main(String[] args) {
            int[][] maze1 = {
                    {0, 0, 0, 1, 0, 1, 0},
                    {1, 1, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0},
                    {0, 1, 1, 1, 0, 1, 0},
                    {0, 0, 0, 1, 0, 0, 1},
                    {0, 1, 0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0},
                    {0, 1, 1, 1, 0, 0, 0}};
            int[][] maze2 = {
                    {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
                    {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                    {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                    {0, 1, 0, 0, 0, 0, 1, 0, 1, 1},
                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 1, 0, 1, 1, 0}};
            int[][] solution1 = solutionToMazeProblemUsingDFS(maze1, 0, 0, 2, 6);
            for(int[] arr : solution1)
                System.out.println(Arrays.toString(arr));
            System.out.println(ops);
            ops=0;
            solution1 = solutionToMazeProblemUsingBFS(maze1, 0, 0, 2, 6);
            for(int[] arr : solution1)
                System.out.println(Arrays.toString(arr));
            System.out.println(ops);
            ops=0;
            int[][] solution2 = solutionToMazeProblemUsingDFS(maze2, 0, 0, 6, 9);
            for(int[] arr : solution2)
                System.out.println(Arrays.toString(arr));
            System.out.println(ops);
            ops=0;
            solution2 = solutionToMazeProblemUsingBFS(maze2, 0, 0, 6, 9);
            for(int[] arr : solution2)
                System.out.println(Arrays.toString(arr));
            System.out.println(ops);
        }
    }

    public static int[][] solutionToMazeProblemUsingDFS(int[][] maze, int sourceRow, int sourceCol, int targetRow, int targetCol) {
        int[][] ans = new int[maze.length][maze[0].length];
        if(!utilityFunctionDFS(maze,ans,sourceRow,sourceCol,maze.length,maze[0].length,targetRow,targetCol))
            System.out.println("Solution not found.");
        return ans;
    }
    public static int[][] solutionToMazeProblemUsingBFS(int[][] maze, int sourceRow, int sourceCol, int targetRow, int targetCol) {
        int[][] ans = new int[maze.length][maze[0].length];
        if(!utilityFunctionBFS(new LinkedList<>(),new LinkedList<>(),maze,ans,sourceRow,sourceCol,maze.length,maze[0].length,targetRow,targetCol))
            System.out.println("Solution not found.");
        return ans;
    }
    public static boolean utilityFunctionDFS(int[][] maze, int[][] solution, int row, int col, int maxRow, int maxCol, int targetRow, int targetCol) {
        ops++;
        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol)
            return false;
        solution[row][col] = 1;
        if(row == targetRow && col == targetCol)
            return true;
        for(int i = 0; i<4; i++) {
            int r = row + dr[i], c = col + dc[i];
            if (r < maxRow && r >= 0 && c < maxCol && c >= 0 && maze[r][c] == 0 && solution[r][c] == 0)
                if (utilityFunctionDFS(maze, solution, r, c, maxRow, maxCol, targetRow, targetCol))
                    return true;
        }
        solution[row][col] = 0;
        return false;
    }

    public static boolean utilityFunctionBFS(LinkedList<Integer> rowQueue, LinkedList<Integer> colQueue, int[][] maze, int[][] solution, int sourceRow, int sourceCol, int maxRow, int maxCol, int targetRow, int targetCol) {
        int row, col, r, c;
        rowQueue.add(sourceRow);
        colQueue.add(sourceCol);
        while(!rowQueue.isEmpty()) {
            ops++;
            row = rowQueue.poll();
            col = colQueue.poll();
            solution[row][col] = 1;
            if(row == targetRow && col == targetCol)
                return true;
            for(int i = 0; i<4; i++) {
                r = row + dr[i];
                c = col + dc[i];
                if (r < maxRow && r >= 0 && c < maxCol && c >= 0 && maze[r][c] == 0 && solution[r][c] == 0) {
                    rowQueue.push(r);
                    colQueue.push(c);
                }
            }
        }
        return false;
    }
}
