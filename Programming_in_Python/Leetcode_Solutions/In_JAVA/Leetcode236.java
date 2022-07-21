package SolutionsInJAVA;

import LeetcodeDefaultImplementationsOfDS.TreeNode;

public class Leetcode236 {
    public TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        recurseTree(root, p, q);
        return ans;
    }
    public boolean recurseTree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) // We reached the end of a subtree.
            return false;
        int left = recurseTree(node.left, p, q) ? 1 : 0; // If left subtree contains either p or q
        int right = recurseTree(node.right, p, q) ? 1 : 0; // If right subtree contains either p or q
        int mid = (node == p || node == q) ? 1 : 0; // If the current node contains either p or q
        // If any two from left, right, mid are 1 then the current node is lowest common ancestor
        if (mid + left + right >= 2)
            ans = node;
        /* If any one from left, right, mid are 1 then the current node
            return a true to its parent as its left or right value */
        return (mid + left + right > 0);
    }
}