from typing import List



class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def list_deserializer(nums: List[int]) -> ListNode:
    head = current = ListNode()
    for i in nums:
        current.next = ListNode(i)
        current = current.next
    return head.next

def list_serializer(root: ListNode) -> List[int]:
    current = root
    ans = []
    while current is not None:
        ans.append(current.val)
        current = current.next
    return ans