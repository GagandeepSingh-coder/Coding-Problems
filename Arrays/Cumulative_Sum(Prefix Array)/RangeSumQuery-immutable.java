// Leetcode 303. Range Sum Query - Immutable
// https://leetcode.com/problems/range-sum-query-immutable/
// time complexity-O(n)
// space complexity-o(n)
class NumArray {
    int[] prefixArr;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixArr = new int[n];
        prefixArr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixArr[i] = prefixArr[i - 1] + nums[i];// prefix sum logic
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return prefixArr[right];// means starting from index 0
        return prefixArr[right] - prefixArr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

// without and base case
// Apprach2
class NumArray {
    int[] prefixArr;

    public NumArray(int[] nums) {
        prefixArr = new int[nums.length + 1];
        prefixArr[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixArr[i + 1] = prefixArr[i] + nums[i];// prefix sum logic
        }
    }

    public int sumRange(int left, int right) {
        // prefix[right+1]- will contains all the elements sum from index [0.... right].
        // prefix[left]-will contains all the elements sum from index[0...left-1]
        // thus we need the range sum from index[left..right]
        return prefixArr[right + 1] - prefixArr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */