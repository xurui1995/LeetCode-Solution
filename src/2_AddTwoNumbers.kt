import org.junit.Test

class Solution2 {

    @Test
    fun test() {
        val head1 = ListNode(2)
        head1.next = ListNode(4)
        head1.next?.next = ListNode(3)


        val head2 = ListNode(5)
        head2.next = ListNode(6)
        head2.next?.next = ListNode(4)

        addTwoNumbers(head1, head2)?.print()
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        }
        if (l2 == null) {
            return l1
        }
        var ans: ListNode? = ListNode(-1)
        val result = ans

        var l1_temp = l1
        var l2_temp = l2
        var temp = 0
        while (l1_temp != null || l2_temp != null) {
            val i = l1_temp?.`val` ?: 0
            val j = l2_temp?.`val` ?: 0
            val r = (i + j + temp)
            temp = r / 10
            ans?.next = ListNode(r % 10)
            ans = ans?.next
            l1_temp = l1_temp?.next
            l2_temp = l2_temp?.next
        }

        if (temp != 0) {
            ans?.next = ListNode(1)
        }

        return result?.next

    }


}