import org.junit.Test
import java.util.*

class MyStack {


    @Test
    fun test() {
        val stack = MyStack()

        stack.push(1)
        stack.push(2)
        println(stack.top()) // returns 2
        println(stack.pop())   // returns 2
        println(stack.empty()) // returns false
    }

    /** Initialize your data structure here. */
    var pushQueue = LinkedList<Int>()
    var popQueue = LinkedList<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        pushQueue.offer(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        while (pushQueue.size != 1) {
            popQueue.offer(pushQueue.poll())
        }
        val temp = pushQueue
        pushQueue = popQueue
        popQueue = temp
        return popQueue.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        while (pushQueue.size != 1) {
            popQueue.offer(pushQueue.poll())
        }
        val ans = pushQueue.poll()
        popQueue.offer(ans)
        val temp = pushQueue
        pushQueue = popQueue
        popQueue = temp
        return ans
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return pushQueue.isEmpty()
    }

}