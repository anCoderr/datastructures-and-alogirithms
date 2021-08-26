package DataStructures.Trees;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

import java.util.ArrayList;

public class BinaryTree {
    TreeNode root;
    int size;
    ArrayList<Integer> tree;

    public BinaryTree() {
        tree = new ArrayList<>();
        root = new TreeNode();
        size = 0;
    }

    public void insert(int val) {
        tree.add(val);
        size++;
    }

    public void insert(int val, int index) {
        tree.add(val, index);
        size++;
    }

    public void delete(Integer val) {
        tree.remove(val);
        size = tree.size();
    }

    public void delete(int index) {
        tree.remove(index);
        size = tree.size();
    }

    public boolean contains(int val) {
        for(int i : tree)
            if(i == val)
                return true;
        return false;
    }

    public int leftChildIndex(int parentIndex) {
        return 2*parentIndex+1;
    }
    public int rightChildIndex(int parentIndex) {
        return 2*parentIndex+2;
    }
    public int parentIndex(int childIndex) {
        return (childIndex-1)/2;
    }
    public boolean hasLeftChild(int parentIndex) {
        return 2*parentIndex+1 < tree.size();
    }
    public boolean hasRightChild(int parentIndex) {
        return 2*parentIndex+2 < tree.size();
    }
    public boolean hasParent(int childIndex) {
        return (childIndex-1)/2 >= 0;
    }
}
