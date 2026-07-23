class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> changePath = new ArrayList<>();
        backTracking(changePath,candidates,target,0);
        return result;
    }

    private void backTracking(List<Integer> changePath,int[] candidates,int target,int start){
        if(target == 0){
            result.add(new ArrayList<>(changePath));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            changePath.add(candidates[i]);
            backTracking(changePath,candidates,target - candidates[i],i+1);
            changePath.remove(changePath.size() - 1);
        }

    }
}