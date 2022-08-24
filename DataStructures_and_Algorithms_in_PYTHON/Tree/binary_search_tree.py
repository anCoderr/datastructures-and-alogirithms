##########################################################################################
##########################################################################################
# RESOURCES:
# https://www.programiz.com/dsa/avl-tree
# https://github.com/TheAlgorithms/Python/blob/master/data_structures/binary_tree/avl_tree.py
# https://www.youtube.com/watch?v=jDM6_TnYIqE
from logging.config import valid_ident


class TreeNode:
    def __init__(self, val) -> None:
        self.val = val
        self.left = None
        self.right = None
        self.height = 1
        self.subtree_size = 1


class AVL_Tree(object):

    def __init__(self):
        self.root = None
        self.inserted = None

    def insert(self, key):
        if self.root is None:
            self.root = TreeNode(key)
            self.inserted = self.root
        else:
            self.root = self.insert_utility(self.root, key)
        return self.inserted

    def insert_utility(self, current, val):
        # Step 1 - Perform normal search for current node.
        if not current:
            new_node = TreeNode(val)
            self.inserted = new_node
            return new_node
        elif val < current.val:
            current.left = self.insert_utility(current.left, val)
        else:
            current.right = self.insert_utility(current.right, val)

        # Step 2 - Update the height of the ancestor node
        current.height = 1 + max(self.get_height(current.left), self.get_height(current.right))

        current.subtree_size = 1 + self.get_subtree_size(current.left) + self.get_subtree_size(current.right)

        # Step 3 - Get the balance factor
        balance_factor = self.get_balance(current)

        # Step 4 - If the node is unbalanced, then perform the rotations.
        if balance_factor > 1:
            if val < current.left.val:  # Left Left Rotation Needed
                return self.right_rotation_operation(current)
            else:  # Left Right Rotation Needed
                current.left = self.left_rotation_operation(current.left)
            return self.right_rotation_operation(current)
        elif balance_factor < -1:
            if val > current.right.val:  # Right Right Rotation Needed
                return self.left_rotation_operation(current)
            else:  # Right Left Rotation Needed
                current.right = self.right_rotation_operation(current.right)
                return self.left_rotation_operation(current)
        return current

    def delete(self, val):
        if not self.root:
            return
        self.root = self.delete_utility(self.root, val)

    def delete_utility(self, current, val):
        if not current:
            return current
        elif val < current.val:
            temp = self.delete_utility(current.left, val)
            current.left = temp
            # current.left = self.delete_utility(current.left, val)
        elif val > current.val:
            current.right = self.delete_utility(current.right, val)
        else:
            if current.left is None:
                right_subtree = current.right
                current = None
                return right_subtree
            elif current.right is None:
                left_subtree = current.left
                current = None
                return left_subtree
            right_subtree_smallest_node = self.get_smallest_node(current.right)
            current.val = right_subtree_smallest_node.val
            current.right = self.delete_utility(current.right, current.val)

        if current is None:
            return current

        current.height = 1 + \
            max(self.get_height(current.left), self.get_height(current.right))

        balance_factor = self.get_balance(current)

        if balance_factor > 1:
            if self.get_balance(current.left):  # Left Left Rotation Needed
                return self.right_rotation_operation(current)
            else:  # Left Right Rotation Needed
                current.left = self.left_rotation_operation(current.left)
            return self.right_rotation_operation(current)
        elif balance_factor < -1:
            if self.get_balance(current.right):  # Right Right Rotation Needed
                return self.left_rotation_operation(current)
            else:  # Right Left Rotation Needed
                current.right = self.right_rotation_operation(current.right)
                return self.left_rotation_operation(current)
        return current

    def get_smallest_node(self, current):
        if current is None or current.left is None:
            return current
        return self.get_smallest_node(current.left)

    def left_rotation_operation(self, A):
        B = A.right
        Bl = B.left
        # Perform rotation
        B.left = A
        A.right = Bl
        # Update heights
        A.height = 1 + max(self.get_height(A.left), self.get_height(A.right))
        B.height = 1 + max(self.get_height(B.left), self.get_height(B.right))
        # Return the new root
        return B

    def right_rotation_operation(self, A):
        B = A.left
        Br = B.right
        # Perform rotation
        B.right = A
        A.left = Br
        # Update heights
        A.height = 1 + max(self.get_height(A.left), self.get_height(A.right))
        B.height = 1 + max(self.get_height(B.left), self.get_height(B.right))
        # Return the new root
        return B

    def get_height(self, current):
        if not current:
            return 0
        return current.height

    def get_balance(self, current):
        if not current:
            return 0
        return self.get_height(current.left) - self.get_height(current.right)

    def get_subtree_size(self, current):
        if not current:
            return 0
        return current.subtree_size

    def get_inorder_traversal(self):
        inorder = []

        def traversal(current):
            if not current:
                return
            traversal(current.left)
            inorder.append(current.val)
            traversal(current.right)
        traversal(self.root)
        return inorder

    def print_tree(self):
        for level in self.print_tree_utility(self.root):
            print('  '.join(level))

    def print_tree_utility(self, root: TreeNode):
        def get_depth(node):
            if not node:
                return 0
            return max(get_depth(node.left), get_depth(node.right)) + 1

        def insert_value(node, lo, hi, depth=0):
            if not node:
                return
            mid = (lo + hi) // 2
            output[depth][mid] = str(node.val)
            insert_value(node.left, lo, mid, depth + 1)
            insert_value(node.right, mid, hi, depth + 1)

        depth = get_depth(root)
        output = [["."] * (2**depth - 1) for _ in range(depth)]

        insert_value(root, 0, 2**depth - 1)
        return output


tree = AVL_Tree()
tree.insert(10)
tree.insert(75)
tree.insert(65)
tree.insert(20)
tree.insert(15)
print("SUBTREE SIZE FOR ROOT", tree.get_subtree_size(tree.root))
tree.print_tree()
print(tree.get_inorder_traversal())
tree.insert(25)
tree.insert(60)
tree.insert(30)
tree.insert(55)
tree.insert(40)
print("SUBTREE SIZE FOR ROOT", tree.get_subtree_size(tree.root))
tree.print_tree()
print(tree.get_inorder_traversal())
tree.insert(35)
tree.insert(50)
tree.insert(70)
tree.insert(45)
tree.insert(80)
print("SUBTREE SIZE FOR ROOT", tree.get_subtree_size(tree.root))
tree.print_tree()
print(tree.get_inorder_traversal())
# tree.delete(100)
# tree.delete(5)
# tree.delete(23)
# tree.print_tree()
# print(tree.get_inorder_traversal())
# tree.delete(30)
# tree.print_tree()
# print(tree.get_inorder_traversal())
