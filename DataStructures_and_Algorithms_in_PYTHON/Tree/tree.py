class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def tree_serialize(root):
    queue, arr = [root], []
    while len(queue) != 0:
        current = queue.pop(0)
        if current is not None:
            arr.append(current.val)
            queue.append(current.left)
            queue.append(current.right)
        else:
            arr.append(None)
    return arr


def tree_deserialize(arr: list[int]):
    s = str(arr)
    s = s.replace('[', '').replace(']', '').replace('None', 'X').replace('null', 'X').replace(' ', '')
    data = [int(i) if i != 'X' else None for i in s.split(',')]
    if len(data) % 2 == 0:
        # Since we are increasing i by 2 every iteration.
        # So added an extra None to avoid errors.
        data.append(None)
    if data[0] is None:
        return None
    root = TreeNode(int(data.pop(0)))
    queue, index, length = [root], 0, len(data)
    while index < length:
        a = data[index]
        b = data[index + 1]
        index += 2
        current = queue.pop(0)
        if a is not None:
            current.left = TreeNode(int(a))
            queue.append(current.left)
        if b is not None:
            current.right = TreeNode(int(b))
            queue.append(current.right)
    return root


print(tree_serialize(tree_deserialize([1, 2, 3, 4, 5, 6, 7, None, None, 8])))
