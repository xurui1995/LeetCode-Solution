import org.junit.Test

class Solution96 {

    var ans = 0

    @Test
    fun test() {
        println(numTrees(2))
        println(numTrees(3))
        println(numTrees(4))
        println(numTrees(5))
    }

    fun numTrees(n: Int): Int {
        val array = IntArray(n + 1)
        array[0] = 1
        array[1] = 1
        for (i in 2..n) {
            var value = 0
            for (j in 0..(i - 1) / 2) {
                if (j * 2 != i - 1) {
                    value += array[j] * array[i - 1 - j] * 2
                } else {
                    value += array[j] * array[i - 1 - j]
                }
            }
            array[i] = value
        }
        return array[n]
    }

    fun numTreeByStep(n: Int, index: Int) {
        if (index == n) {
            ans++
        } else {
            numTreeByStep(n, index + 1)
            numTreeByStep(n, index + 1)
            if (index <= n - 2) {
                numTreeByStep(n, index + 2)
                if (index < n - 2) {
                    numTreeByStep(n, index + 2)
                }

            }
        }
    }
}