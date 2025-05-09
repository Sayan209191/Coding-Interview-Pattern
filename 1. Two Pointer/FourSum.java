import java.util.*;

public class FourSum {
    // https://leetcode.com/problems/4sum/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) { // Ignoring duplicate
                continue;
            }
            for(int j=i+1; j<nums.length; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) { // Ignoring duplicates
                    continue;
                }


                int k = j+1;
                int l = nums.length-1;
                while(k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]){ // Ignoring duplicates
                            k++;
                        }
                        while(k<l && nums[l]==nums[l+1]) { // Ignoring duplicates
                            l--;
                        }
                    } else if(sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    // algorithm explanation:
    // 1. Sort the input array nums.        
    // 2. Initialize an empty list ans to store the result.
    // 3. Iterate through the array with two nested loops, using indices i and j.
    // 4. For each pair of indices (i, j), initialize two pointers k and l.
    // 5. While k is less than l, calculate the sum of nums[i], nums[j], nums[k], and nums[l].
    // 6. If the sum is equal to the target, add the quadruplet to the result list ans.
    // 7. Move the pointers k and l to skip duplicates and continue searching for other quadruplets.
    // 8. If the sum is less than the target, increment k to increase the sum.
    // 9. If the sum is greater than the target, decrement l to decrease the sum.
    // 10. Continue this process until all quadruplets are found.
    // 11. Return the result list ans.
}
