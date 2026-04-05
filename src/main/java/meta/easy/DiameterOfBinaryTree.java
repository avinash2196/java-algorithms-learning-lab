package meta.easy;

public class DiameterOfBinaryTree {
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findLongestPath(root);
        return diameter;
    }
    private int findLongestPath(TreeNode node){
        if(node==null)
            return 0;
        int leftPath=findLongestPath(node.left);
        int rightPath=findLongestPath(node.right);
        diameter=Math.max(diameter,leftPath+rightPath);//as edges not nodes
        return Math.max(leftPath,rightPath)+1; // for parent
    }
}
// Time complexity :O(n)
// Space Complexity :O(h)
