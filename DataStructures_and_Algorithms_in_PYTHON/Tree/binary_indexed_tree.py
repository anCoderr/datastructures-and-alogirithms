class FenwickTree:
    def __init__(self, n, data):
        self.n = n
        self.fenwick_tree = [0 for _ in range(0, n + 1)]
        self.construct(data)

    def construct(self, data):
        for i in range(self.n):
            self.update(i, data[i])

    def update(self, index, val):
        index += 1
        while index <= self.n:
            self.fenwick_tree[index] += val
            index += (index & (-index))

    def query(self, index):
        res = 0
        index += 1
        while index > 0:
            res += self.fenwick_tree[index]
            index -= (index & (-index))
        return res

    def range(self, left, right):
        return self.query(right) - self.query(left - 1)


ft = FenwickTree(10, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
print(ft.fenwick_tree)
print(ft.range(0, 9))
print(ft.range(3, 3))
print(ft.range(4, 7))
print(ft.range(8, 9))
print(ft.range(0, 1))
print(ft.range(0, 0))
print(ft.range(9, 9))