package LeetCode

class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val next = head?.next
        reversePairNode(ListNode(0).also { it.next = head }, head)
        return next ?: head
    }

    private fun reversePairNode(pre: ListNode, head: ListNode?) {
        val next = head?.next ?: return
        pre.next = next
        val temp = next.next
        next.next = head
        head.next = temp
        reversePairNode(head, temp)
    }
}
