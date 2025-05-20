public class MinimumSizeSubarraySum {
    // https://leetcode.com/problems/minimum-size-subarray-sum/description/
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) prefix[i] = prefix[i-1] + nums[i];

        int st = 0, end = 0;
        int minLen = Integer.MAX_VALUE;

        while (st <= end && end < n) {
            int currentSum = prefix[end] - (st > 0 ? prefix[st - 1] : 0);
            
            if (currentSum >= target) {
                minLen = Math.min(minLen, end - st + 1);
                st++;
            } else {
                end++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // algorithm explanation:
    // 1. Initialize a prefix sum array to store the cumulative sums of the input array.
    // 2. Use two pointers (st and end) to represent the current subarray.
    // 3. Iterate through the array using the end pointer to expand the subarray.
    // 4. Calculate the current sum of the subarray using the prefix sum array.
    // 5. If the current sum is greater than or equal to the target, update the minimum length and move the start pointer (st) to the right.
    // 6. If the current sum is less than the target, move the end pointer (end) to the right to expand the subarray.
    // 7. Repeat steps 4-6 until the end pointer reaches the end of the array.
    // 8. If no valid subarray is found, return 0; otherwise, return the minimum length found.
    // Time complexity: O(n), where n is the number of elements in the array.
    // Space complexity: O(n) for the prefix sum array.
    
}
