class Solution {
    public Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        goDFS(root, 0, map);
        for (List<Node> list : map.values()) 
            for (int i = 1; i < list.size(); i++) 
                list.get(i - 1).next = list.get(i);
        return root;
    }
    
    private void goDFS(Node node, int lvl, Map<Integer, List<Node>> map) {
        if (node == null) return;

        List<Node> list = map.computeIfAbsent(lvl, ArrayList::new);
        list.add(node);
        lvl++;
        goDFS(node.left, lvl, map);
        goDFS(node.right, lvl, map);
    }
}