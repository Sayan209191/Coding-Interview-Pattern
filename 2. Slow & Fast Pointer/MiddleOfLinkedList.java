public class MiddleOfLinkedList {
    // https://leetcode.com/problems/middle-of-the-linked-list/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // algorithm :
    // 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list.
    // 2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
    // 3. When the fast pointer reaches the end of the list (null), the slow pointer will be at the middle node.
    // 4. If the list has an even number of nodes, the slow pointer will point to the second middle node.
    // 5. Return the slow pointer as the middle node.

}
