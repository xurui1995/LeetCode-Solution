import org.junit.Test

class Solution89 {

    @Test
    fun test() {
        println(grayCode(3))
    }

    fun grayCode(n: Int):List<Int> {
        val ans = mutableListOf<Int>()
        ans.add(0)
        for (i in 1 .. n) {
            val gap = 1  shl (i-1)
            for (j in gap-1 downTo 0) {
                ans.add(ans[j] + gap)
            }
        }
        return ans
    }
}