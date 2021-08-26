package DataStructures.Trees;

import Exceptions.ExceptionsGenerator;

public class BinarySearchTree {
    static class Runner {
        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();
            bst.insert(51);
            bst.insert(78);
            bst.insert(27);
            bst.insert(29);
            bst.insert(19);
            bst.insert(61);
            bst.insert(94);
            bst.insert(91);
            bst.insert(90);
            bst.insert(89);
            bst.insert(88);
            bst.insert(87);
            bst.insert(99);
            bst.insert(59);
            bst.insert(58);
            bst.insert(10);
            bst.insert(25);
            bst.insert(28);
            bst.insert(30);
            System.out.println(bst.contains(78));
            System.out.println(bst.contains(51));
            bst.delete(78);
            bst.delete(51);
            System.out.println(bst.contains(78));
            System.out.println(bst.contains(51));


            System.out.println(bst.contains(27));
            System.out.println(bst.contains(30));
            System.out.println(bst.contains(90));
            System.out.println(bst.contains(99));

            bst.printInorder(bst.root);
            System.out.println();
            bst.printPreorder(bst.root);
            System.out.println();
            bst.printPostorder(bst.root);
            System.out.println();
        }
    }
    TreeNode root;
    int size;
    public BinarySearchTree() {
        root = new TreeNode();
        size = 0;
    }
    public void insert(int val) {
        if(contains(val))
            throw new IllegalArgumentException();
        if(size++ == 0) {
            root.val = val;
            return;
        }
        TreeNode temp = new TreeNode(val);
        TreeNode address = searchForNode(val);
        if(address.val == val)
            return;
        if(val > address.val)
            address.right = temp;
        else
            address.left = temp;
    }

    public boolean contains(int val) {
        return searchForNode(val).val == val;
    }

    public void delete(int val) {
        if(!contains(val))
            throw new IllegalArgumentException();
        size--;
        TreeNode parent, current, replacement;
        TreeNode[] location = searchForNodeAndParent(val);
        current = location[0];
        parent = location[1];
        boolean right = location[2].val==1;
        if(current.left == null && current.right == null)
            replacement = null;
        else if(current.right == null)
            replacement = current.left;
        else if(current.left == null)
            replacement = current.right;
        else {
            if(current.right.left == null) {
                current.val = current.right.val;
                replacement = current;
                current.right = current.right.right;
            } else {
                TreeNode tempParent = current.right;
                TreeNode temp = current.right.left;
                while(temp.left != null) {
                    tempParent = temp;
                    temp = temp.left;
                }
                current.val = temp.val;
                tempParent.left = temp.right;
                replacement = current;
            }
        }
        if(parent == null) {
            root = replacement;
        } else {
            if(!right)
                parent.left = replacement;
            else
                parent.right = replacement;
        }
    }

    public TreeNode searchForNode(int val) {
        TreeNode current = root, prev = null;
        while(current != null) {
            prev = current;
            if(current.val == val)
                return current;
            if(current.val > val)
                current = current.left;
            else
                current = current.right;
        }
        return prev;
    }
    public TreeNode[] searchForNodeAndParent(int val) {
        TreeNode current = root, parent = null;
        boolean right = false;
        while(current != null) {
            if(current.val == val)
                break;
            parent = current;
            if(current.val > val) {
                current = current.left;
                right = false;
            } else {
                current = current.right;
                right = true;
            }
        }
        return new TreeNode[]{current, parent, new TreeNode(right ? 1 : 0)};
    }

    public void printInorder(TreeNode node) {
        if(node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public void printPreorder(TreeNode node) {
        if(node == null)
            return;
        printPreorder(node.left);
        printPreorder(node.right);
        System.out.print(node.val + " ");
    }

    public void printPostorder(TreeNode node) {
        if(node == null)
            return;

        System.out.print(node.val + " ");
        printPostorder(node.left);
        printPostorder(node.right);
    }
}
