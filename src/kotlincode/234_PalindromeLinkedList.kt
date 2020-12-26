package kotlincode

import org.junit.Test

class Solution234 {

    @Test
    fun test() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(2)
        val node4 = ListNode(1)
        node1.next = node2
        node2.next = node3
        node3.next = node4

        println(isPalindrome(node1))
    }

    fun isPalindrome(head: ListNode?): Boolean {
        var count = 0
        var newHead = head
        while (newHead != null) {
            count++
            newHead = newHead.next
        }
        if (count <= 1) {
            return true
        }

        newHead = head
        for (i in 1 until count / 2) {
            newHead = newHead?.next
        }

        var pre = newHead
        var cur = newHead?.next
        var next = cur?.next
        while (cur != null) {
            cur.next = pre
            pre = cur
            cur = next
            next = cur?.next
        }

        newHead = head
        for (i in 1..count / 2) {
            if (pre?.`val` != newHead?.`val`) {
                return false
            }
            pre = pre?.next
            newHead = newHead?.next
        }
        return true
    }

}