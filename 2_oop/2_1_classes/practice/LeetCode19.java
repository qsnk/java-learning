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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = length(head);

        if (size <= 1) return null;

        System.out.println(size);
        ListNode current = head;
        ListNode prev = current;
        int index = 1;

        if (index == size + 1 - n) return head.next;
    
        while (index != size + 1 - n) {
            prev = current;
            current = current.next;
            index++;
        }

        prev.next = current.next;
        return head;
    }

    public static int length(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}

public class LeetCode19 {
    public static void main(String[] args) {
        // Input: head = [1,2,3,4,5], n = 2
        // Output: [1,2,3,5]

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode list1 = new ListNode(1, l2);
        
        ListNode head = Solution.removeNthFromEnd(list1, 2);
        head.show();
    }
}