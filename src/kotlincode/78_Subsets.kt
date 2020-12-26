package kotlincode

import org.junit.Test

class Solution78 {

    @Test
    fun test() {
        val nums = intArrayOf(1, 2, 3, 4)
        val result = subsets(nums)
        println(
                result.joinToString(separator = "\n") { array -> array.joinToString { it.toString() }
                }
        )
    }


    fun subsets(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        subsetsStep(nums, 0, ans, temp = mutableListOf())
        if (nums.isNotEmpty()) {
            ans.add(emptyList())
        }
        return ans
    }

    fun subsetsStep(nums: IntArray, index: Int, ans: MutableList<List<Int>>, temp: MutableList<Int>) {

        if (index == nums.size - 1) {
            temp.add(nums[index])
            ans.add(ArrayList(temp))
            temp.remove(nums[index])
            return
        }

        temp.add(nums[index])
        ans.add(ArrayList(temp))

        subsetsStep(nums, index  + 1,ans, temp)
        temp.remove(nums[index])
        subsetsStep(nums, index  + 1,ans, temp)
    }
}