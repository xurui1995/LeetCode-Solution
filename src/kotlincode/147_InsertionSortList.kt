package kotlincode

import org.junit.Test

class Solution147 {

    @Test
    fun test() {
        val node1 = ListNode(4)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(1)

        node1.next = node2
        node2.next = node3
        node3.next = node4

        val node = insertionSortList(node1)
        node?.print()
    }

    fun insertionSortList(head: ListNode?): ListNode? {

        val dummpy = ListNode(Int.MIN_VALUE)
        var end = dummpy
        var temp = head
        while (temp != null) {
            if (temp.`val` >= end.`val`) {
                end.next = temp
                end = temp
                temp = temp.next
                end.next = null

            } else {
                val newBig = temp
                temp = temp.next
                var newNode = dummpy
                while (true) {
                    if (newNode.next?.`val`!! > newBig.`val`) {
                        break
                    }
                    newNode = newNode.next!!
                }
                newBig.next = newNode.next
                newNode.next = newBig
            }
        }

        return dummpy.next
    }
}