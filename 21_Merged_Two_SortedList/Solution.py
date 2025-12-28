# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:

        mergedList = ListNode(0)
        ref_mergedList = mergedList

        while(list1 and list2):
            if(list1.val <= list2.val):
                mergedList.next = ListNode(list1.val)
                mergedList = mergedList.next
                list1 = list1.next
            
            elif(list2.val < list1.val):
                mergedList.next = ListNode(list2.val)
                mergedList = mergedList.next
                list2 = list2.next
        
        # Drain
        if(list1 == None):
            while(list2):
                mergedList.next = ListNode(list2.val)
                mergedList = mergedList.next
                list2 = list2.next

        elif(list2 == None):
            while(list1):
                mergedList.next = ListNode(list1.val)
                mergedList = mergedList.next
                list1 = list1.next


        
        return ref_mergedList.next
