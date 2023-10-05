class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 1; // Initialize length to 1 (counting the head node)
        ListNode tail = head;

        // Calculate the length and find the old tail
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Calculate the effective k value
        k = k % length;

        if (k == 0) {
            return head; // No rotation needed
        }

        // Find the new tail node
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Update the pointers to rotate the list
        ListNode newHead = newTail.next;
        newTail.next = null; // Break the list
        tail.next = head; // Make it circular

        return newHead; // New head of the rotated list
    }
}
