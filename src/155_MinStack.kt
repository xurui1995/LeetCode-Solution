import java.util.*

class MinStack() {
    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()

    fun push(x: Int) {
        stack1.push(x)
        when {
            stack2.empty() || stack2.peek() > x -> {stack2.push(x)}
            else -> stack2.push(stack2.peek())
        }

    }

    fun pop() {
        stack1.pop()
        stack2.pop()
    }

    fun top(): Int {
        return stack1.peek()
    }

    fun getMin(): Int {
        return stack2.peek()
    }
}