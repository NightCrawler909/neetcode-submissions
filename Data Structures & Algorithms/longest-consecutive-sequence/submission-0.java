class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int longestStreak = 0;

        for(int i = 0; i < nums.length ; i++){
            if(!set.contains(nums[i] - 1)){
                int curr = nums[i];
                int streak = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    streak++;
                }

                longestStreak = Math.max(streak,longestStreak);
            }
        }

        return longestStreak;
    }
}
