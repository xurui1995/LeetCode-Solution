package LeetCode

import java.util.*

class Solution20 {
    fun isVaild(s: String): Boolean {

        val stack = Stack<Char>()
        s.forEach {
            when (it) {
                '(','{','[' -> stack.push(it)
                else -> {
                    if (stack.empty()) {
                        return false
                    }
                    when(it) {
                        '}' -> {
                            if (stack.pop() != '{') {
                                return false
                            }
                        }

                        ')' -> {
                            if (stack.pop() != '(') {
                                return false
                            }
                        }

                        ']' -> {
                            if (stack.pop() != '[') {
                                return false
                            }
                        }
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}