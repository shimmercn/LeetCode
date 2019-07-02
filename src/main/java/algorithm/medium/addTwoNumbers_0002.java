package algorithm.medium;

import algorithm.struct.ListNode;

/**
 * Created by shimmer on 07/02/2019
 */

/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class addTwoNumbers_0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int value = 0, carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                value = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                value = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            } else {
                value = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            curr.next = new ListNode(value);
            curr = curr.next;

        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }
}
