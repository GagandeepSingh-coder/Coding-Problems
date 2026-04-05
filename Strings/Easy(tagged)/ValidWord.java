/*Leetcode Link               : https://leetcode.com/problems/valid-word
Leetcode Difficulty           : Easy
Leetcode Number               : 3136
*/
// Time Complexity : O(n) where n is the length of the input string
// Space Complexity : O(1) as we are using a constant amount of space
public class ValidWord {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                return false;
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        return hasVowel && hasConsonant;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////
/*********************** Alternate Solution using Regular Expressions **************************/
// Time Complexity : O(n) where n is the length of the input string
// Space Complexity : O(1) as we are using a constant amount of space
import java.util.regex.Pattern;
public class ValidWord {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        String regex = "^(?=.*[aeiouAEIOU])(?=.*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ])[a-zA-Z0-9]+$";
        return Pattern.matches(regex, word);
    }
}   
// The regex checks for at least one vowel, at least one consonant, and ensures that all characters are alphanumeric.
// The regex breakdown:
// ^ - start of the string
// (?=.*[aeiouAEIOU]) - positive lookahead to ensure at least one vowel (case-insensitive)
// (?=.*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]) - positive lookahead to ensure at least one consonant (case-insensitive)
// [a-zA-Z0-9]+ - ensures that all characters are alphanumeric  
// $ - end of the string
//+ - ensures that the string has at least one character (since we already check for length < 3, this is just a formality)
// This solution is more concise and leverages the power of regular expressions to validate the string in a single line.
/*..........................Python Code........................................................................ */
// Python solution without regex:
class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3:
            return False
        has_vowel = any(c in 'aeiouAEIOU' for c in word)
        has_consonant = any(c in 'bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ' for c in word)
        return has_vowel and has_consonant and all(c.isalnum() for c in word)
// Time Complexity : O(n) where n is the length of the input string
// Space Complexity : O(1) as we are using a constant amount of space
