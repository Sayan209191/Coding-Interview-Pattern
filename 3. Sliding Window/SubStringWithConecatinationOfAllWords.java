import java.util.*;
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

public class SubStringWithConecatinationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> r = new ArrayList<>();
        int sLen = s.length();
        int num = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < sLen - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                r.add(i);
            }
        }
        return r;
    }
    
    /**
     * */
    private boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }

    // Algorithm Explanation:
    // 1. Initialize a map to count the occurrences of each word in the input array.
    // 2. Create a list to store the starting indices of valid substrings.
    // 3. Calculate the length of the input string, the number of words, and the length of each word.   
    // 4. Iterate through the input string, checking each substring of length equal to the total length of all words.
    // 5. For each substring, check if it can be formed by concatenating the words in the input array using the isConcat method.
    // 6. The isConcat method checks if the substring can be formed by the words in the input array by counting the occurrences of each word in the substring and comparing it with the original counts.
    // 7. If a valid substring is found, add its starting index to the result list.
    // Time Complexity: O(n * m), where n is the length of the input string and m is the total length of all words.
    // Space Complexity: O(k), where k is the number of unique words in the input array.
}
