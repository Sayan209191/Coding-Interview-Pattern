public class ReorderList {
    // https://leetcode.com/problems/reorder-list/

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        slow.next = null;

        ListNode first = head;
        ListNode second = rev;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // algorithm :
    // 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list.
    // 2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
    // 3. When the fast pointer reaches the end of the list (null), the slow pointer will be at the middle node.
    // 4. Reverse the second half of the linked list starting from the slow pointer.
    // 5. Set the next pointer of the slow node to null to split the list into two halves.
    // 6. Initialize two pointers, first and second, to the head of the first half and the head of the reversed second half, respectively.
    // 7. Iterate through both halves, alternating between the first and second nodes.
    // 8. Set the next pointer of the first node to the second node, and the next pointer of the second node to the next node in the first half.
    // 9. Continue this process until the second half is fully merged into the first half.
    // 10. The linked list is now reordered in the desired format.
    // 11. Return the head of the reordered linked list.
}
