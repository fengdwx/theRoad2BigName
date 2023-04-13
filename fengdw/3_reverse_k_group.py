class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        # 找到每次翻转的尾部
        tail = head
        # 遍历k次到尾部
        for i in range(0, k):
            # 如果不足k到了链表尾，直接返回，不翻转
            if tail is None:
                return head
            tail = tail.next
        # 翻转时需要的前序和当前节点
        pre = None
        cur = head
        # 在到达当前段尾节点前
        while cur != tail:
            # 翻转
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        # 当前尾指向下一段要翻转的链表
        head.next = self.reverseKGroup(tail, k)
        return pre
