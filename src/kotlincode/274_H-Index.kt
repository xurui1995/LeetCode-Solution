package kotlincode

import org.junit.Test

class Solution274 {

    @Test
    fun test() {
        println(hIndex(intArrayOf(3, 0, 6, 1, 5)))
    }

    fun hIndex(citations: IntArray): Int {
        val counts = IntArray(citations.size + 1)
        for (citation in citations) {
            if (citation > citations.size) {
                counts[counts.lastIndex]++
            } else {
                counts[citation]++
            }
        }

        var sum = 0
        for (i in counts.lastIndex downTo 0) {
            sum += counts[i]
            if (sum >= i) {
                return i
            }

        }
        return 0
    }

}