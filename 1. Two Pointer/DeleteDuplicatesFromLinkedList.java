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

    // algorithm explaination:
    // 1. Create a dummy node to handle edge cases where the head node is a duplicate.
    // 2. Initialize two pointers, fast and slow. The fast pointer will traverse the list, while the slow pointer will point to the last unique node.
    // 3. Set the slow pointer's next to the fast pointer to start the traversal.
    // 4. Traverse the list with the fast pointer until it reaches the end.
    // 5. Inside the loop, check if the current node has duplicates by comparing it with the next node.
    // 6. If duplicates are found, move the fast pointer to the last duplicate node.
    // 7. If duplicates are detected, set the slow pointer's next to the fast pointer's next to remove the duplicates.
    // 8. If no duplicates are found, move both the slow and fast pointers to the next nodes.
    // 9. Continue this process until the fast pointer reaches the end of the list.
    // 10. Finally, return the next node of the dummy node, which will be the head of the modified list without duplicates.
    // 11. The time complexity is O(n), where n is the number of nodes in the linked list, as we traverse the list once.
    // 12. The space complexity is O(1), as we are using a constant amount of extra space for the dummy node and pointers.
}
