import org.junit.Test

class Solution56 {

    @Test
    fun test() {
        println(merge(arrayOf(intArrayOf(1,4), intArrayOf(2,3)))

                .joinToString { it.joinToString(prefix = "[",separator = ",", postfix = "]") })
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return emptyArray()
        }
        intervals.sortBy { it[0] }
        var start = intervals[0][0]
        var end = intervals[0][1]
        var ans = mutableListOf<IntArray>()
        for (i in 1 until  intervals.size) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end)
            } else {
                ans.add(intArrayOf(start, end))
                start = intervals[i][0]
                end = intervals[i][1]
            }
        }
        ans.add(intArrayOf(start, end))
        return ans.toTypedArray()
    }
}