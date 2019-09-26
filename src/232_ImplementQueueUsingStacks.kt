import java.util.*

class MyQueue {

    /** Initialize your data structure here. */

    val pushStack = LinkedList<Int>()
    val popStack = LinkedList<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        pushStack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(pushStack.pop())
            }
        }
        return popStack.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.push(popStack.pop())
            }
        }
        return popStack.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }

}