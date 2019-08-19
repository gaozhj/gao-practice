package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author gaozijian
 * @date 2019/8/16 9:38
 */


/**
 * test4
 * 6. 从尾到头打印链表
 */
public class test4 {
    class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        /**
         * 使用递归
         *
         * @param listNode
         * @return
         */
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> ret = new ArrayList<>();
            if (listNode != null) {
                ret.addAll(printListFromTailToHead(listNode.next));
                ret.add(listNode.val);
            }
            return ret;
        }

        /**
         * 使用头插法
         *
         * @param listNode
         * @return
         */
        public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
            ListNode head = new ListNode(-1);
            while (listNode != null) {
                ListNode memo = listNode.next;
                listNode.next = head.next;
                head.next = listNode;
                listNode = memo;

            }
            ArrayList<Integer> ret = new ArrayList<>();
            head = head.next;
            while (head != null) {
                ret.add(head.val);
                head = head.next;
            }
            return ret;
        }

        /**
         * 使用栈
         */
        public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.add(listNode.val);
                listNode = listNode.next;
            }
            ArrayList<Integer> ret = new ArrayList<>();
            while (!stack.isEmpty()) {
                ret.add(stack.pop());
            }
            return ret;
        }
    }

    public void run() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(listNode1.printListFromTailToHead2(listNode1));
    }

}