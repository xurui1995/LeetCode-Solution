import org.junit.Test
import java.util.*

class Solution47 {

    @Test
    fun test() {

        permuteUnique(intArrayOf(1,1,2,3)).also {
            for ( i in it) {
                println(i.joinToString { it.toString() })
            }
        }
    }

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        val visited = Array<Boolean>(nums.size){false}
        val stack = Stack<Int>()
        permuteUniqueByStep(nums.also { it.sort() }, stack , ans, visited)
        return ans
    }

    fun permuteUniqueByStep(nums: IntArray, stack: Stack<Int>, ans: ArrayList<List<Int>>, visited: Array<Boolean>) {

        if (stack.size ==  nums.size) {
            ans.add(ArrayList(stack))
            return
        }

        for (i in 0 until nums.size) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) {
                    continue
                }
                visited[i] = true
                stack.push(nums[i])

                permuteUniqueByStep(nums, stack, ans, visited)

                stack.pop()
                visited[i] = false
            }
        }
    }
}