package leetcode;

import leetcode.OddEvenLinkedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OddEvenLinkedListTest {

    @Test
    void oddEvenList() {
        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        OddEvenLinkedList solution = new OddEvenLinkedList();

        ListNode result = solution.oddEvenList(head);
        assertThat(result.val).isEqualTo(1);
        ListNode next = result.next;
        assertThat(next.val).isEqualTo(3);
        next = next.next;
        assertThat(next.val).isEqualTo(5);
        next = next.next;
        assertThat(next.val).isEqualTo(2);
        next = next.next;
        assertThat(next.val).isEqualTo(4);
    }
}