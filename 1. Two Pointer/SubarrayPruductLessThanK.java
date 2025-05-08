public class SubarrayPruductLessThanK {
    // https://leetcode.com/problems/subarray-product-less-than-k/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, right = 0, product = 1, count = 0;
        int n = nums.length;

        while (right < n) {
            product *= nums[right];
            while (product >= k) product /= nums[left++];
            count += 1 + (right - left);
            right++;
        }

        return count;
    }

    // algorithm explanation:
    // 1. Initialize two pointers, left and right, to the start of the array.
    // 2. Initialize a variable product to 1 to keep track of the product of the current subarray.
    // 3. Initialize a variable count to 0 to store the number of valid subarrays.
    // 4. Iterate through the array using the right pointer.
    // 5. Multiply the current element nums[right] to the product.
    // 6. While the product is greater than or equal to k, divide the product by nums[left] and increment the left pointer.
    // 7. Add the number of valid subarrays ending at right to the count. The number of valid subarrays is (right - left + 1).
    // 8. Increment the right pointer to move to the next element.
    // 9. Continue this process until the right pointer reaches the end of the array.
    // 10. Finally, return the count of valid subarrays.
    // 11. The time complexity is O(n), where n is the length of the input array, as we traverse the array once.
    // 12. The space complexity is O(1), as we are using a constant amount of extra space for variables.
    
}
