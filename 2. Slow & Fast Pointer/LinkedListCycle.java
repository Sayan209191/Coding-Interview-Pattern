public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;

            
        }
        return false;
    }
    public static void main(String[] args) {
        
    }

    // algorithm :
    // 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list.
    // 2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
    // 3. If there is a cycle, the fast pointer will eventually meet the slow pointer.
    // 4. If the fast pointer reaches the end of the list (null), there is no cycle.
    // 5. Return true if the slow and fast pointers meet, otherwise return false.
    // time complexity : O(n)
    // space complexity : O(1)
    // The algorithm uses the Floyd's Cycle Detection algorithm (Tortoise and Hare algorithm).

}
