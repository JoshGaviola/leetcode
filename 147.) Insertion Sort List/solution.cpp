class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        if (!head || !head->next) {
            return head; // If the list is empty or has only one element, it's already sorted.
        }
        
        ListNode* sorted = nullptr; // Initialize the sorted list as empty.
        ListNode* current = head;   // Pointer to iterate through the original list.
        
        while (current) {
            ListNode* next = current->next; // Store the next node to be processed.
            
            // Find the correct position to insert the current node in the sorted list.
            if (!sorted || current->val <= sorted->val) {
                current->next = sorted;
                sorted = current; // Insert at the beginning.
            } else {
                ListNode* p = sorted;
                while (p->next && p->next->val < current->val) {
                    p = p->next;
                }
                current->next = p->next;
                p->next = current; // Insert in the middle or at the end.
            }
            
            current = next; // Move to the next node in the original list.
        }
        
        return sorted;
    }
};