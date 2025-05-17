public class HappyNumber {
    // https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        
        int slow = n, fast = getDigitSum(n);
        while(fast != 1 && fast != slow) {
            slow = getDigitSum(slow);
            fast = getDigitSum(getDigitSum(fast));
        }
        return fast == 1;
    }
    
//Finding the square of the digits of a number

    public int getDigitSum(int num) {
        
        int ans = 0;
        
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        
        return ans;
    }

    // algotitm : 
    // 1. Initialize two pointers, slow and fast, both pointing to the number n.
    // 2. Move the slow pointer one step at a time (calculate the sum of squares of digits).
    // 3. Move the fast pointer two steps at a time (calculate the sum of squares of digits twice).
    // 4. If the fast pointer reaches 1, return true (the number is happy).
    // 5. If the fast pointer meets the slow pointer, return false (the number is not happy).
    
}
