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

class Leetcode24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        var dummy = new ListNode(-1, head);
        var current = head;
        var prev = dummy;

        while (current != null) {
            // var tmp = current.val;
            // current.val = current.next.val;
            // current.next.val = tmp;
            
            // current = current.next.next;

            if (current.next == null) {
                break;
            }

            var nn = current.next.next;

            prev.next = current.next;
            prev.next.next = current;
            prev.next.next.next = nn;
            
            prev = current;
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n1.show();

        var head = Leetcode24.swapPairs(n1);
        System.out.println();
        head.show();
    }
}