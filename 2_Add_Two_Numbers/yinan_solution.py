# # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        first_val = (l1.val + l2.val) % 10
        result = ListNode(val=first_val)
        head = result
        carry = (l1.val + l2.val) // 10

        while l1.next != None or l2.next != None:
            if l1.next != None and l2.next != None:
                l1 = l1.next
                l2 = l2.next
                cur_val = (l1.val + l2.val + carry) % 10
                carry = (l1.val + l2.val + carry) // 10
                result.next = ListNode(val=cur_val)
                result = result.next
            elif l1.next != None and l2.next == None:
                l1 = l1.next
                cur_val = (l1.val + carry) % 10
                carry = (l1.val + carry) // 10
                result.next = ListNode(val=cur_val)
                result = result.next
            elif l1.next == None and l2.next != None:
                l2 = l2.next
                cur_val = (l2.val + carry) % 10
                carry = (l2.val + carry) // 10
                result.next = ListNode(val=cur_val)
                result = result.next
        if carry == 1:
            result.next = ListNode(val=1)
        return head



