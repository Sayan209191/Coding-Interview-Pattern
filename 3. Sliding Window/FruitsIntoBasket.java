import java.util.*;
public class FruitsIntoBasket {
    // https://leetcode.com/problems/fruit-into-baskets
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int st=0;int end=0;
        int res = 0;
        for (end = 0; end < fruits.length; end++) {
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);
            while(basket.size() > 2) {
                basket.put(fruits[st], basket.get(fruits[st]) - 1);
                basket.remove(fruits[st], 0);
                st++;
            }
            res = Math.max(res, end - st + 1);
        }
        return res;
    }

    // algorithm explanation:
    // 1. Initialize a HashMap to keep track of the count of each type of fruit in the baskets.
    // 2. Use two pointers (st and end) to represent the current window of fruits.
    // 3. Iterate through the array using the end pointer to expand the window.
    // 4. Add the current fruit to the basket and update its count in the HashMap.
    // 5. If the size of the basket exceeds 2, move the start pointer (st) to the right until the size is reduced to 2.
    // 6. Update the maximum length of the window (res) if the current window size is larger than the previous maximum.
    // 7. Repeat steps 3-6 until the end pointer reaches the end of the array.
    // 8. Return the maximum length of the window found.


}
