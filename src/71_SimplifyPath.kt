import org.junit.Test
import java.util.*

class Solution71 {

    @Test
    fun test() {

        println(simplifyPath("/a//b////c/d//././/.."))
        println(simplifyPath("/a/../../b/../c//.//"))
        println(simplifyPath("/a/./b/../../c/"))
    }

    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        for (x in path.split('/').filter { it.isNotEmpty() && it != "." }) {
            if (x == ".." && stack.isNotEmpty()) {
                stack.pop()
            } else if (x != ".."){
                stack.push(x)
            }
        }
        return "/" + stack.joinToString(separator = "/")
    }
}