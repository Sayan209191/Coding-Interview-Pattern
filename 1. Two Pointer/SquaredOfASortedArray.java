public class SquaredOfASortedArray {
    // https://leetcode.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        int i=0, j=n-1, idx = n-1;

        while( i <= j) {
            if(Math.abs(nums[i]) >= Math.abs(nums[j])) {
                res[idx--] = nums[i] * nums[i];
                i++;
            } else {
                res[idx--] = nums[j] * nums[j];
                j--;
            }
        } 
        return res;
        
    }
    // algorithm explanation:
        // 1. Initialize two pointers, i and j, to the start and end of the array, respectively.
    // 2. Create a result array res of the same length as the input array nums to store the squared values in sorted order.
    // 3. Initialize an index variable idx to the last index of the result array (n-1).
    // 4. Use a while loop to iterate until the two pointers meet (i <= j).
    // 5. Inside the loop, compare the absolute values of the elements at the two pointers (nums[i] and nums[j]).
    // 6. If the absolute value of nums[i] is greater than or equal to the absolute value of nums[j], square nums[i] and store it in res[idx].
    // 7. Increment the i pointer and decrement the idx pointer.
    // 8. If the absolute value of nums[j] is greater than nums[i], square nums[j] and store it in res[idx].
    // 9. Decrement the j pointer and decrement the idx pointer.
    // 10. Continue this process until the two pointers meet.
    // 11. Finally, return the result array res, which contains the squared values in sorted order.
    // 12. The time complexity is O(n), where n is the length of the input array, as we traverse the array once.
    // 13. The space complexity is O(n), as we create a new result array of the same length as the input array.

}
