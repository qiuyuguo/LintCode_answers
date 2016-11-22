"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param lists: a list of ListNode
    @return: The head of one sorted list.
    """
    def mergeKLists(self, lists):
        # write your code here
        if not lists:
            return None
        return self.mergeHelper(lists, 0, len(lists)-1)
        
    def mergeHelper(self, lists, start, end):
        if start == end:
            return lists[start]
        mid = start + (end-start)/2
        leftList = self.mergeHelper(lists, start, mid)
        rightList = self.mergeHelper(lists, mid+1, end)
        return self.mergeTwoLists(leftList, rightList)
        
    def mergeTwoLists(self, l1, l2):
        dummy = ListNode(0)
        lastNode = dummy
        while l1 and l2:
            if l1.val < l2.val:
                lastNode.next = l1
                l1 = l1.next
            else:
                lastNode.next = l2
                l2 = l2.next
            lastNode = lastNode.next
        if l1:
            lastNode.next = l1
        if l2:
            lastNode.next = l2
        return dummy.next
