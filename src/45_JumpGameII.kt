import org.junit.Test

class Solution45 {

    @Test
    fun test() {
        print(jump(intArrayOf(2, 3, 1, 1, 4)))
    }

    fun jump(nums: IntArray): Int {
        if (nums.isEmpty()|| nums.size == 1) {
            return 0
        }
        var start = 0
        var end = nums[0]
        var ans = 1
        while (end < nums.size - 1) {
            var long = end
            for (i in start..end) {
                if (i + nums[i] > long) {
                    long = i + nums[i]
                }
            }
            start = end
            end = long
            ans++
        }
        return ans
    }
}