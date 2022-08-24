import math

def get_mid_index(left, right):
    return (left + right) // 2

def get_left_child_index(index):
    return 2 * index + 1
        
def get_right_child_index(index):
    return 2 * index + 2


##########################################################################################
##########################################################################################
##### Segment Tree for Range Sum + Point/Range Update without LAZY PROPOGATION
class SegmentTreeRangeSum:
    def __init__(self, data):
        self.n = len(data)
        self.seg_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        for i, val in enumerate(data):
            self.point_update_query(i, val)        

    def point_update_query_utility(self, index, left, right, i, diff):
        if right < i or left > i: 
            return
        self.seg_tree[index] += diff
        if left != right:
            mid = get_mid_index(left, right)
            left_child_index = get_left_child_index(index)
            right_child_index = get_right_child_index(index)
            self.point_update_query_utility(left_child_index, left, mid, i, diff)
            self.point_update_query_utility(right_child_index, mid + 1, right, i, diff)

    def point_update_query(self, i, diff):
        self.point_update_query_utility(0, 0, self.n - 1, i, diff)

    def range_sum_query_utility(self, index, l, r, left, right):
        if right < l or left > r:
            return 0
        if right <= r and left >= l:
            return self.seg_tree[index]
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        sum_left = self.range_sum_query_utility(left_child_index, l, r, left, mid)
        sum_right = self.range_sum_query_utility(right_child_index, l, r, mid + 1, right)
        return sum_left + sum_right

    def range_sum_query(self, l, r):
        return self.range_sum_query_utility(0, l, r, 0, self.n - 1)


##########################################################################################
##########################################################################################
##### Segment Tree for Range Sum + Point/Range Update using LAZY PROPOGATION
class SegmentTreeRangeSumLazy:
    def __init__(self, data):
        self.n = len(data)
        self.seg_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.lazy_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        for i, val in enumerate(data):
            self.point_update_query(i, val)
    
    def propogate_changes_down(self, index, left, right):
        self.seg_tree[index] += (right-left+1) * self.lazy_tree[index]
        if left != right:
            left_child_index = get_left_child_index(index)
            right_child_index = get_right_child_index(index)
            self.lazy_tree[left_child_index] += self.lazy_tree[index]
            self.lazy_tree[right_child_index] += self.lazy_tree[index]
        self.lazy_tree[index] = 0

    def range_update_query_utility(self, index, left, right, l, r, diff):
        if right < l or left > r:
            return
        elif l <= left and right <= r:
            self.seg_tree[index] += (right-left+1) * diff
            if left != right:
                left_child_index = get_left_child_index(index)
                right_child_index = get_right_child_index(index)
                self.lazy_tree[left_child_index] += diff
                self.lazy_tree[right_child_index] += diff
            return
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        self.range_update_query_utility(left_child_index, left, mid, l, r, diff)
        self.range_update_query_utility(right_child_index, mid+1, right, l, r, diff)
        self.seg_tree[index] = self.seg_tree[left_child_index] + self.seg_tree[right_child_index]

    def range_update_query(self, l, r, diff):
        self.range_update_query_utility(0, 0, self.n-1, l, r, diff)

    def point_update_query_utility(self, index, left, right, i, diff):
        if right < i or left > i: 
            return
        self.seg_tree[index] += diff
        if left != right:
            mid = get_mid_index(left, right)
            left_child_index = get_left_child_index(index)
            right_child_index = get_right_child_index(index)
            self.point_update_query_utility(left_child_index, left, mid, i, diff)
            self.point_update_query_utility(right_child_index, mid + 1, right, i, diff)

    def point_update_query(self, i, diff):
        self.point_update_query_utility(0, 0, self.n - 1, i, diff)

    def range_sum_query_utility(self, index, left, right, l, r):
        if right < l or left > r:
            return 0
        if self.lazy_tree[index] != 0:
            self.propogate_changes_down(index, left, right)
        if right <= r and left >= l:
            return self.seg_tree[index]
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        sum_left = self.range_sum_query_utility(left_child_index, left, mid, l, r)
        sum_right = self.range_sum_query_utility(right_child_index,  mid + 1, right, l, r)
        return sum_left + sum_right

    def range_sum_query(self, l, r):
        return self.range_sum_query_utility(0, 0, self.n - 1, l, r)


##########################################################################################
##########################################################################################
##### Testing

st = SegmentTreeRangeSum([2,4,-3,0,5,9,1,3])
print(st.seg_tree)
print(st.range_sum_query(0,7))
print(st.range_sum_query(1,3))
print(st.range_sum_query(3,6))
st.point_update_query(4, -9)
print(st.range_sum_query(0,7))
print(st.range_sum_query(3,6))
print(st.range_sum_query(6,7))

st = SegmentTreeRangeSumLazy([2,4,-3,0,5,9,1,3])
print(st.seg_tree)
print(st.range_sum_query(0,7))
print(st.range_sum_query(1,3))
print(st.range_sum_query(3,6))
st.range_update_query(3, 6, 10)
print(st.seg_tree)
print(st.range_sum_query(0,7))
print(st.range_sum_query(1,3))
print(st.range_sum_query(3,6))

st = SegmentTreeRangeSumLazy([7,9,2,4,10,1,1,3,5,2,4,11,0,2,0,1])
print(st.seg_tree)
print(st.range_sum_query(0,15))
print(st.range_sum_query(3,3))
print(st.range_sum_query(5,11))
print(st.range_sum_query(12,15))
st.range_update_query(2, 6, 7)
st.range_update_query(10, 13, 3)
print(st.seg_tree)
print(st.range_sum_query(0,15))
print(st.range_sum_query(3,3))
print(st.range_sum_query(5,11))
print(st.range_sum_query(12,15))