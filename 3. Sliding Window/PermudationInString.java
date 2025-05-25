public class PermudationInString {
    // https://leetcode.com/problems/permutation-in-string/
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count the frequency of characters in s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Count, s2Count)) return true;
            // Update the window
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check the last window
        return matches(s1Count, s2Count);
    }

    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }

    // Algorithm Explanation:
    // 1. Check if the length of s1 is greater than s2. If so, return false.
    // 2. Create two frequency arrays, s1Count and s2Count, to count the occurrences of each character in s1 and the first window of s2.
    // 3. Iterate through the first s1.length() characters of s1 and s2 to populate the frequency arrays.
    // 4. Slide the window over s2 by moving one character at a time:
    //    a. Check if the current window matches the frequency of characters in s1 using the matches() method.
    //    b. If it matches, return true.
    //    c. Update the frequency array for the current window by decrementing the count of the character that is sliding out and incrementing the count of the character that is sliding in.
    // 5. After sliding through all possible windows, check the last window.
    // 6. If no matching window is found, return false.

}
