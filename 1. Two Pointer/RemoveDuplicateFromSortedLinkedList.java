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

    // algorithm explaination:
    // 1. Create a ListNode class to represent each node in the linked list.
    // 2. Initialize a temporary pointer to the head of the list.
    // 3. Traverse the list using a while loop until the temporary pointer reaches the end of the list or the next node is null.
    // 4. Inside the loop, check if the value of the next node is equal to the value of the current node.
    // 5. If they are equal, skip the next node by setting the current node's next pointer to the next node's next pointer.
    // 6. If they are not equal, move the temporary pointer to the next node.
    // 7. Continue this process until the end of the list is reached.
    // 8. Finally, return the head of the modified list, which will have all duplicates removed.
    // 9. The time complexity is O(n), where n is the number of nodes in the linked list, as we traverse the list once.
    // 10. The space complexity is O(1), as we are using a constant amount of extra space for the temporary pointer.
}
