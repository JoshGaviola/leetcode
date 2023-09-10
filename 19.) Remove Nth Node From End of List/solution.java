public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to make the code easier to write.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Find the node before the nth node from the end.
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move the slow pointer to the node to remove.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the node.
        slow.next = slow.next.next;

        return dummy.next;
    }
}
