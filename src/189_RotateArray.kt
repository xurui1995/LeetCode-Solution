import org.junit.Test

class Solution189 {

    @Test
    fun test() {
        val array = intArrayOf(1,2,3,4,5,6,7)
        rotate(array,8)
        println(array.toList())
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        val kk = k % nums.size
        if (kk != 0) {
            reverse(nums,0, nums.lastIndex - kk)
            reverse(nums,nums.lastIndex - kk + 1, nums.lastIndex)
            reverse(nums, 0, nums.lastIndex)
        }
    }

    fun reverse(nums: IntArray, start: Int, end:Int) {
        var newStart = start
        var newEnd = end
        while (newStart < newEnd) {
           val temp = nums[newStart]
           nums[newStart] = nums[newEnd]
            nums[newEnd] = temp
            newStart ++
            newEnd --
        }
    }
}