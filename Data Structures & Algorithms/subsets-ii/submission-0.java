class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> changePath = new ArrayList<>();
        backTrack(changePath,nums,0);
        return result;
    }

    private void backTrack(List<Integer> changePath, int[] nums,int start){
        result.add(new ArrayList<>(changePath));

        for(int i = start; i < nums.length; i++){

            if(i > start && nums[i] == nums[i-1]){
                continue;
            };
            changePath.add(nums[i]);
            backTrack(changePath,nums,i+1);
            changePath.remove(changePath.size() - 1);
        }
    }
}
