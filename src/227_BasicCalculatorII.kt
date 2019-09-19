import org.junit.Test
import java.util.*

class Solution227 {

    @Test
    fun test() {
        println(calculate(" 3+5 / 2 "))
        println(calculate("3+2*2"))
        println(calculate(" 3/2 "))
        println(calculate("0-2147483647"))
        println(calculate("1+1+1"))
        println(calculate("1-1+1"))
    }

    fun calculate(s: String): Int {
        val stack = LinkedList<String>()
        var i = 0
        while (i < s.length) {

            if (s[i] in '0'..'9') {
                var number = s[i].toString()
                i++
                while (i < s.length) {
                    if (s[i] in '0'..'9') {
                        number += s[i]
                        i++
                    } else if (s[i] == ' ') {
                        i++
                    } else {
                        break
                    }
                }
                when (stack.peek()) {
                    "*" -> {
                        stack.pop()
                        stack.push((stack.pop().toInt() * number.toInt()).toString())
                    }
                    "/" -> {
                        stack.pop()
                        stack.push((stack.pop().toInt() / number.toInt()).toString())
                    }
                    else -> {
                        stack.push(number)
                    }
                }
            } else {
                if (s[i] != ' ') {
                    if (s[i] == '+' || s[i] == '-') {
                        if (stack.size >= 3) {
                            stackAdd(stack)
                        }
                    }
                    stack.push(s[i].toString())
                }
                i++
            }
        }
        stackAdd(stack)
        return stack.pop().toInt()
    }

    fun stackAdd(stack: LinkedList<String>) {
        if (stack.size == 3) {
            val n1 = stack.pop()
            val op = stack.pop()
            val n2 = stack.pop()
            if (op == "+") {
                stack.push((n2.toInt() + n1.toInt()).toString())
            } else {
                stack.push((n2.toInt() - n1.toInt()).toString())
            }

        }
    }
}