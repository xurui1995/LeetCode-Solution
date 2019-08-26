import org.junit.Test

class Solution179 {


    @Test
    fun test() {
        println(largestNumber(intArrayOf(10, 2)))
        println(largestNumber(intArrayOf(3, 30, 34, 5, 9)))
    }

    fun largestNumber(nums: IntArray): String {
        if (nums.all { it == 0 }) {
            return "0"
        }
        var max = 0
        var maxIndex = 0
        for (i in 0 until nums.lastIndex) {
            max = nums[i]
            maxIndex = i
            for (j in i + 1..nums.lastIndex) {
                if (nums[j].toString() + max.toString() > max.toString() + nums[j].toString()) {
                    max = nums[j]
                    maxIndex = j
                }
            }

            nums[maxIndex] = nums[i]
            nums[i] = max
        }
        return nums.joinToString(separator = "") { it.toString() }
    }


}