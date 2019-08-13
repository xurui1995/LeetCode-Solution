import org.junit.Test
import java.util.*

class Solution946 {

    @Test
    fun test() {
        println(validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
        println(validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
    }

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = LinkedList<Int>()
        var pushIndex = 0
        for (x in popped) {
            if (stack.peek() == x) {
                stack.pop()
            } else {
                while (pushIndex <= pushed.lastIndex && pushed[pushIndex] != x) {
                    stack.push(pushed[pushIndex++])
                }
                if (pushIndex > pushed.lastIndex) {
                    return false
                } else {
                    pushIndex++
                }
            }
        }
        return true
    }
}