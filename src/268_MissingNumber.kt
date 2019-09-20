import org.junit.Test

class Solution268 {

    @Test
    fun test() {
       // println(missingNumber(intArrayOf(3, 0, 1)))
        println(missingNumber(intArrayOf(9, 4, 2, 3, 0, 1)))
    }

    fun missingNumber(nums: IntArray): Int {
        var i = 0
        while (i <= nums.lastIndex) {
            if (nums[i] != i && nums[i] <= nums.lastIndex && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i])
            } else {
                i++
            }
        }
        println(nums.toList())
        for (j in nums.indices) {
            if (nums[j] != j) {
                return j
            }
        }

        return nums.size
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}