class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> changePath = new ArrayList<>();
        backTrack(changePath,nums,target,0);
        return result;
    }

    private void backTrack(List<Integer> changePath,int[] nums, int target, int start){
        if(target == 0){
            result.add(new ArrayList<>(changePath));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = start; i < nums.length; i++){
            changePath.add(nums[i]);
            backTrack(changePath,nums,target - nums[i],i);
            changePath.remove(changePath.size() - 1);
        }
    }
}
