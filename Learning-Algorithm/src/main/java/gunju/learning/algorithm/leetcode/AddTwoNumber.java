package gunju.learning.algorithm.leetcode;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        while (true) {
            ListNode next = new ListNode(0);

            int sum = getSum(current, currentL1, currentL2);

            if (sum >= 10) {
                current.val = sum - 10;
                next.val = 1;
            } else {
                current.val = sum;
            }

            // moveToNext
            if (getNext(currentL1) == null && getNext(currentL2) == null) {
                if (next.val == 1) {
                    current.next = next;
                }
                break;
            } else {
                current.next = next;
                current = current.next;
                currentL1 = getNext(currentL1);
                currentL2 = getNext(currentL2);
            }
        }
        return result;
    }

    private ListNode getNext(ListNode node) {
        if (node != null) {
            return node.next;
        }
        return null;
    }

    private int getSum(ListNode current, ListNode currentL1, ListNode currentL2) {
        return current.val + getValue(currentL1) + getValue(currentL2);
    }

    private int getValue(ListNode node) {
        if (node != null) {
            return node.val;
        }
        return 0;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
