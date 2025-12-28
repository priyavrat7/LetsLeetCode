# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:

        temp = ListNode(0)
        merged = temp


        l1 = list1
        l2 = list2

        while(l1 and l2):
            if(l1.val <= l2.val):
                merged.next = l1
                l1 = l1.next

            else:
                merged.next = l2
                l2 = l2.next
            
            # It is mandatory to go to next location in the merged after if or else code execution
            merged = merged.next

        if(l1):
            merged.next = l1
        if(l2):
            merged.next = l2
        
        
        
        return temp.next

        