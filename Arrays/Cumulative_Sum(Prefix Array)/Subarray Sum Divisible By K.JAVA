// 974. Subarray Sums Divisible by K974. Subarray Sums Divisible by K
import java.util.*;
// Brute Force
// Time Complexity-O(n^2) and Space Complexity-O(1)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0,subarraySum=0;
        for(int i=0;i<nums.length;i++){
            subarraySum=0;
            for(int j=i;j<nums.length;j++){
                subarraySum+=nums[j];
                if(subarraySum%k==0){
                    count++;
                }
            }
        }
        return count;
    }
}

// Approch 2
// [PrefixSum+ HashMap]
// Eg test cases-
// [2,-6,3,1,2,8,2,1],k=7 --> in this we get to know why we donot store negative remainders in map
 /*
      Concept behind this method
    K
    
    a  b  c  d   e   f   g    h
    -----s1-------
    -----------------s2--------
    
    Lets say, s1 and  s2 --> are the sub array sum
    s1%k = x
    s2%k = x
    s1 = k*n + x
    s2 = k*m + x
    subarraySum = s2-s1
                = k*(m-n)
                Which proves that the subarray is divisible by k



  */
  // Time Complexity-O(n) and space complexuty-O(1)
  class Solution {
    /**
    This class will provide the optimised version of finding subarray sum divisible by k.[PrefixSum+HashMap]
     */
    public int subarraysDivByK(int[] nums, int k) {
        int result=0,subarraySum=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);// in this key-remainder,value is freq of that remainder when divided by k
        // remainder 0 is added explicitly-- as if there  is an empty subbary whose sum is 0 which is divisible by all k.
        // helpful when the subarray starts with index 0 and the elements are divisible by k.
        for(int i=0;i<nums.length;i++){
            subarraySum+=nums[i];
            int rem=(subarraySum%k<0)?subarraySum%k+k:subarraySum%k;
            if(map.containsKey(rem)){
                result+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return result;
    }
}