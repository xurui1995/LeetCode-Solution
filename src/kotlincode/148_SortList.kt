package kotlincode

import org.junit.Test

class Solution148 {

    @Test
    fun test() {
        val node1 = ListNode(-1)
        val node2 = ListNode(5)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(0)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        sortList(node1)?.print()
    }

    fun sortList(head: ListNode?): ListNode? {

        return when {
            head == null -> null
            head.next == null -> head
            else -> {
                val key = head.`val`

                var leftHead: ListNode? = null
                var rightHead: ListNode? = null

                var leftTemp: ListNode? = null
                var rightTemp: ListNode? = null

                var temp = head.next

                while (temp != null) {
                    if (temp.`val` <= key) {
                        if (leftTemp == null) {
                            leftHead = temp
                            leftTemp = temp
                        } else {
                            leftTemp.next = temp
                            leftTemp = temp
                        }

                        temp = temp.next
                        leftTemp.next = null
                    } else {
                        if (rightTemp == null) {
                            rightHead = temp
                            rightTemp = temp
                        } else {
                            rightTemp.next = temp
                            rightTemp = temp
                        }

                        temp = temp.next
                        rightTemp.next = null
                    }
                }

                val left = sortList(leftHead)

                val right = sortList(rightHead)

                if (left != null) {
                    temp = left
                    while (temp?.next != null) {
                        temp = temp.next
                    }
                    temp?.next = head
                }

                head.next = right

                return left ?: head
            }
        }
    }
}