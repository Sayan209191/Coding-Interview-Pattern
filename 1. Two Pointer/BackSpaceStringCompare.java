import java.util.Stack;

public class BackSpaceStringCompare {
    // https://leetcode.com/problems/backspace-string-compare/
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if( s.charAt(i) == '#') {
                if(!st1.isEmpty()) st1.pop();
            } else {
                st1.push(s.charAt(i));
            }
        }
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == '#') {
                if(!st2.isEmpty()) st2.pop();
            } else {
                st2.push(t.charAt(i));
            }
        }
        if(st1.size() != st2.size()) return false;
        while(!st1.isEmpty() && !st2.isEmpty()) {
            if(st1.pop() != st2.pop()) return false;
        }
        return true;
    }
    // algorithm explanation:
    // 1. Initialize two stacks, st1 and st2, to store characters from strings s and t respectively.
    // 2. Iterate through each character in string s:
    //    a. If the character is '#', pop the top character from st1 if it's not empty.
    //    b. If the character is not '#', push it onto st1.
    // 3. Repeat the same process for string t, using st2.
    // 4. If the sizes of st1 and st2 are not equal, return false.
    // 5. While both stacks are not empty, pop the top character from each stack and compare them.
    //    a. If the characters are not equal, return false.
    // 6. If all characters match, return true.
    // 7. The time complexity is O(n + m), where n and m are the lengths of strings s and t respectively.
    // 8. The space complexity is O(n + m) for the two stacks.\\\

    // Optimization:
    public boolean backspaceCompareOptimized(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidCharIndex(s, i);
            j = getNextValidCharIndex(t, j);

            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) return false;
            } else {
                // One string is exhausted before the other
                if (i >= 0 || j >= 0) return false;
            }

            i--; j--;
        }

        return true;
    }

    private int getNextValidCharIndex(String str, int index) {
        int backspace = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspace++;
            } else {
                if (backspace > 0) {
                    backspace--;
                } else {
                    break;
                }
            }
            index--;
        }
        return index;
    }

    // algorithm explanation:
    // 1. Initialize two pointers, i and j, to the end of strings s and t respectively.
    // 2. While either pointer is valid (i >= 0 or j >= 0):
    //    a. Get the next valid character index for both strings using the helper function getNextValidCharIndex.
    //    b. If both indices are valid, compare the characters at those indices.
    //       If they are not equal, return false.
    //    c. If one string is exhausted before the other, return false.
    // 3. If all characters match, return true.
    // 4. The time complexity is O(n + m), where n and m are the lengths of strings s and t respectively.
    // 5. The space complexity is O(1) as we are using only a constant amount of extra space for indices.
    // 6. The helper function getNextValidCharIndex has a time complexity of O(n) in the worst case, but it is called at most once for each character in the strings.
}
