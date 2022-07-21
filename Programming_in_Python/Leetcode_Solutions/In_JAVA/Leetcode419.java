package SolutionsInJAVA;

public class Leetcode419 {
    int ans = 0;
    int maxRow, maxCol;
    char[][] board;
    public int countBattleships(char[][] board) {
        this.board = board;
        maxRow =  board.length;
        maxCol = board[0].length;
        boolean align;
        for(int i = 0; i<maxRow; i++)
            for(int j = 0; j<maxCol; j++)
                if(board[i][j] == 'X') {
                    if((i-1 >= 0 && board[i-1][j] == 'X')||(i+1 < maxRow && board[i+1][j] == 'X'))
                        align = true;
                    else
                        align = false;
                    updateBoard(i, j, align);
                    ans++;
                }
        return ans;
    }
    public void updateBoard(int row, int col, boolean align) {
        board[row][col] = '*';
        if(align) {
            if(row-1 >= 0 && board[row-1][col] == 'X')
                updateBoard(row-1,col,align);
            if(row+1 < maxRow && board[row+1][col] == 'X')
                updateBoard(row+1,col,align);
        } else {
            if(col-1 >= 0 && board[row][col-1] == 'X')
                updateBoard(row,col-1,align);
            if(col+1 < maxCol && board[row][col+1] == 'X')
                updateBoard(row,col+1,align);
        }
    }
}
