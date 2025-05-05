public class RemoveDuplicateFromSortedLinkedList {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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
        ListNode temp = head;

        while(temp != null && temp.next != null) {
            if(temp.next.val == temp.val) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
}
