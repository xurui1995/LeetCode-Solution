import org.junit.Test

class Solution51 {

    @Test
    fun test() {
        solveNQueen(3).also {
            for (i in it) {
                println("------")
                println(i.joinToString(separator = "\n"))
            }
        }
    }


    fun solveNQueen(n: Int): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val flags = BooleanArray(n)
        solveNQueenStep(IntArray(n) { -1 }, 0, flags, ans)
        return ans
    }

    private fun solveNQueenStep(array: IntArray, i: Int, flags: BooleanArray, ans: MutableList<List<String>>) {
        if (i < flags.size) {
            for (x in 0 until flags.size) {
                if (check(array, flags, i, x)) {
                    flags[x] = true
                    array[i] = x
                    if (i == flags.size - 1) {
                        val result = MutableList<String>(flags.size) { "" }
                        val charArray = CharArray(flags.size) { '.' }
                        for (y in 0 until array.size) {
                            charArray[array[y]] = 'Q'
                            result[y] = charArray.joinToString(separator = "")
                            charArray[array[y]] = '.'
                        }

                        ans.add(result)

                    } else {
                        solveNQueenStep(array, i + 1, flags, ans)
                    }
                    array[i] = -1
                    flags[x] = false
                }

            }
        }
    }

    private fun check(array: IntArray, flags: BooleanArray, i: Int, x: Int): Boolean {

        if (flags[x]) {
            return false
        }

        if (i == 0) {
            return true
        }
        return array.filterIndexed { index, value -> value != -1 && Math.abs(x - value).toFloat() / (i - index) == 1f }.isEmpty()
    }


}