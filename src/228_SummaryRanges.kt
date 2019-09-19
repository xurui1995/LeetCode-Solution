import org.junit.Test

class Solution228 {

    @Test
    fun test() {
        println(summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)))
        println(summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)))
    }

    fun summaryRanges(nums: IntArray): List<String> {
        val ans = mutableListOf<String>()
        if (nums.isEmpty()) {
            return ans
        }
        var start = nums[0]
        var end = nums[0]
        for (i in 1..nums.lastIndex) {
            if (nums[i] == end + 1) {
                end++
            } else {
                if (start == end) {
                    ans.add(start.toString())
                } else {
                    ans.add("$start->$end")
                }
                start = nums[i]
                end = nums[i]
            }
        }
        if (start == end) {
            ans.add(start.toString())
        } else {
            ans.add("$start->$end")
        }
        return ans
    }
}