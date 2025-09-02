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
        cur = l1
        print(l1)
        print(cur)
        

        stack_1 = [] # class "list"
        while cur:
            #print(cur.val)
            stack_1.append(cur.val)
            cur = cur.next

        num_1 = 0
        len_1 = len(stack_1)
        #print(len(stack_1))
        for i in range(len(stack_1)):
            num_1 = num_1 + stack_1.pop() * 10 ** (len_1 - 1)
            len_1 -= 1 

        print(num_1)

        cur2 = l2
        stack_2 = [] # class "list"
        while cur2:
            #print(cur2.val)
            stack_2.append(cur2.val)
            cur2 = cur2.next

        num_2 = 0
        len_2 = len(stack_2)
        #print(len(stack_1))
        for i in range(len(stack_2)):
            num_2 = num_2 + stack_2.pop() * 10 ** (len_2 - 1)
            len_2 -= 1 

        print(num_2)

        num_3 = num_1 + num_2
        print(num_3)
        #print(len(str(num_3)))

        finalLL = ListNode()
        current = finalLL
        print(finalLL)

        for _ in range(len(str(num_3))):
            print(num_3 % 10)
            current.next = ListNode(num_3 % 10)
            current = current.next
            num_3 = num_3 // 10

        print(finalLL.next)
        return(finalLL.next)
