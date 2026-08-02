/**
 * Definition for singly-linked list.
 * 
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void show() {
        ListNode current = this;
        while (current.next != null) {
            System.out.printf("%s (%d) -> ", current, current.val);
            current = current.next;
        }

        System.out.printf("%s (%d)\n", current, current.val);
    }
}

class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list2 != null && list1 == null) return list2;

        ListNode head;

        if (list1.val < list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
        
        ListNode current = head;

        while (list1 != null && list2 != null) {           
            if (list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null && list2 == null) {
            while (list1 != null) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;	
            }
        }
        
        if (list2 != null && list1 == null) {
            while (list2 != null) {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;	
            }
        }  
        
        return head;
    }
}

public class LeetCode21 {
    public static void main(String[] args) {
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]

        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode list1 = new ListNode(1, l2);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3, l4);
        ListNode list2 = new ListNode(1, l5);

        // Input: list1 = [2], list2 = [1]
        // Output: [1,2]
        // ListNode list1 = new ListNode(2);
        // ListNode list2 = new ListNode(1);
        
        ListNode head = Solution.mergeTwoLists(list1, list2);
        head.show();
    }
}