import math

def get_mid_index(left, right):
    return (left + right) // 2

def get_left_child_index(index):
    return 2 * index + 1
        
def get_right_child_index(index):
    return 2 * index + 2


##########################################################################################
##########################################################################################
##### Segment Tree for Range Sum + Point Update
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

    def point_update_query(self, i, val):
        self.point_update_query_utility(0, 0, self.n - 1, i, val)

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
##### Segment Tree for Range Sum + Range Update using LAZY PROPOGATION
class SegmentTreeRangeSumLazy:
    def __init__(self, data):
        self.n = len(data)
        self.seg_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.lazy_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        for i, val in enumerate(data):
            self.point_update_query(i, val)
    
    def propogate_changes_down(self, index, left, right):
        self.seg_tree[index] = self.lazy_tree[index]
        if left != right:
            self.lazy_tree[get_left_child_index(index)] = self.lazy_tree[index]
            self.lazy_tree[get_right_child_index(index)] = self.lazy_tree[index]
        self.lazy_tree[index] = 0

    def range_update_query_utility(self, index, left, right, l, r, diff):
        self.propogate_changes_down(index, left, right)
        if right < l or left > r:
            return 0
        elif l <= left and right <= r:
            self.seg_tree[index] += (right-left+1) * diff
            if left != right:
                self.lazy_tree[get_left_child_index(index)] += diff
                self.lazy_tree[get_right_child_index(index)] += diff
            return self.seg_tree[index]
        mid = get_mid_index(index)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        left_child_val = self.range_update_query(left_child_index, left, mid, l, r, diff)
        right_child_val = self.range_update_query(right_child_index, mid+1, right, l, r, diff)
        self.seg_tree[index] = left_child_val + right_child_val
        return self.seg_tree[index]



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


# ##########################################################################################
# ##########################################################################################
# ##### Segment Tree for Range Sum + Point Update
# class SegmentTreeRangeSum:
#     def __init__(self, data):
#         self.n = len(data)
#         self.seg_tree = self.build_tree(data)

#     def build_tree(self, data):
#         self.seg_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
#         self.build_tree_utility(0, 0, self.n - 1, data)
#         return self.seg_tree

#     def build_tree_utility(self, index, left, right, data):
#         if left == right:
#             self.seg_tree[index] = data[left]
#         else:
#             mid = get_mid_index(left, right)
#             left_child_index = get_left_child_index(index)
#             right_child_index = get_right_child_index(index)
#             self.build_tree_utility(left_child_index, left, mid, data)
#             self.build_tree_utility(right_child_index, mid + 1, right, data)
#             self.seg_tree[index] = self.seg_tree[left_child_index] + self.seg_tree[right_child_index]

#     def point_update_query(self, i, val):
#         self.point_update_query_utility(0, 0, self.n - 1, i, val)

#     def point_update_query_utility(self, index, left, right, i, diff):
#         if right < i or left > i:
#             return
#         self.seg_tree[index] += diff
#         if left != right:
#             mid = get_mid_index(left, right)
#             left_child_index = get_left_child_index(index)
#             right_child_index = get_right_child_index(index)
#             self.point_update_query_utility(left_child_index, left, mid, i, diff)
#             self.point_update_query_utility(right_child_index, mid + 1, right, i, diff)

#     def range_sum_query(self, l, r):
#         return self.range_sum_query_utility(0, l, r, 0, self.n - 1)

#     def range_sum_query_utility(self, index, l, r, left, right):
#         if right < l or left > r:
#             return 0
#         if right <= r and left >= l:
#             return self.seg_tree[index]
#         mid = get_mid_index(left, right)
#         left_child_index = get_left_child_index(index)
#         right_child_index = get_right_child_index(index)
#         sum_left = self.range_sum_query_utility(left_child_index, l, r, left, mid)
#         sum_right = self.range_sum_query_utility(right_child_index, l, r, mid + 1, right)
#         return sum_left + sum_right




##########################################################################################
##########################################################################################
##### Segment Tree for Range Min + Point Update
class SegmentTreeRangeMin:
    def __init__(self, data):
        self.n = len(data)
        self.seg_tree = self.build_tree(data)

    def build_tree(self, data):
        self.seg_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.build_tree_utility(0, 0, self.n - 1, data)
        return self.seg_tree

    def build_tree_utility(self, index, left, right, data):
        if left == right:
            self.seg_tree[index] = data[left]
        else:
            mid = get_mid_index(left, right)
            left_child_index = get_left_child_index(index)
            right_child_index = get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, data)
            self.build_tree_utility(right_child_index, mid + 1, right, data)
            self.seg_tree[index] = min(self.seg_tree[left_child_index], self.seg_tree[right_child_index])

    def point_update_query(self, i, val):
        self.point_update_query_utility(0, 0, self.n - 1, i, val)

    def point_update_query_utility(self, index, left, right, i, val):
        if left > i or right < i:
            return self.seg_tree[index]
        if left == right:
            if left == i:
                self.seg_tree[index] = val
            return self.seg_tree[index]
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        left_min_value = self.point_update_query_utility(left_child_index, left, mid, i, val)
        right_min_value = self.point_update_query_utility(right_child_index, mid + 1, right, i, val)
        self.seg_tree[index] = min(left_min_value, right_min_value)
        return self.seg_tree[index]
        
    def range_min_query(self, a, b):
        return self.range_min_query_utility(0, a, b, 0, self.n - 1)

    def range_min_query_utility(self, index, l, r, left, right):
        if right < l or left > r:
            return float('inf')
        if right <= r and left >= l:
            return self.seg_tree[index]
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        min_left = self.range_min_query_utility(left_child_index, l, r, left, mid)
        min_right = self.range_min_query_utility(right_child_index, l, r, mid + 1, right)
        return min(min_left, min_right)


##########################################################################################
##########################################################################################
##### Segment Tree for Range Max + Point Update
class SegmentTreeRangeMax:
    def __init__(self, data):
        self.n = len(data)
        self.seg_tree = self.build_tree(data)

    def build_tree(self, data):
        self.seg_tree = [0] * (2 ** int(math.ceil(math.log2(self.n)) + 1) - 1)
        self.build_tree_utility(0, 0, self.n - 1, data)
        return self.seg_tree

    def build_tree_utility(self, index, left, right, data):
        if left == right:
            self.seg_tree[index] = data[left]
        else:
            mid = get_mid_index(left, right)
            left_child_index = get_left_child_index(index)
            right_child_index = get_right_child_index(index)
            self.build_tree_utility(left_child_index, left, mid, data)
            self.build_tree_utility(right_child_index, mid + 1, right, data)
            self.seg_tree[index] = max(self.seg_tree[left_child_index], self.seg_tree[right_child_index])

    def point_update_query(self, i, val):
        self.point_update_query_utility(0, 0, self.n - 1, i, val)

    def point_update_query_utility(self, index, left, right, i, val):
        if left > i or right < i:
            return self.seg_tree[index]
        if left == right:
            if left == i:
                self.seg_tree[index] = val
            return self.seg_tree[index]
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        left_max_value = self.point_update_query_utility(left_child_index, left, mid, i, val)
        right_max_value = self.point_update_query_utility(right_child_index, mid + 1, right, i, val)
        self.seg_tree[index] = max(left_max_value, right_max_value)
        return self.seg_tree[index]
        
    def range_max_query(self, l, r):
        return self.range_max_query_utility(0, l, r, 0, self.n - 1)

    def range_max_query_utility(self, index, l, r, left, right):
        if right < l or left > r:
            return float('-inf')
        if right <= r and left >= l:
            return self.seg_tree[index]
        mid = get_mid_index(left, right)
        left_child_index = get_left_child_index(index)
        right_child_index = get_right_child_index(index)
        max_left = self.range_max_query_utility(left_child_index, l, r, left, mid)
        max_right = self.range_max_query_utility(right_child_index, l, r, mid + 1, right)
        return max(max_left, max_right)

##########################################################################################
##########################################################################################
##### 
st = SegmentTreeRangeSum([2,4,-3,0,5,9,1,3])
print(st.seg_tree)
print(st.range_sum_query(0,7))
print(st.range_sum_query(1,3))
print(st.range_sum_query(3,6))
st.point_update_query(4, -9)
print(st.range_sum_query(0,7))
print(st.range_sum_query(3,6))
print(st.range_sum_query(6,7))

st = SegmentTreeRangeMin([2,4,-3,0,5,9,1,3])
print(st.seg_tree)
print(st.range_min_query(0,7))
print(st.range_min_query(1,3))
print(st.range_min_query(3,6))
st.point_update_query(4, -9)
print(st.range_min_query(0,7))
print(st.range_min_query(3,6))
print(st.range_min_query(6,7))

st = SegmentTreeRangeMax([2,4,-3,0,5,9,1,3])
print(st.seg_tree)
print(st.range_max_query(0,7))
print(st.range_max_query(1,3))
print(st.range_max_query(3,6))
st.point_update_query(5, 0)
print(st.range_max_query(0,7))
print(st.range_max_query(3,6))
print(st.range_max_query(6,7))

st = SegmentTreeRangeSumLazy([2,4,-3,0,5,9,1,3])