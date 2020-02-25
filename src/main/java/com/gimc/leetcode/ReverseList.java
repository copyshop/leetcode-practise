package com.gimc.leetcode;

/**
 * author: heyin
 * date: 2019-05-23
 * desc: 翻转链表:https://leetcode-cn.com/articles/reverse-linked-list/
 */
public class ReverseList {

    public static void main(String[] args) {
        new ReverseList().exe();
    }

    /**
     * 测试使用
     */
    public void exe() {
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode result = reverseList2(listNode1);
        System.out.println(result);
    }

    public ListNode reverseList1(ListNode head) {
        ListNode result = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = result;
            result = curr;
            curr = nextTemp;
        }
        return result;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}

