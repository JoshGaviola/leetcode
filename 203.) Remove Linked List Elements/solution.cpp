class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode dummy(0); // Create a dummy node as the new head
        dummy.next = head;
        ListNode* prev = &dummy;
        ListNode* current = head;
        
        while (current) {
            if (current->val == val) {
                prev->next = current->next; // Skip the node with the given value
                delete current; // Delete the removed node
                current = prev->next; // Move to the next node
            } else {
                prev = current;
                current = current->next;
            }
        }
        
        return dummy.next; // The new head is after the dummy node
    }
};
