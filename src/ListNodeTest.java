/**
* Created by donfan on 13-01-2017.
*/

import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}

public class ListNodeTest {
    ListNode head,head1;

    public ListNodeTest(int n) {
        head = randomGenLists(n);
        head1 = randomGenLists(n);
    }

    private ListNode randomGenLists(int n) {
        Random rn = new Random();
        ListNode curr = null;
        ListNode head = null;
        for (int i = 0; i < n; i++) {
            ListNode nd = new ListNode(0 + rn.nextInt(30 - 0 + 1));
            if (curr == null) {
                curr = nd;
                head = curr;
            } else {
                curr.next = nd;
                curr = curr.next;
            }
        }
        return head;
    }
    private void printListNode(ListNode head) {
        ListNode curr;
        curr = head;
        while(curr != null) {
            System.out.print(curr.val + "\t");
            curr = curr.next;
        }
        System.out.println();
    }

    private ListNode insertionSort(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode curr = head;
        ListNode pre,next;
        while (curr != null) {
            pre = helper;
            while(pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return helper.next;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        ListNode curr = helper;
        ListNode next1,next2;

        while(l1 != null) {
            if(l2 != null) {
                if (l1.val < l2.val) {
                    next1 = l1.next;
                    curr.next = l1;
                    l1.next = null;
                    l1 = next1;
                } else {
                    next2 = l2.next;
                    curr.next = l2;
                    l2.next = null;
                    l2 = next2;
                }
            } else {
                curr.next = l1;
                break;
            }
            curr = curr.next;
        }

        if (l2 != null)
            curr.next = l2;
        return helper.next;
    }

    public void simulateTest() {
        ListNode res = null;
        printListNode(head);
        printListNode(head1);
        head = insertionSort(head);
        head1 = insertionSort(head1);
        res = mergeLists(head, head1);
        printListNode(res);
    }
}
