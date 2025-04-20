import java.util.*;
// time complexuty-o(nlogn+n^2)-o(n^2)
// space complexity-o(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sort the elements
        Arrays.sort(nums);
        int resultSum=nums[0]+nums[1]+nums[2];
        int minDifference=Integer.MAX_VALUE;

        // NOW FIX THE FIRST ELEMENT AND FIND OTHER TWO
        for(int i=0;i<nums.length-2;i++)
        {
        int left=i+1;
        int right=nums.length-1;
        while(left<right)
        {
            int sum=nums[i]+nums[left]+nums[right];
            if(sum==target)
            {
                return target;
            }
            if(sum<target)
            {
                left++;
            }
            else
            {
                right--;
            }
            int diffToTarget=Math.abs(sum-target);
            if(diffToTarget<minDifference)
            {
                // update result sum
                resultSum=sum;
                minDifference=diffToTarget;
            }
        }
        }
        return resultSum;
    }
}
// 2 pointers  absolute function used EXTENEDED VERSION OF 3 SUM