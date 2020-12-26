import kotlincode.ListNode
import kotlincode.print
import org.junit.Test

class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var temp = head
        for (i in 1..k) {
            if (temp == null) {
                return head
            }
            temp = temp.next
        }
        val node = reverseKGroup(temp, k)
        val newHead = reverseNode(head, k)
        head?.next = node
        return newHead

    }


    fun reverseNode(head: ListNode?, k: Int): ListNode? {

        var pre = head
        var cur = head?.next
        head?.next = null
        var temp = head

        for (i in 1 until k) {
            temp = cur?.next
            cur?.next = pre
            pre = cur
            cur = temp
        }
        return pre

    }


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

        reverseKGroup(node1, 3)?.print()


    }
}