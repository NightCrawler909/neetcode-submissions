class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            
            // If the set already has the character at 'right', 
            // shrink the window from the 'left' until the duplicate is removed.
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Now that it's safe, add the new character to the set
            set.add(s.charAt(right));
            
            // Calculate the size of the current valid window
            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}