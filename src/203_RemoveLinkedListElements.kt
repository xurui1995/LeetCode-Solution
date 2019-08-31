class Solution203 {

    fun test() {

    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return head
        }

        var temp:ListNode? = head
        while (temp != null && temp.`val` == `val`) {
            temp = temp.next
        }

        var newHead: ListNode? = temp ?: return null
        var cur = temp.next
        while (cur != null) {
            if (cur.`val` == `val`) {
                temp?.next = cur.next
                cur = cur.next
            } else {
                temp = cur
                cur = cur.next
            }
        }

        return newHead
    }
}