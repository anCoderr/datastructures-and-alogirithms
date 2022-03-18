from typing import List
from DataStructures_and_Algorithms_in_PYTHON.Heap.min_heap import MinHeap


def merge_sort(arr: List[int]):
    min_heap, n = MinHeap(), len(arr)
    for i in arr:
        min_heap.add(i)
    for i in range(n):
        arr[i] = min_heap.poll()
    return arr