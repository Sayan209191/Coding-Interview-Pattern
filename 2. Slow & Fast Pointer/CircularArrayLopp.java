public class CircularArrayLopp {
    // https://leetcode.com/problems/circular-array-loop/
    public boolean circularArrayLoop(int[] nums) {
        int[] color = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++) {
            if(color[i] == 0 && dfs(nums, color, i)) return true;
        }
        return false;
    }
    private boolean dfs(int[] nums, int[] color, int start) {
        //return true if find cycle
        if(color[start] == 2) return false;
        color[start] = 1;
        int next = start + nums[start];
        next = next % nums.length + nums.length;
        next %= nums.length;
        if(next == start || nums[next] * nums[start] < 0) {
            color[start] = 2;
            return false;
        }
        if(color[next] == 1) {
            color[start] = 2;
            return true;
        }
        if(dfs(nums, color, next)) return true;
        color[start] = 2;
        return false;
    }

    // algorithm :
    // 1. Initialize an array color to keep track of the state of each index in the nums array.
    // 2. Iterate through each index in the nums array.
    // 3. If the color of the current index is 0 (unvisited), call the dfs function to check for a cycle.
    // 4. In the dfs function, mark the current index as visited (color = 1).
    // 5. Calculate the next index based on the value at the current index and the length of the nums array.
    // 6. If the next index is the same as the current index or if the values at the current and next indices have different signs, mark the current index as unvisited (color = 2) and return false.
    // 7. If the color of the next index is 1 (visited), it means a cycle is found, so return true.
    // 8. Recursively call the dfs function for the next index.
    // 9. If no cycle is found, mark the current index as unvisited (color = 2) and return false.
    // 10. If a cycle is found in any of the iterations, return true.
    // 11. If no cycle is found after checking all indices, return false.


    // Using Floyd's Tortoise and Hare algorithm
    public boolean circularArrayLoop2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int slow, fast;
            slow = fast = i;
            boolean isForward = nums[i] > 0;
            
            while(true){
                slow = getNextIndex(nums, slow, isForward);
                if(slow == -1)
                    break;
                
                fast = getNextIndex(nums, fast, isForward);
                if(fast == -1)
                    break;
                
                fast = getNextIndex(nums, fast, isForward);
                if(fast == -1)
                    break;
                
                if(slow == fast)
                    return true;
            }
        }
        return false;
    }
    
    public int getNextIndex(int[] nums, int index, boolean curDirection){
        
        boolean direction = nums[index] >= 0;
        if(direction != curDirection) return -1; // Shold be either forward/backward direction.
        
        int nextIndex = (index + nums[index]) % nums.length;
        if(nextIndex < 0) nextIndex += nums.length;
        
        if(nextIndex == index) return -1; // to ignore case like [-1], [3,1,1] that have 1 element loop
        
        return nextIndex;
    }
    // algorithm :
    // 1. Iterate through each index in the nums array.
    // 2. For each index, initialize two pointers, slow and fast, both pointing to the current index.
    // 3. Determine the direction of movement based on the value at the current index (forward or backward).
    // 4. Use a while loop to move the slow pointer one step and the fast pointer two steps at a time.
    // 5. If the slow pointer meets the fast pointer, a cycle is found, so return true.
    // 6. If the next index is out of bounds or the direction of movement changes, break the loop.
    // 7. If no cycle is found after checking all indices, return false.
    // 8. The getNextIndex function calculates the next index based on the current index and the value at that index.
    // 9. It also checks if the next index is valid and if the direction of movement is consistent.
    // 10. If the next index is the same as the current index, return -1 to indicate no valid next index.
    // 11. The function returns the next index if valid, or -1 if not.
    // 12. The main function returns true if a cycle is found, and false otherwise.
    // 13. The algorithm uses Floyd's Tortoise and Hare technique to detect cycles in the array.
    // 14. The time complexity is O(n) and the space complexity is O(1).
}
