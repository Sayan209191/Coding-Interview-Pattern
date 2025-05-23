import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch)+1);
            }
            maxLen = Math.max(maxLen, right - left+1);
            map.put(ch, right);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    // algorithm explanation:
    // 1. Initialize a HashMap to keep track of the last index of each character.
    // 2. Initialize variables maxLen to store the maximum length of the substring and left to represent the start of the current window.
    // 3. Iterate through the string using the right pointer to expand the window.
    // 4. If the current character is already in the HashMap, update the left pointer to the right of the last occurrence of that character.
    // 5. Update the maximum length of the substring if the current window size is larger than the previous maximum.
    // 6. Add the current character and its index to the HashMap.
    // 7. Repeat steps 3-6 until the right pointer reaches the end of the string.
    // 8. Return the maximum length of the substring found.
    // 9. If no valid substring is found, return 0.
}
