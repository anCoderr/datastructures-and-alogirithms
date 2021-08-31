package DataStructures.Trees;

import java.util.LinkedList;

public class AVLTree {
    public static class Runner {
        public static void main(String[] args) {
            AVLTree tree = new AVLTree();
            tree.insert(10);
            tree.insert(98);
            tree.insert(4);
            tree.insert(13);
            tree.insert(27);
            tree.insert(69);
            tree.insert(45);
            tree.insert(32);
            tree.insert(14);
            tree.insert(9);
            tree.insert(39);
            tree.insert(81);
            tree.insert(76);
            tree.insert(1);
            tree.delete(tree.root, 69);
            tree.delete(tree.root, 76);
            tree.preOrder();
        }
    }
    public static class Node {
        int val, height;
        Node left, right;
        public Node(int val) {
            this.val = val;
            height = 1;
        }
    }
    Node root;
    public void insert(int val) {
        this.root = insert(root, val);
    }
    public Node insert(Node node, int val) {
        if(node==null)
            return new Node(val);
        if(node.val == val)
            return null;
        if(node.val>val)
            node.left = insert(node.left, val);
        else
            node.right = insert(node.right, val);
        setHeight(node);
//        node.height = Math.max(height(node.left), height(node.right))+1;
        int bf = bf(node);
        if(bf>1 && val < node.left.val) // LL Case
            return rightRotate(node);
        if(bf<-1 && val > node.right.val) // RR Case
            return leftRotate(node);
        if(bf>1 && val>node.left.val) { // LR Case
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        if(bf<-1 && val < node.right.val) { // RL Case
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public Node delete(Node node, int val) {
        if(node == null)
            throw new IllegalArgumentException();
        else if(node.val > val) {
            node.left = delete(node.left, val);
        } else if(node.val < val) {
            node.right = delete(node.right, val);
        } else {
            if(node.left == null || node.right == null) {
                Node temp = node.left == null ? root.right : root.left;
                if(temp == null) {
                    node = null;
                } else
                    node = temp;
            } else {
                Node temp = node.right;
                while(temp.left != null)
                    temp = temp.left;
                node.val = temp.val;
                node.right = delete(node.right, temp.val);
            }
            if(node == null)
                return node;
            setHeight(node);
            int bf = bf(node);
            if(bf>1 && bf(node.left)>=0) // LL Case
                return rightRotate(node);
            if(bf<-1 && bf(node.right)<=0) // RR Case
                return leftRotate(node);
            if(bf>1 && bf(node.left)<0) { // LR Case
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
            if(bf<-1 && bf(node.right)>0) { // RL Case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public void setHeight(Node node) {
        if(node == null)
            return;
        node.height = Math.max(height(node.left), height(node.right))+1;
    }

    public boolean contains(int val) {
        Node current = root;
        while(current != null) {
            if(val == current.val)
                return true;
            if(val > current.val)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    public int height(Node node) {
        if(node == null)
            return 0;
        return node.height;
    }

    public int bf(Node node) {
        if(node == null)
            return 0;
        return height(node.left)-height(node.right);
    }

    public Node rightRotate(Node parent) {
        Node child = parent.left;
        Node T3 = child.right;
        child.right = parent;
        parent.left = T3;
        /* IMPORTANT : We first update the height for parent than the child.
            This is because the child is now the parent of the parent.
            Thus we first update the height parameter of the child that is in
            this case "parent". This order is very important.
        */
        setHeight(parent);
        setHeight(child);
//        parent.height = Math.max(height(parent.left), height(parent.right))+1;
//        child.height = Math.max(height(child.left), height(child.right))+1;
        return child;
    }

    public Node leftRotate(Node parent) {
        Node child = parent.right;
        Node T2 = child.left;
        child.left = parent;
        parent.right = T2;
        /* IMPORTANT : We first update the height for parent than the child.
            This is because the child is now the parent of the parent.
            Thus we first update the height parameter of the child that is in
            this case "parent". This order is very important.
        */
        setHeight(parent);
        setHeight(child);
//        parent.height = Math.max(height(parent.left), height(parent.right))+1;
//        child.height = Math.max(height(child.left), height(child.right))+1;
        return child;
    }

    public void preOrder() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        while(!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.val + " ");
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }
}