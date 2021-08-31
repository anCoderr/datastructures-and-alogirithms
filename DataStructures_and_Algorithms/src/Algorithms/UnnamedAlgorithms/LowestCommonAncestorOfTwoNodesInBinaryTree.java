package Algorithms.UnnamedAlgorithms;

import DataStructures.Trees.TreeNode;

public class LowestCommonAncestorOfTwoNodesInBinaryTree {
    public TreeNode ans;
    public boolean recurseTree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        int left = recurseTree(node.left, p, q) ? 1 : 0;
        int right = recurseTree(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if (mid + left + right >= 2)
            ans = node;
        return (mid + left + right > 0);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        recurseTree(root, p, q);
        return ans;
    }
}
