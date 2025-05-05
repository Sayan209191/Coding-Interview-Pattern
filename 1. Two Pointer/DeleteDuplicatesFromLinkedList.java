// LeetCode 82. Remove Duplicates from Sorted List II
public class DeleteDuplicatesFromLinkedList {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        
        ListNode fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }
            
        }
        return dummy.next;
    }
}
