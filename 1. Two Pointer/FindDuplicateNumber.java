public class FindDuplicateNumber {
    // https://leetcode.com/problems/find-the-duplicate-number/
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while(slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }

        return -1;
    }
    // algorithm explaination:
    // 1. Initialize two pointers, slow and fast. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
    // 2. The first loop continues until the slow and fast pointers meet, indicating a cycle in the array.
    // 3. After the first loop, reset the fast pointer to the start of the array.
    // 4. The second loop continues until the slow and fast pointers meet again, which will be the duplicate number.
    // 5. Return the duplicate number found. 
}
