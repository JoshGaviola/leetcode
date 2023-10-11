public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    
    if (root == null) {
        return result;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> levelNodes = new ArrayList<>();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            levelNodes.add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        if (!leftToRight) {
            Collections.reverse(levelNodes);
        }
        
        result.add(levelNodes);
        leftToRight = !leftToRight;
    }
    
    return result;
}