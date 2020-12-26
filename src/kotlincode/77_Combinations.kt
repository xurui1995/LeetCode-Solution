package kotlincode

import org.junit.Test

class Solution77 {


    @Test
    fun test() {
        println(combine(3, 1).joinToString(separator = "\n") { it.joinToString { i -> i.toString() } })
    }

    fun combine(n: Int, k:Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        combineStep( IntArray(k), n, k, ans)
        return ans
    }

    fun combineStep(array: IntArray, end: Int, k : Int, ans:MutableList<List<Int>> ) {
        if (k == 1) {
            for (i in end downTo 1) {
                array[0] = i
                ans.add(array.toList())
            }
            array[0] = 0
        } else {
            for (i in end downTo k) {
                array[k-1] = i
                combineStep(array, i -1, k-1,  ans)
                array[k-1] = 0
            }
        }
    }
}