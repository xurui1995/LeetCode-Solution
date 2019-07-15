import org.junit.Test

class Solution80 {


    @Test
    fun test() {
        val  nums = intArrayOf(0,0,1,1,1,1,2,3,3)
        println(removeDuplicates(nums))
        println(nums.joinToString { it.toString() })

    }

    fun removeDuplicates(nums: IntArray): Int {

        var counts = 0
        for (i in 0 until  nums.size ) {
            if (i< 2) {
                nums[counts++] = nums[i]
            } else {
                if (nums[i] > nums[counts-2]) {
                    nums[counts++] = nums[i]
                }
            }
        }
        return counts
    }
}