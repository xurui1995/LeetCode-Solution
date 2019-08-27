import org.junit.Test
import java.util.*

class Solution150 {


    @Test
    fun test() {
        println(evalRPN(arrayOf("2", "1", "+", "3", "*")))
        println(evalRPN(arrayOf("4", "13", "5", "/", "+")))
        println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = LinkedList<String>()
        var canAdd = false
        for (i in tokens.lastIndex downTo 0) {
            if (isOp(tokens[i])) {
                stack.push(tokens[i])
                canAdd = false
            } else {
                if (canAdd) {
                    var value = tokens[i].toInt()
                    while (true) {
                        value = compute(value, stack.pop(), stack.pop())
                        if (stack.isEmpty()) {
                            stack.push(value.toString())
                            break
                        }
                        if (isOp(stack.peek())) {
                            stack.push(value.toString())
                            break
                        }
                    }
                } else {
                    stack.push(tokens[i])
                    canAdd = true
                }
            }
        }
        return stack.pop().toInt()
    }

    fun isOp(str: String) = str in listOf("+", "-", "*", "/")

    fun compute(int1: Int, str2: String, op: String): Int {
        return when (op) {
            "+" -> int1 + str2.toInt()
            "-" -> int1 - str2.toInt()
            "*" -> int1 * str2.toInt()
            "/" -> int1 / str2.toInt()
            else -> {
                0
            }
        }
    }
}