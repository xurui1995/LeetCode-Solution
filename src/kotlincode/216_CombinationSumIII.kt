package kotlincode

import org.junit.Test

class Solution216 {


    @Test
    fun test() {
        println(combinationSum3(2, 1))
    }

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        if (n < 1 || n > 50) {
            return emptyList()
        }
        val ans = mutableListOf<List<Int>>()
        helper(1, k, n, mutableListOf(), ans)
        return ans
    }

    fun helper(start: Int, k: Int, n: Int, temp: MutableList<Int>, ans: MutableList<List<Int>>) {

        if (k == 1) {
            if (n in start..9) {
                temp.add(n)
                ans.add(temp.toList())
                temp.removeAt(temp.lastIndex)
            }
        } else {
            for (i in start..9) {
                if (start > n) {
                    return
                }
                temp.add(i)
                helper(i + 1, k - 1, n - i, temp, ans)
                temp.removeAt(temp.lastIndex)
            }
        }
    }
}