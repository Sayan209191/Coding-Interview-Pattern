public class PalindromeLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow); // reverse second half
        slow.next = null;
        while(rev != null) {
            if(head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    
    }

    // algorithm :
    // 1. Initialize two pointers, slow and fast, both pointing to the head of the linked list.
    // 2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
    // 3. When the fast pointer reaches the end of the list (null), the slow pointer will be at the middle node.
    // 4. Reverse the second half of the linked list starting from the slow pointer.
    // 5. Compare the first half of the list with the reversed second half.
    // 6. If all values match, return true; otherwise, return false.
    // 8. Return true if the list is a palindrome, false otherwise.
}
