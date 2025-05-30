import java.util.HashMap;

public class PairWithTargetSumEasy {
    //https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int rem = target - nums[i];
            if(map.containsKey(rem)) {
                res[0] = map.get(rem);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 6;
        int[] result = twoSum(arr, targetSum);
        if (result != null) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found");
        }
    }

    // algorithm explaination:
    // 1. Create a HashMap to store the elements and their indices.
    // 2. Iterate through the array using a for loop.
    // 3. For each element, calculate the complement (target - current element).
    // 4. Check if the complement exists in the HashMap.
    // 5. If it exists, return the indices of the current element and the complement.
    // 6. If it doesn't exist, add the current element and its index to the HashMap.
    // 7. Continue until a pair is found or the end of the array is reached.
    // 8. If no pair is found, return null or an empty array.
    // 9. The time complexity is O(n), where n is the number of elements in the array, as we are iterating through the array once.
    // 10. The space complexity is O(n), as we are using a HashMap to store the elements and their indices.

}