public class MaximumSubarray{
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    // algorithm explanation:
    // 1. Initialize maxSum to the smallest possible integer value and currSum to 0.
    // 2. Iterate through each element in the array.
    // 3. Add the current element to currSum.
    // 4. Update maxSum if currSum is greater than maxSum.
    // 5. If currSum becomes negative, reset it to 0.
    // 6. Return maxSum after iterating through the entire array.
    // Time complexity: O(n), where n is the number of elements in the array.
}

