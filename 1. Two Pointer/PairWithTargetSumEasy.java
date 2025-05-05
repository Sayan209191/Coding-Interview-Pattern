import java.util.HashMap;

public class PairWithTargetSumEasy {
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

}