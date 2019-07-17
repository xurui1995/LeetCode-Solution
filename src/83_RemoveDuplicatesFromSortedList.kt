import org.junit.Test

class Solution83 {

    @Test
    fun test() {
        val node1 = ListNode(1)
        val node2 = ListNode(1)
        val node3 = ListNode(2)
        val node4 = ListNode(3)
        val node5 = ListNode(3)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val node = deleteDuplicates(node1)?.also {
            it.print()
        }
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var temp = head
        while (temp != null) {
            if (temp.next != null && temp.`val` == temp.next?.`val`) {
                temp.next = temp.next?.next
            } else {
                temp = temp.next
            }
        }
        return head
    }
}