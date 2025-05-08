import java.util.*;

public class ThreeSum {
    // https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++) {
            if(i >0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) k--;
                else if(sum < 0) j++;
                else{
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    res.add(list);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--; 
                }
            }
            
        }
        return res;
    }
    // algorithm explanation:
    // 1. Sort the input array nums in ascending order.
    // 2. Initialize an empty list res to store the unique triplets that sum to zero.
    // 3. Iterate through the sorted array using a for loop with index i from 0 to n-2 (inclusive).
    // 4. For each element nums[i], check if it is the same as the previous element (nums[i-1]). If it is, skip this iteration to avoid duplicates.
    // 5. Initialize two pointers, j and k, where j starts at i+1 and k starts at n-1 (the last index of the array).
    // 6. Use a while loop to iterate while j is less than k.
    // 7. Calculate the sum of nums[i], nums[j], and nums[k].
    // 8. If the sum is greater than zero, decrement k to reduce the sum.
    // 9. If the sum is less than zero, increment j to increase the sum.
    // 10. If the sum equals zero, add the triplet [nums[i], nums[j], nums[k]] to the result list res.
    // 11. Move both pointers inward (increment j and decrement k) to find other potential triplets.
    // 12. Skip duplicates for j and k by checking if nums[j] is equal to nums[j-1] and nums[k] is equal to nums[k+1].
    // 13. Continue this process until all unique triplets are found or j meets k.
    // 14. Finally, return the result list res containing all unique triplets that sum to zero.
    // 15. The time complexity is O(n^2), where n is the length of the input array, as we use a nested loop to find triplets.
}
