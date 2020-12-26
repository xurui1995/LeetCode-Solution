package kotlincode

import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class Solution90 {

    @Test
    fun test() {
        println(subsetsWithDup(intArrayOf(1, 1, 2, 2)).joinToString(separator = "\n") { it.joinToString { i -> i.toString() } })
    }


    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (nums.isNotEmpty()) {
            ans.add(listOf())
        }
        nums.sort()
        subsetsWithDup(nums, 0, ans)
        return ans
    }

    fun subsetsWithDup(nums: IntArray, index: Int, ans:MutableList<List<Int>>,  tempStack: LinkedList<Int> = LinkedList()) {

        if (index > nums.size  -1) {
            return
        }

        if (index == nums.size - 1) {
            tempStack.push(nums[index])
            ans.add(ArrayList(tempStack))
            tempStack.pop()
            return
        }

        if (index + 1 <= nums.size -1 && nums[index] == nums[index +1]) {
            var tempIndex = index+1
            while (tempIndex <= nums.size  -1 && nums[tempIndex] == nums[index])  {
                tempIndex ++
            }
            for (i in 1  .. tempIndex-index) {
                tempStack.push(nums[index])
            }

            while (tempStack.peek() == nums[index]) {
                ans.add(ArrayList(tempStack))
                subsetsWithDup(nums, tempIndex, ans, tempStack)
                tempStack.pop()
            }

            subsetsWithDup(nums, tempIndex, ans, tempStack)


        } else {
            tempStack.push(nums[index])
            ans.add(ArrayList(tempStack))
            subsetsWithDup(nums, index+1, ans, tempStack)

            tempStack.pop()
            subsetsWithDup(nums, index+1, ans, tempStack)
        }
    }
}