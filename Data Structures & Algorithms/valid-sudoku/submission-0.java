class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.'){
                    continue;
                }

                int val = board[r][c] - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                if(row[r][val] || col[c][val] || boxes[boxIndex][val]){
                    return false;
                }

                row[r][val] = col[c][val] = boxes[boxIndex][val] = true;
            }
        }

        return true;

    }
}
