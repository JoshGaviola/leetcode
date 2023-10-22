import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Create a mapping between the original node and the cloned node.
        Map<Node, Node> nodeMapping = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Clone the root node and add it to the queue.
        Node cloneRoot = new Node(node.val, new ArrayList<>());
        nodeMapping.put(node, cloneRoot);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (Node neighbor : currNode.neighbors) {
                if (!nodeMapping.containsKey(neighbor)) {
                    // Clone the neighbor and add it to the mapping and the queue.
                    Node cloneNeighbor = new Node(neighbor.val, new ArrayList<>());
                    nodeMapping.put(neighbor, cloneNeighbor);
                    queue.offer(neighbor);
                }

                // Connect the cloned nodes.
                nodeMapping.get(currNode).neighbors.add(nodeMapping.get(neighbor));
            }
        }

        return cloneRoot;
    }
}
