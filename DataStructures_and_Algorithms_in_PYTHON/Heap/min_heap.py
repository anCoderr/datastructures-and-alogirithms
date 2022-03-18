class MinHeap():
    def __init__(self):
        self.heap = []

    def has_left_child(self, parent_index):
        return self.get_left_child_index(parent_index) < len(self.heap)

    def has_right_child(self, parent_index):
        return self.get_right_child_index(parent_index) < len(self.heap)

    def has_parent(self, child_index):
        return self.get_parent_index(child_index) >= 0

    def get_left_child_index(self, parent_index):
        return 2*parent_index+1

    def get_right_child_index(self, parent_index):
        return 2*parent_index+2

    def get_parent_index(self, child_index):
        return (child_index-1)//2

    def get_left_child(self, parent_index):
        return self.heap[self.get_left_child_index(parent_index)]

    def get_right_child(self, parent_index):
        return self.heap[self.get_right_child_index(parent_index)]

    def get_parent(self, child_index):
        return self.heap[self.get_parent_index(child_index)]

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def peek(self):
        return self.heap[0]

    def add(self, val):
        self.heap.append(val)
        self.heapify_bottom_up()

    def poll(self):
        ans = self.heap[0]
        self.swap(0, len(self.heap)-1)
        self.heap.pop()
        self.heapify_top_down()
        return ans

    def heapify_bottom_up(self):
        index = len(self.heap)-1
        while self.has_parent(index) and self.heap[index] < self.get_parent(index):
            self.swap(index, self.get_parent_index(index))
            index = self.get_parent_index(index)

    def heapify_top_down(self):
        index = 0
        while self.has_left_child(index):
            smaller = self.get_left_child_index(index)
            if self.has_right_child(index) and self.get_left_child(index) > self.get_right_child(index):
                smaller = self.get_right_child_index(index)
            if self.heap[index] < self.heap[smaller]:
                break
            self.swap(index, smaller)
            index = smaller