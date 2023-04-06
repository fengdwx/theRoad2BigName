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
        ListNode listNode = create(1, 2, 3, 4, 5,6,7,8);
        print(listNode);
        ListNode t=null;
//        System.out.println();
//        var t = reverseBetween(listNode,3,5);
//        print(t);
//        System.out.println();
//        t = reverseBetween(listNode,1,3);
//        print(t);
        System.out.println();
        t = reverseBetween(listNode,1,8);
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
