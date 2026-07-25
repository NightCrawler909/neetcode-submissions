class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] output = new int[nums.length];


        int prefixMul = 1;
        for(int i = 0; i < nums.length ; i++){
            prefix[i] = prefixMul;
            prefixMul = nums[i] * prefixMul;
        }

        int postMul = 1;
        for(int i = nums.length - 1; i >= 0 ; i--){
            postfix[i] = postMul;
            postMul = nums[i] * postMul;
        }

        for(int i = 0 ; i < nums.length ; i++){
            output[i] = prefix[i] * postfix[i];
        }

        return output;
    }
}  
