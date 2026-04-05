/*
Leetcode Link                     : https://leetcode.com/problems/valid-anagram/
Leetcode Difficulty               : Easy
Leetcode Number                   : 242
*/

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true;
    }
}
// second solution using sorting
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
// Time Complexity : O(n log n) due to sorting
// Space Complexity : O(1) if we ignore the space used for sorting, otherwise
// O(n) due to the character arrays



// Another solution using  hashmap to count characters:
import java.util.HashMap;
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.get(c) - 1);
        }
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
// Time Complexity : O(n) where n is the length of the input strings
// Space Complexity : O(n) due to the hashmap storing character counts

// Optimal solution using a fixed-size array to count characters (assuming input consists of lowercase letters only):
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
// Time Complexity : O(n) where n is the length of the input strings
// Space Complexity : O(1) as we are using a fixed-size array of 26 characters

/*
 * ..........................Python
 * Code........................................................................
 */
class Solution:
def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_count = [0] * 26
        for c in s:
            char_count[ord(c) - ord('a')] += 1
        for c in t:
            char_count[ord(c) - ord('a')] -= 1
            if char_count[ord(c) - ord('a')] < 0:
                return False
        return True
// Time Complexity : O(n) where n is the length of the input strings
// Space Complexity : O(1) as we are using a fixed-size array of 26
// Abovwe solution assumes that the input strings consist of lowercase letters only. If the input can contain uppercase letters or other characters, we would need to adjust the counting mechanism accordingly, such as using a dictionary or a larger array to accommodate all possible characters.

// Alternate Python solution using sorting:
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)   
// Time Complexity : O(n log n) due to sorting
// Space Complexity : O(1) if we ignore the space used for sorting, otherwise O(n) due to the sorted lists

// Alternate Python solution using collections.Counter:
from collections
import Counter

class Solution:
def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)
// Time Complexity : O(n) where n is the length of the input strings
// Space Complexity : O(n) due to the Counter objects storing character counts

// The Counter solution is concise and leverages Python's built-in functionality to count characters efficiently. It creates a frequency count of characters for both strings and compares them directly.

// Another Python solution using a dictionary to count characters:
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_count = {}
        for c in s:
            char_count[c] = char_count.get(c, 0) + 1
        for c in t:
            if c not in char_count or char_count[c] == 0:
                return False
            char_count[c] -= 1
        return True 
// Time Complexity : O(n) where n is the length of the input strings
// Space Complexity : O(n) due to the dictionary storing character counts

// Another Python solution using a single dictionary to count characters:
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_count = {}
        for c1, c2 in zip(s, t):
            char_count[c1] = char_count.get(c1, 0) + 1
            char_count[c2] = char_count.get(c2, 0) - 1
        return all(count == 0 for count in char_count.values())
// Time Complexity : O(n) where n is the length of the input strings
// Space Complexity : O(n) due to the dictionary storing character counts
// This solution iterates through both strings simultaneously, updating the character counts in a single dictionary. It then checks if all counts are zero, which would indicate that the strings are anagrams of each other.

// This solution is efficient and concise, as it avoids the need for two separate loops to count characters in each string.

// An
