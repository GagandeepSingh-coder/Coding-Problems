
// Brute Force
// Find all possible subarrays
// find the running sum of each and check if it is equl to k then increase the count
import java.util.HashMap;
import java.util.Map;

class SubarraySumEqualsK {
    /**
     * this class provide the brute force way to find the subarray sum habing sum
     * equal to k
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
// optimised approach [Prefix Sum + HashMap]
// Time Complexity-O(n)
// Space Complexity-o(n)

// imp test cases to understand base case-
// [1,-1,0]--> why we have put (0,1)in map

public class SubarraySumEqualsK2 {
    /**
     * This class is used to give the count of all subarrays having sum k using
     * prefixSum
     */
    public int subarraySum(int[] nums, int k) {

        int count = 0, cumulativeSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // it means a prefixSum with 0 is also an subarray i.e an empty subarray so we
        // will count it as 1
        map.put(0, 1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            if (map.containsKey(cumulativeSum - k)) {
                count += map.get(cumulativeSum - k);
            }
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        return count;
    }
}
