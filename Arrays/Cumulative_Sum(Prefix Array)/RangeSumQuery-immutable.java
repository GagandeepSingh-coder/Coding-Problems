Leetcode 303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/
// time complexity-O(n)
// space complexity-o(n)
class NumArray {
    int[] prefixArr;
    public NumArray(int[] nums) {
        int n=nums.length;
        prefixArr=new int[n];
        prefixArr[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixArr[i]=prefixArr[i-1]+nums[i];// prefix sum logic
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return prefixArr[right];// means starting from index 0
        return prefixArr[right]-prefixArr[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */