class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        backTrack(path, s, 0);
        return result;
    }

    private void backTrack(List<String> path, String s, int start) {
        // 1. BASE CASE: The left cut reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 2. CHOICES: Try placing the right cut (i) everywhere from 'start' to the end
        for (int i = start; i < s.length(); i++) {
            
            // 3. CONSTRAINT: Only proceed if this specific slice is a palindrome
            if (isPalindrome(s, start, i)) {
                
                // MAKE CHOICE: Extract the slice and add to path
                path.add(s.substring(start, i + 1));
                
                // RECURSIVE STEP: Move the left cut to just after the right cut
                backTrack(path, s, i + 1);
                
                // 4. BACKTRACK
                path.remove(path.size() - 1);
            }
        }
    }

    // Helper method to check if a slice is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}