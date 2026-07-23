class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> changePath = new ArrayList<>();
        backTrack(changePath,nums,0);
        return result;
    }

    private void backTrack(List<Integer> changePath, int[] nums,int start){
        result.add(new ArrayList<>(changePath));

        for(int i = start; i < nums.length; i++){
            changePath.add(nums[i]);
            backTrack(changePath,nums,i+1);
            changePath.remove(changePath.size() - 1);
        }
    }
}
