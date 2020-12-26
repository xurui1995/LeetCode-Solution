package kotlincode

import org.junit.Test

class Solution275 {

    @Test
    fun test() {
        println(hIndex(intArrayOf(0, 1, 3, 5, 6)))
        println(hIndex(intArrayOf(0, 5, 7, 8, 9)))
    }


    fun hIndex(citations: IntArray): Int {
        if (citations.isEmpty()) {
            return 0
        }
        var left = 0
        var right = citations.lastIndex
        var ans = 0
        while (left < right) {
            val mid = left + (right - left) / 2
            if (citations.lastIndex - mid + 1 == citations[mid]) {
                return citations[mid]
            } else if (citations[mid] > citations.lastIndex - mid + 1) {
                ans = Math.max(ans, citations.lastIndex - mid + 1)
                right = mid - 1
            } else {
                ans = Math.max(ans, citations[mid])
                left = mid + 1
            }
        }
        return Math.max(ans, Math.min(citations.lastIndex - left + 1, citations[left]))
    }
}