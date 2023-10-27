/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (!head || !head->next) {
            return nullptr;  // No cycle if the list is empty or has only one node
        }

        ListNode *slow = head;
        ListNode *fast = head;
        bool hasCycle = false;

        // Find the collision point
        while (fast && fast->next) {
            slow = slow->next;       // Move slow pointer by one step
            fast = fast->next->next;  // Move fast pointer by two steps

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // If there's no cycle, return null
        if (!hasCycle) {
            return nullptr;
        }

        // Reset one pointer to the head and move both at the same speed
        slow = head;
        while (slow != fast) {
            slow = slow->next;
            fast = fast->next;
        }

        return slow; // The collision point is the start of the cycle
    }
};
