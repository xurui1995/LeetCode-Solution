import org.junit.Test

class Solution26 {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var length = 1
        for (num in nums) {
            if (num != nums[length - 1]) {
                nums[length] = num
                length++
            }
        }
        return length
    }

    @Test
    fun test() {
        val list = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4)
        println(removeDuplicates(list))
        println(list.toList())
    }
}