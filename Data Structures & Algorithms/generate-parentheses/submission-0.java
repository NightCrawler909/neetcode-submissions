class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder changePath = new StringBuilder();
        backTrack(changePath,0,0,n);
        return result;
        
    }

    private void backTrack(StringBuilder changePath, int open, int close, int n){
        if(changePath.length() == 2*n){
            result.add(changePath.toString());
            return;
        }

        if(open < n){
            changePath.append("(");
            backTrack(changePath,open + 1,close,n);
            changePath.deleteCharAt(changePath.length() - 1);
        }

        if(close < open){
            changePath.append(")");
            backTrack(changePath,open,close + 1,n);
            changePath.deleteCharAt(changePath.length() - 1);
        }
    }
}