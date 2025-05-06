public class RemoveDuplicateFromSortedArrayII {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) { // at most twice 
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArrayII obj = new RemoveDuplicateFromSortedArrayII();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int length = obj.removeDuplicates(nums);
        System.out.println("Length of array after removing duplicates: " + length);
        System.out.print("Modified array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    // Time complexity: O(n), where n is the length of the input array.
    // Space complexity: O(1), as we are modifying the input array in place without using any extra space.

    // algorithm explaination:
    // 1. Check if the length of the array is less than or equal to 2. If so, return the length as no duplicates need to be removed.
    // 2. Initialize an index variable to 2, which will be used to track the position of the next unique element.
    // 3. Iterate through the array starting from the third element (index 2).
    // 4. For each element, check if it is different from the element at index - 2 (the last unique element). If it is, assign it to the current index and increment the index.
    // 5. After the loop, return the index, which represents the length of the modified array with at most two duplicates.
    // 6. The modified array will have the first 'index' elements as the unique elements with at most two duplicates.
    // 7. Print the length of the modified array and the modified array itself.
    // 8. The time complexity is O(n) because we are iterating through the array once, and the space complexity is O(1) because we are modifying the input array in place without using any extra space.
    // 9. The algorithm is efficient and works well for large arrays as it only requires a single pass through the array and uses constant space.
    // 10. The algorithm is also easy to understand and implement, making it a good choice for solving the problem of removing duplicates from a sorted array.
    // 11. The algorithm is also robust and handles edge cases, such as arrays with fewer than 3 elements, without any issues.
    // 12. Overall, this algorithm is a simple and effective solution to the problem of removing duplicates from a sorted array while allowing at most two duplicates.
    // 13. The algorithm is also flexible and can be easily adapted to allow for different numbers of duplicates if needed, by changing the condition in the if statement.
    // 14. The algorithm is also efficient in terms of time and space complexity, making it a good choice for solving this problem.
}
