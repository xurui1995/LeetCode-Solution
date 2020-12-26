package kotlincode

fun ListNode.print() {
    var temp: ListNode? = this
    while (temp != null) {
        print(temp.`val`)
        temp = temp.next
    }
}