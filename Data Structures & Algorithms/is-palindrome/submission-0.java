class Solution {
    public boolean isPalindrome(String s) {
        String newstring = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");

        int start = 0;
        int end = newstring.length() - 1;

        while ( start < end){
            if(newstring.charAt(start) != newstring.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
