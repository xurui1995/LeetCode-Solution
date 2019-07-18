import org.junit.Test

class Solution86 {

    @Test
    fun test() {
        val node1 = ListNode(1)
        val node2 = ListNode(4)
        val node3 = ListNode(3)
        val node4 = ListNode(2)
        val node5 = ListNode(5)
        val node6 = ListNode(2)


        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6

        partition(node1, 3)?.also {
            it.print()
        }

        partition(null, 3)?.also {
            it.print()
        }
    }

    fun partition(head: ListNode?, x: Int): ListNode? {
        val leftHead: ListNode?  = ListNode(0)
        var leftTemp = leftHead
        var rightHead: ListNode? = ListNode(0)
        var rightTemp = rightHead

        var temp = head

        while (temp != null) {
          if (temp.`val` < x ) {
              leftTemp?.next = temp
              leftTemp = temp
              temp = temp.next
              leftTemp.next = null
          } else {
              rightTemp?.next = temp
              rightTemp = temp
              temp = temp.next
              rightTemp.next = null
          }

        }
        rightHead = rightHead?.next
        leftTemp?.next = rightHead

        return leftHead?.next
    }
}