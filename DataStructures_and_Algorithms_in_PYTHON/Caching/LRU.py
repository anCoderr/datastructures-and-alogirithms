class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.dll = DLL()

    def put(self, key, val):
        node = self.dll.node_table.get(key, None)
        if node:
            self.dll.remove(node)
            node.val = val
            self.dll.add(node)
        else:
            if len(self.dll.node_table) >= self.capacity:
                remove_node = self.dll.tail.prev
                self.dll.remove(remove_node)
                self.dll.node_table.pop(remove_node.key)
            node = Node(key, val)
            self.dll.add(node)
            self.dll.node_table[key] = node

    def get(self, key):
        node = self.dll.node_table.get(key, None)
        if not node: return -1
        self.dll.remove(node)
        self.dll.add(node)
        return node.val   

class DLL:
    def __init__(self):
        self.node_table = {}
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def add(self, node):
        head_next = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = head_next
        head_next.prev = node

    def remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev     

class Node:
    def __init__(self, key=0, val=0, next=None, prev=None):
        self.key = key
        self.val = val
        self.next = next
        self.prev = prev