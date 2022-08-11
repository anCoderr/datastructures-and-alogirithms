from collections import defaultdict

class LFUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.least_freq = 1
        self.freq_table = defaultdict(lambda: DLL())
        self.node_table = {}
        

    def put(self, key, val):
        if self.capacity == 0: return
        node = self.node_table.get(key, None)
        if node:
            node_freq = node.freq
            node.val = val
            node.freq += 1
            self.freq_table[node_freq].remove(node)
            self.freq_table[node_freq+1].add(node)
            if self.freq_table[self.least_freq].size == 0:
                self.least_freq += 1
        else:
            if len(self.node_table) >= self.capacity:
                dll = self.freq_table[self.least_freq]
                remove_node = dll.tail.prev
                dll.remove(remove_node)
                self.node_table.pop(remove_node.key)
            node = Node(key, val)
            self.node_table[key] = node
            self.freq_table[1].add(node)
            self.least_freq = 1

    def get(self, key):
        node = self.node_table.get(key, None)
        if not node: return -1
        node_freq = node.freq
        node.freq += 1
        self.freq_table[node_freq].remove(node)
        self.freq_table[node_freq+1].add(node)
        if self.freq_table[self.least_freq].size == 0:
            self.least_freq += 1
        return node.val

class DLL:
    def __init__(self):
        self.size = 0
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head

    def add(self, node):
        self.size += 1
        head_next = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = head_next
        head_next.prev = node

    def remove(self, node):
        self.size -= 1
        next_node = node.next
        prev_node = node.prev
        next_node.prev = prev_node
        prev_node.next = next_node

class Node:
    def __init__(self, key=0, val=0, freq=1, next=None, prev=None):
        self.key = key
        self.val = val
        self.freq = freq
        self.prev = prev
        self.next = next