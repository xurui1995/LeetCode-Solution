import org.junit.Test

class Solution57 {

    @Test
    fun test() {
        val intervals = arrayOf(intArrayOf(3, 7), intArrayOf(10, 13), intArrayOf(16,17))
        val newIerval = intArrayOf(12, 16)
        print(insert(intervals, newIerval).joinToString { it.joinToString(prefix = "[", postfix = "]", separator = ",") { it.toString() } })

    }

    fun insert(intervals: Array<IntArray>, newIerval: IntArray): Array<IntArray> {
        if (newIerval.isEmpty() || intervals.contains(newIerval)) {
            return intervals
        }
        val ans = mutableListOf<IntArray>()

        var index1 = 0
        while (index1 <= intervals.size) {
            if (index1 == intervals.size) {
                ans.add(newIerval)
                break
            }
            if (intervals[index1][0] <= newIerval[0]) {
                if (newIerval[0] > intervals[index1][1]) {
                    ans.add(intervals[index1])
                    index1++
                } else if (intervals[index1][1] >= newIerval[1]) {
                    break
                } else {
                    newIerval[0] = intervals[index1][0]
                    index1++
                }
            } else {
                if (newIerval[1] < intervals[index1][0]) {
                    ans.add(newIerval)
                    break
                } else if (intervals[index1][1] >= newIerval[1]) {
                    newIerval[1] = intervals[index1][1]
                    index1++
                } else {
                    index1++
                }
            }
        }

        while (index1 <= intervals.size - 1) {
            ans.add(intervals[index1])
            index1++
        }

        return ans.toTypedArray()
    }
}