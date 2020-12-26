import kotlincode.ListNode

class Solution19 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null || (head.next == null && n >= 1)) {
            return null
        }
        var index1 = head
        var index2 = head
        for (i in 0 until n) {
            index2 = index2?.next
            if (index2 == null) {
                return head.next
            }
        }

        while (index2?.next != null) {
            index2 = index2.next
            index1 = index1?.next
        }
        index1?.next = index1?.next?.next
        return head
    }
}
