import java.util.Arrays;

public class ThreeSumClosest {
    // https://leetcode.com/problems/3sum-closest/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++) {
            int j = i+1;
            int k=n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    return target;
                } else if(sum > target) {
                    k--;
                } else if(sum < target){
                    j++;
                }
                int diff = Math.abs(target - sum);
                if(diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }

    // algorithm explanation:
    // 1. Sort the input array nums in ascending order. 
    // 2. Initialize a variable closest to store the closest sum found so far.
    // 3. Initialize a variable minDiff to store the minimum difference between the target and the current sum.
    // 4. Iterate through the sorted array using a for loop with index i from 0 to n-2 (inclusive).
    // 5. For each element nums[i], initialize two pointers j and k, where j starts at i+1 and k starts at n-1 (the last index of the array).
    // 6. Use a while loop to iterate while j is less than k.
    // 7. Calculate the sum of nums[i], nums[j], and nums[k].
    // 8. If the sum equals the target, return the target as it is the closest sum.
    // 9. If the sum is greater than the target, decrement k to reduce the sum.
    // 10. If the sum is less than the target, increment j to increase the sum.
    // 11. Calculate the absolute difference between the target and the current sum.
    // 12. If the difference is less than minDiff, update minDiff and set closest to the current sum.
    // 13. Continue this process until all possible triplets are checked or j meets k.
    // 14. Finally, return the closest sum found, which is stored in the variable closest.
    // 15. The time complexity is O(n^2), where n is the length of the input array, as we use a nested loop to find triplets.
    // 16. The space complexity is O(1), as we are using a constant amount of extra space for variables.
}
