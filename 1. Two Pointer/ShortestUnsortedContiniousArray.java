import java.util.*;

public class ShortestUnsortedContiniousArray {
    public int findUnsortedSubarray(int[] nums) {
        // use sorting
        Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Integer[] copy = Arrays.copyOf(numsObj, numsObj.length);
        Arrays.sort(copy);
        int st=-1, end=-1;

        int i=0;

        while(i < nums.length) {
            if(nums[i] != copy[i]) {
                if(st == -1) st = i;
                else end = i;
            } 
            i++;
        }
        return st == -1 ? 0 : end-st+1;

    }

    // algorithm explanation:
    // 1. Create a copy of the input array and sort it. 
    // 2. Initialize two variables, st and end, to -1. These will be used to track the start and end indices of the unsorted subarray.
    // 3. Iterate through the original array and the sorted array simultaneously.
    // 4. If the elements at the current index in both arrays are not equal, check if st is -1.
    //    a. If st is -1, set it to the current index.
    //    b. If st is not -1, set end to the current index.
    // 5. Continue iterating until the end of the array.
    // 6. If st is still -1, it means the array is already sorted, so return 0.
    // 7. Otherwise, return the length of the unsorted subarray, which is end - st + 1.

    public static int findUnsortedSubarrayOptimized(int[] nums) {
        int n = nums.length, st = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=1; i<n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) st = n-1-i; 
        }
        return end - st + 1;
    }

    // algorithm explanation:
    // 1. Initialize variables n, st, end, min, and max.
    // 2. Set n to the length of the input array nums.
    // 3. Initialize st to -1 and end to -2. These will be used to track the start and end indices of the unsorted subarray.
    // 4. Initialize min to the last element of the array and max to the first element of the array.
    // 5. Iterate through the array from the second element to the last element:
    //    a. Update max to be the maximum of max and the current element.
    //    b. Update min to be the minimum of min and the last element of the array.
    //    c. If the current element is less than max, update end to be the current index.
    //    d. If the last element of the array is greater than min, update st to be the index of the last element.
    // 6. After the loop, return the length of the unsorted subarray, which is end - st + 1.
    // 7. The time complexity is O(n), where n is the length of the input array.
    // 8. The space complexity is O(1), as we are using only a constant amount of extra space.

    public static void main(String[] args) {
        int nums[] = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarrayOptimized(nums));
    }
}
