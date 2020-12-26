package kotlincode

import org.junit.Test

class Solution206 {

    @Test
    fun test() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        reverseList(node1)?.print()
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        if (head.next == null) {
            return head
        }
        val newHead = reverseList(head.next)
        head.next?.next = head
        head.next = null
        return newHead
    }

}