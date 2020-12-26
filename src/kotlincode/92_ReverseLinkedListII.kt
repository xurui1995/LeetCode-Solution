package kotlincode

import org.junit.Test

class Solution92 {


    @Test
    fun test() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(7)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        reverseBetween(node1, 1, 7)?.also {
            it.print()
        }

    }


    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (m == n) {
            return head
        }
        if (m == 1) {
            val ans = reverseStep(head, n - m)
            head?.next = ans.second
            return ans.first

        } else {
            var temp = head
            for (i in 1 until m - 1) {
                temp = temp?.next
            }

            val next = temp?.next
            val ans = reverseStep(next, n - m)
            temp?.next = ans.first
            next?.next = ans.second
            return head
        }
    }

    fun reverseStep(head: ListNode?, length: Int): Pair<ListNode?, ListNode?> {
        if (length == 0 || head == null) {
            return Pair(head, head?.next)
        }
        return reverseStep(head.next, length - 1).also {
            head.next?.next = head
            head.next = null
        }
    }
}