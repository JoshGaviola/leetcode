public ListNode partition(ListNode head, int x) {
    ListNode lessHead = new ListNode(0); // Dummy head for the list of nodes less than x
    ListNode less = lessHead;
    ListNode greaterHead = new ListNode(0); // Dummy head for the list of nodes greater than or equal to x
    ListNode greater = greaterHead;

    while (head != null) {
        if (head.val < x) {
            less.next = head;
            less = less.next;
        } else {
            greater.next = head;
            greater = greater.next;
        }
        head = head.next;
    }

    greater.next = null; // Mark the end of the greater list
    less.next = greaterHead.next; // Combine the two lists

    return lessHead.next; // Return the merged list
}
