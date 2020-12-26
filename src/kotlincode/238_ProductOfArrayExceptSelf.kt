package kotlincode

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val ans = Array<Int>(nums.size) { 1 }

        for (i in 1 until nums.size) {
            ans[i] = ans[i - 1] * nums[i - 1]
        }

        var temp = 1
        for (i in nums.size - 2 downTo 0) {
            temp *= nums[i + 1]
            ans[i] *= temp
        }

        return ans.toIntArray()
    }
}