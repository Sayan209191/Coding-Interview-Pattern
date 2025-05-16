public class LinkedListCycleII {
    // https://leetcode.com/problems/linked-list-cycle-ii/description/

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasCycle = true;
                break; 
            }
        }
        if(!hasCycle) return null; 
        fast = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // algorithm :
    // 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list.
    // 2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
    // 3. If there is a cycle, the fast pointer will eventually meet the slow pointer.
    // 4. If the fast pointer reaches the end of the list (null), there is no cycle.
    // 5. If a cycle is detected, move one pointer to the head of the list and keep the other at the meeting point.
    // 6. Move both pointers one step at a time until they meet again. The meeting point is the start of the cycle.
    // time complexity : O(n)
    // space complexity : O(1)
    // The algorithm uses the Floyd's Cycle Detection algorithm (Tortoise and Hare algorithm).
}
