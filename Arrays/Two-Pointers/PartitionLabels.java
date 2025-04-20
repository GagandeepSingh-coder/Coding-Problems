import java.util.ArrayList;
import java.util.List;
// Approach 1
//Let n be the size of the input string s and k be the number of unique characters in s.
// time complexity-O(2n)=O(n)
// space complexity-o(k)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence=new int[26];
        for(int i=0;i<s.length();i++){
            lastOccurrence[s.charAt(i)-'a']=i;
        }
        int partitionEnd=0,partitionStart=0;
        List<Integer>partitionSizes=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            partitionEnd=Math.max(partitionEnd,lastOccurrence[s.charAt(i)-'a']);
            // end of current partition
            if(i==partitionEnd){
                partitionSizes.add(i-partitionStart+1);
                partitionStart=i+1;
            }
        }
        return partitionSizes;
    }
}
// Approach 2
// Merge Intervals Approach

//Let n be the size of the input string s and k be the number of unique characters in s.

// Time complexity: O(n)
// space complexity-o(k)
//The algorithm uses two fixed-size arrays, firstOccurrence and lastOccurrence, of size 26 to store each character's interval boundaries. In the general case, the space required is proportional to the number of distinct letters in s. Thus, for an arbitrary alphabet (a set of distinct values) of size k, the space complexity of the algorithm is O(k).
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>partitionSizes=new ArrayList<>();
        int[] lastOccurrence=new int[26];
        int[] firstOccurrence=new int[26];
        Arrays.fill(firstOccurrence,-1);
        int partitionStart=0,partitionEnd=0;
        // store the last occurence index of each character
        for(int i=0;i<s.length();i++){
            lastOccurrence[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<s.length();i++)
        {
            // Store the first occurrence index of each character(if not set)
            if(firstOccurrence[s.charAt(i)-'a']==-1){
                firstOccurrence[s.charAt(i)-'a']=i;
            }
            // if we find a new partition start
            if(partitionEnd<firstOccurrence[s.charAt(i)-'a']){
                partitionSizes.add(partitionEnd-partitionStart+1);
                partitionStart=i;
                partitionEnd=i;
            }
            // update the partion end boundary
            partitionEnd=Math.max(partitionEnd,lastOccurrence[s.charAt(i)-'a']);
        }
        // add the last partition if it exists
        if(partitionEnd-partitionStart+1>0){
            partitionSizes.add(partitionEnd-partitionStart+1);
        }
        return partitionSizes;
    }
}


