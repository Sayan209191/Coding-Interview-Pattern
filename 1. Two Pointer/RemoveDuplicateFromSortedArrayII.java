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
}
