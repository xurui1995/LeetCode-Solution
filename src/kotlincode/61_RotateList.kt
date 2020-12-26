package kotlincode

import org.junit.Test

class Solution61 {

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

        rotateRight(node1, 2)?.print()
    }


    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }

        var temp = head
        var length = 1
        while (temp?.next != null) {
            length++
            temp = temp.next
        }

        if (length == 1 || k == 0 || k % length == 0) {
            return head
        }

        var kTemp = head
        for (i in 1 until length - (k % length)) {
            kTemp = kTemp?.next
        }

        val newHead = kTemp?.next
        kTemp?.next = null

        temp?.next = head

        return newHead
    }

}