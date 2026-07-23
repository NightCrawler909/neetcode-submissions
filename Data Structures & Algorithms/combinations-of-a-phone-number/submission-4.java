class Solution {
    List<String> result = new ArrayList<>();
    // Map indices directly to phone pad keys (0 and 1 are empty)
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        // Edge case: empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backTrack(new StringBuilder(), digits, 0);
        return result;
    }

    private void backTrack(StringBuilder path, String digits, int index) {
        // 1. BASE CASE: We translated every digit
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // Get the letters for the current digit (e.g., '2' -> "abc")
        String letters = map[digits.charAt(index) - '0'];

        // 2. CHOICES: Loop through the mapped letters
        for (int i = 0; i < letters.length(); i++) {
            
            // MAKE CHOICE
            path.append(letters.charAt(i));
            
            // RECURSIVE STEP: Move to the next digit in the input string
            backTrack(path, digits, index + 1);
            
            // 4. BACKTRACK
            path.deleteCharAt(path.length() - 1);
        }
    }
}