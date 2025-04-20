import java.util.ArrayList;
import java.util.List;
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

