public class DutchNationFlagAlgoritm {
    public void sortColors(int[] nums) {
        int low=0, high = nums.length-1;
        int mid = 0;
        while(mid <= high) {
            if(nums[mid] == 0) { // swap low with mid and increment low and mid
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 2) { // swap high with mid and decrement high
                swap(nums, mid, high);
                high--;

            } else { // mid -> 1 , just increment mid
                mid++;
            }
        }
    }
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // algorithm explanation:
    // Create a low pointer at the beginning of the array and a high pointer at the end of the array.
    // Create a mid pointer that starts at the beginning of the array and iterates through each element.
    // If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
    // If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
    // If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.
}
