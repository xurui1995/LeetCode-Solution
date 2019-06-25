import org.junit.Test
import java.util.*

class Solution31 {

    @Test
    fun test() {
        val nums1 = intArrayOf(1, 3, 2)
        val nums2 = intArrayOf(3, 2, 1)
        val nums3 = intArrayOf(1, 1, 5)

        nextPermutation(nums1)
        nextPermutation(nums2)
        nextPermutation(nums3)

        println(nums1.joinToString { it.toString() })
        println(nums2.joinToString { it.toString() })
        println(nums3.joinToString { it.toString() })
    }

    fun nextPermutation(nums: IntArray): Unit {
        var index = nums.size - 2
        while (index >= 0) {
            var minAnsIndex = index
            var temp = Int.MAX_VALUE
            for (i in index + 1 until nums.size) {
                if (nums[i] > nums[index] && nums[i] < temp) {
                    minAnsIndex = i
                    temp = nums[i]
                }
            }

            if (minAnsIndex != index) {
                val temp = nums[minAnsIndex]
                nums[minAnsIndex] = nums[index]
                nums[index] = temp
                Arrays.sort(nums, index + 1, nums.size)
                return
            }
            index--
        }

        return nums.sort()
    }
}