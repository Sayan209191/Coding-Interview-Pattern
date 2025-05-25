import java.util.*;
public class FindAllAnagramsInString {
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()) return list;
        int[] cnts = new int[26];
        int[] cntp = new int[26];

        for(int i=0; i<p.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
            cntp[p.charAt(i) - 'a']++;
        }
        // Sliding window
        int i=0;
        for(; i<(s.length() - p.length()); i++) {
            if(isValidAnagrams(cnts, cntp)) list.add(i);
            cnts[s.charAt(i) - 'a']--;
            cnts[s.charAt(i + p.length()) - 'a']++;
        }
        if(isValidAnagrams(cnts, cntp)) list.add(i);
        return list;

    }
    private boolean isValidAnagrams(int cnt1[], int cnt2[]) {
        for(int i=0; i<26; i++) {
            if(cnt1[i] != cnt2[i] ) return false;
        }
        return true;
    }
    // Algorithm Explanation:
    // 1. Initialize a list to store the starting indices of anagrams.
    // 2. Check if the length of s is less than p. If so, return the empty list.
    // 3. Create two frequency arrays, cnts and cntp, to count the occurrences of each character in the current window of s and in p.
    // 4. Populate the frequency arrays for the first window of s and for p.
    // 5. Slide the window over s:
    //    a. For each position i, check if the current window's frequency matches that of p using the isValidAnagrams method.
    //    b. If they match, add the starting index i to the list.
    //    c. Update the frequency array for the current window by decrementing the count of the character that is sliding out and incrementing the count of the character that is sliding in.
    // 6. Return the list of starting indices of anagrams found in s.
    // Time Complexity: O(n + m), where n is the length of s and m is the length of p.
    // Space Complexity: O(1), since the frequency arrays have a fixed size of 26 (for lowercase English letters).

    
}
