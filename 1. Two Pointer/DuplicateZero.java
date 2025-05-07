public class DuplicateZero {
    // https://leetcode.com/problems/duplicate-zeros/
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeroCnt = 0;

        for(int it : arr) {
            if(it == 0) zeroCnt++;
        }

        int i=n-1, j = i+zeroCnt;

        while(i >= 0) {

            if(j < n) {
                arr[j] = arr[i];
            }
            if(arr[i] == 0) {
                j--;
                if(j < n) {
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }

    }

    // algorithm explanation:
    // 1. Count the number of zeros in the array.   
    // 2. Initialize two pointers, i and j. i points to the last element of the original array, and j points to the last element of the modified array (after duplicating zeros).
    // 3. Traverse the array from the end to the beginning using the i pointer.
    // 4. For each element, check if it is a zero. If it is, decrement the j pointer and set the value at arr[j] to zero (duplicate the zero).
    // 5. If the current element is not a zero, set arr[j] to the value of arr[i].

    // 6. Decrement both i and j pointers after each iteration.
    // 7. Continue this process until the i pointer reaches the beginning of the array.
    // 8. The time complexity is O(n), where n is the length of the array, as we traverse the array once.
    // 9. The space complexity is O(1), as we are modifying the array in place without using any extra space.
}
