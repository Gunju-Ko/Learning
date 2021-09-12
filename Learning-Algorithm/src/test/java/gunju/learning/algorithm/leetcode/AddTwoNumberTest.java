package gunju.learning.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import gunju.learning.algorithm.leetcode.AddTwoNumber.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class AddTwoNumberTest {

    @Test
    void addTwoNumbers_example1() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);

        assertEquals(result.val, 7);
        assertEquals(result.next.val, 0);
        assertEquals(result.next.next.val, 8);
        assertNull(result.next.next.next);
    }

    @Test
    void addTwoNumbers_example2() {
        ListNode l1 = new ListNode(0, null);
        ListNode l2 = new ListNode(0, null);

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);

        assertEquals(result.val, 0);
        assertNull(result.next);
    }

    @Test
    void addTwoNumbers_example3() {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(l1, l2);

        assertEquals(result.val, 8);
        assertEquals(result.next.val, 9);
        assertEquals(result.next.next.val, 9);
        assertEquals(result.next.next.next.val, 9);
        assertEquals(result.next.next.next.next.val, 0);
        assertEquals(result.next.next.next.next.next.val, 0);
        assertEquals(result.next.next.next.next.next.next.val, 0);
        assertEquals(result.next.next.next.next.next.next.next.val, 1);
    }
}