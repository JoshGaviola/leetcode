import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) { 
        if (head == null) return null;

        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            nodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node newNode = nodeMap.get(curr);
            newNode.next = nodeMap.get(curr.next);
            newNode.random = nodeMap.get(curr.random);
            curr = curr.next;
        }

        return nodeMap.get(head);
    }
}