package com.cyyy;

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
        ListNode listNode = create(1, 2, 3, 4, 5,13,524,52);
        print(listNode);
        System.out.println();
        var t = ReverseList(listNode);
        print(t);
    }
    public static ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode tmp = new ListNode(0);
        ListNode newHead = tmp;
        ListNode oriHead = head;
        while (head != null) {
            tmp.next = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp.next;
        }
        oriHead.next = null;
        return newHead;
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
    }
}
