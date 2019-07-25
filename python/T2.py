class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        p = l1
        q = l2

        pv = 0
        qv = 0
        carry = 0
        result_node = ListNode(0)
        now_node = result_node

        while (p != None or q != None):
            if p != None:
                pv = p.val
                p = p.next
            if q != None:
                qv = q.val
                q = q.next

            rv = pv + qv + carry
            if rv > 9:
                carry = 1
                rv = rv - 10
            else:
                carry = 0

            node = ListNode(rv)
            now_node.next = node
            now_node = node
            pv = 0
            qv = 0
        if carry:
            node = ListNode(carry)
            now_node.next = node

        return result_node.next


def print_node(node: ListNode):
    while (node != None):
        print(node.val)
        node = node.next


if __name__ == '__main__':
    # node1 = ListNode(2)
    # node2 = ListNode(4)
    # node3 = ListNode(3)
    # node1.next = node2
    # node2.next = node3
    #
    # node4 = ListNode(5)
    # node5 = ListNode(6)
    # node6 = ListNode(4)
    # node4.next = node5
    # node5.next = node6

    node1 = ListNode(5)
    node2 = ListNode(5)

    s = Solution()
    result = s.addTwoNumbers(node1, node2)

    print_node(result)
