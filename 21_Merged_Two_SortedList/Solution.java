/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoSortedListsSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode temp = new ListNode(0);
        ListNode current = temp;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null){
            current.next = l1;
        }

        if(l2 != null){
            current.next = l2;
        }
        return temp.next;
    }
}
