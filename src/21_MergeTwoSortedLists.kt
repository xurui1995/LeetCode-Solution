package LeetCode

class Solution21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return null
        }
        if (l1 == null) return l2
        if (l2 == null) return l1

        var preHead = ListNode(0)
        var tempNode = preHead
        var l1Node = l1
        var l2Node = l2
        while (l1Node != null && l2Node != null) {
            when {
                l1Node.`val` - l2Node.`val` > 0 -> {
                    tempNode.next = l2Node
                    tempNode = tempNode.next!!
                    l2Node = l2Node.next
                }
                l1Node.`val` - l2Node.`val` < 0 -> {
                    tempNode.next = l1Node
                    tempNode = tempNode.next!!
                    l1Node = l1Node.next

                }
                else -> {
                    tempNode.next = l2Node
                    tempNode = tempNode.next!!
                    l2Node = l2Node.next

                    tempNode.next = l1Node
                    tempNode = tempNode.next!!
                    l1Node = l1Node.next
                }
            }
        }

        while (l1Node != null) {
            tempNode.next = l1Node
            tempNode = tempNode.next!!
            l1Node = l1Node.next
        }

        while (l2Node != null) {
            tempNode.next = l2Node
            tempNode = tempNode.next!!
            l2Node = l2Node.next
        }

        return preHead.next
    }

}
