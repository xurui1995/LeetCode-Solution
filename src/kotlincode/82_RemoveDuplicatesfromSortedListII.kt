package kotlincode

import org.junit.Test

class Solution82 {


    @Test
    fun test() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(3)
        val node5 = ListNode(4)
        val node6 = ListNode(4)
        val node7 = ListNode(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        deleteDuplicates(node1)?.also {
            it.print()
        }

    }


    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var temp =  head.next
        return if (temp?.`val` == head.`val`) {
            while (temp?.`val` == head.`val`) {
                temp = temp.next
            }
            if (temp == null) {
                temp
            } else {
                deleteDuplicates(temp)
            }
        } else {
            head.next = deleteDuplicates(head.next)
            head
        }
    }
}