class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length;r++){
            for(int c = 0; c < board[0].length;c++){
                if(backTrack(board,word,r,c,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrack(char[][] board,String word,int r,int c,int index){
        if(index == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)){
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = backTrack(board,word,r+1,c,index + 1) ||
                        backTrack(board,word,r-1,c,index + 1) ||
                        backTrack(board,word,r,c+1,index + 1) ||
                        backTrack(board,word,r,c-1,index + 1);
        
        board[r][c] = temp;

        return found;
    }
}