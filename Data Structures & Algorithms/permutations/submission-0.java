class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> changePath = new ArrayList<>();
        backTrack(changePath,nums);
        return result;

    }

    private void backTrack(List<Integer> changePath,int[] nums){
        if(changePath.size() == nums.length){
            result.add(new ArrayList<>(changePath));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            if(changePath.contains(nums[i])){
                continue;
            }

            changePath.add(nums[i]);
            backTrack(changePath,nums);
            changePath.remove(changePath.size() - 1);
        }
    }
}
