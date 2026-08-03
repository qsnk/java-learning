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

// Проблема в переполнении типа long (требуется 33 знака, доступно 19)
// class Solution {
//     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         long n1 = 0;
//         long n2 = 0;

//         for (long i = 1; l1 != null; i *= 10) {
//             if (l1.val == 0) {
//                 n1 *= 10;
//             } else {
//                 n1 = l1.val * i + n1;
//             }
//             System.out.printf("l1: %d, n1: %d\n", l1.val, n1);
//             l1 = l1.next;
//         }
        
//         for (long i = 1; l2 != null; i *= 10) {
//             if (l2.val == 0) {
//                 n2 *= 10;
//             } else {
//                 n2 = l2.val * i + n2;
//             }
//             System.out.printf("i: %d, l2: %d, n2: %d\n", i, l2.val, n2);
//             l2 = l2.next;
//         }
        
//         long sum = n1 + n2;

//         System.out.printf("n1: %d, n2: %d, sum: %d\n", n1, n2, sum);
        
//         if (sum == 0) return new ListNode(0);

//         ListNode dummy = new ListNode(-1);
//         ListNode current = dummy;

    
//         while (sum > 0) {
//             long remainder = sum % 10;
//             sum = sum / 10;
//             System.out.printf("sum: %d, rem: %d\n", sum, remainder);
//             current.next = new ListNode((int)remainder);
//             current = current.next;
//         }

//         return dummy.next;
//     }
// }

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int nextToAdd = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + nextToAdd;
            int remainder = sum % 10;

            if (sum >= 10) {
                current.next = new ListNode(remainder);
                nextToAdd = 1;
            } else {
                current.next = new ListNode(sum);
                nextToAdd = 0;
            }
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + nextToAdd;
            int remainder = sum % 10;
            
            if (sum >= 10) {
                current.next = new ListNode(remainder);
                nextToAdd = 1;
            } else {
                current.next = new ListNode(sum);
                nextToAdd = 0;
            }
            
            current = current.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = l2.val + nextToAdd;
            int remainder = sum % 10;
            
            if (sum >= 10) {
                current.next = new ListNode(remainder);
                nextToAdd = 1;
            } else {
                current.next = new ListNode(sum);
                nextToAdd = 0;
            }
            
            current = current.next;
            l2 = l2.next;
        }

        if (nextToAdd > 0) {
            current.next = new ListNode(nextToAdd);
            current = current.next;
        }
        
        return dummy.next;
    }
}

public class LeetCode2 {
    public static void main(String[] args) {
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Output: [7,0,8]
        // Explanation: 342 + 465 = 807.

        ListNode l3 = new ListNode(2);
        ListNode l2 = new ListNode(4, l3);
        ListNode list1 = new ListNode(3, l2);

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6, l4);
        ListNode list2 = new ListNode(4, l5);

        
        // Input: list1 = [2], list2 = [1]
        // Output: [1,2]
        // ListNode list1 = new ListNode(0);
        // ListNode list2 = new ListNode(0);

        
        // Input: l1 = [2,4,9], l2 = [5,6,4,9]
        // Output: [8,9,8,5]
        // Explanation: 942 + 9465 = 10407

        // ListNode l3 = new ListNode(2);
        // ListNode l2 = new ListNode(4, l3);
        // ListNode list1 = new ListNode(9, l2);

        // ListNode l4 = new ListNode(5);
        // ListNode l5 = new ListNode(6, l4);
        // ListNode l6 = new ListNode(4, l5);
        // ListNode list2 = new ListNode(9, l6);
        
        ListNode head = Solution.addTwoNumbers(list1, list2);
        head.show();
    }
}