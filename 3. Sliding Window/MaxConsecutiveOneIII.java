public class MaxConsecutiveOneIII {
    // https://leetcode.com/problems/max-consecutive-ones-iii/description/
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int st=0, end = 0;
        int zeroCount = 0;
        int maxLen = 0;
        while(end < n) {
            if(nums[end] == 0) zeroCount++;
            if(zeroCount > k) {
                while(zeroCount > k) {
                    if(nums[st] == 0) zeroCount--;
                    st++;
                }
            }
            maxLen = Math.max(maxLen, end-st+1);
            end++;
        }
        return maxLen;
    }

    // algorithm explanation:
    // 1. Initialize two pointers, `st` and `end`, to represent the start and end of the current window.
    // 2. Initialize a variable `zeroCount` to keep track of the number of zeros in the current window.
    // 3. Initialize a variable `maxLen` to store the maximum length of the subarray found.
    // 4. Iterate through the array using the `end` pointer to expand the window.
    // 5. If the current element is zero, increment the `zeroCount`.
    // 6. If `zeroCount` exceeds `k`, move the `st` pointer to the right until `zeroCount` is less than or equal to `k`.
    // 7. Update `maxLen` with the maximum of its current value and the length of the current window (`end - st + 1`).
    // 8. Increment the `end` pointer to expand the window.
    // 9. Repeat steps 4-8 until the `end` pointer reaches the end of the array.
    // 10. Return the maximum length of the subarray found.
    // 11. If no valid subarray is found, return 0.
    // Time Complexity: O(n), where n is the length of the input array.
}
