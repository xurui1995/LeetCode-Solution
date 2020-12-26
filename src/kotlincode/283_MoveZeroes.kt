package kotlincode

class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var k = 0
        fun swap(i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(k,i)
                    k++
                } else {
                    k++
                }
            }
        }
    }
}