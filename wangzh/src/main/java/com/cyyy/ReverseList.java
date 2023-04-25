package com.cyyy;

import java.util.List;

/**
 * @author wangzh
 * @date 2023/4/5
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = create(1, 2, 3, 4, 5,6,7,8);
        print(listNode);
        var t = reverseList(listNode);
        print(t);
        System.out.println("---------------");

        listNode = create(1, 2, 3, 4, 5,6,7,8);
        print(listNode);
        t = reverseBetween(listNode,1,3);
        print(t);
        System.out.println("-----------------");

        listNode = create(1, 2, 3, 4, 5,6,7,8);
        print(listNode);
        t = t(listNode,3);
        print(t);
        System.out.println("-----------------");

    }
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null,curr = head,next;
        while (curr != null) {
            next = curr.next; // next
            curr.next = pre;  // 当前节点指向前一个节点
            pre = curr;       // 记录一下前节点
            curr = next;
        }
        return pre;
    }

    /**
     * 反转前节点 p0 指向反转后的pre,手节点指向cur
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head,int m,int n) {
        if (head == null) return null;
        ListNode tmp = new ListNode(0);
        ListNode newHead = tmp;
        ListNode oriPrex = null;
        ListNode curr = null;
        ListNode o = head;
        ListNode p = null;
        for (int i = 1; head != null; i++) {
            curr = head;
            head = head.next;
            if ((m == 1 && i ==1) || i == m-1) {
                oriPrex = curr;
            }
            if (i == m ){
                 p = curr;
            }
            if ( m <= i && i <= n){
                tmp.next = curr.next;
                curr.next = newHead;
                newHead = curr;
            }
            if (i == n){
                if (m != 1){
                    oriPrex.next = newHead;
                }
                p.next = tmp.next;
            }
        }
        if (m == 1) return newHead;
        return o;
    }
    private static ListNode t(ListNode head,int k){
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode newHead = tmp;
        ListNode returnHead = null;
        ListNode preLastNode = null;
        for (int i = 0; head != null; i++) {
            if (i % k == 0 ){ // 新一轮循环
                if (i  / k == 1){
                    returnHead = newHead; // 第一轮循环
                }
                newHead = tmp;
                // if (i / k - 1 = )
                preLastNode = head;
            }
            tmp.next = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp.next;
            if (i / k != 0){
                preLastNode.next = newHead;
            }

        }
        return returnHead;
    }
    private static ListNode create(int...  ints){
        var emptyHead = new ListNode(0);
        var next = emptyHead;
        for (int anInt : ints) {
            var node = new ListNode(anInt);
            next.next = node;
            next = node;
        }
        return emptyHead.next;
    }
    private static  void print(ListNode head){
        while (head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();;
    }
}
