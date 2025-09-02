# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: Optional[ListNode]
        :type l2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode()
        current = dummy
        carry = 0
        #print(l1)
        
        while l1 or l2 or (carry > 0):

            mysum = ( 
                    (l1.val if l1 is not None else 0) + 
                    (l2.val if l2 is not None else 0) + 
                    carry 
                    )

            digit = mysum % 10
            carry = mysum // 10

            current.next = ListNode(digit)
            current = current.next

            l1 = l1.next if l1 is not None else None
            l2 = l2.next if l2 is not None else None
        
        print(dummy.next) 
        return(dummy.next)
