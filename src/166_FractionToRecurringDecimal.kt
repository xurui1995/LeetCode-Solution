import org.junit.Test

class Solution166 {

    @Test
    fun test() {
//        println(fractionToDecimal(1,2))
//        println(fractionToDecimal(2,1))
//        println(fractionToDecimal(4, 333))
//        println(fractionToDecimal(4, 3333))
//        println(fractionToDecimal(3, 44))
//        println(fractionToDecimal(-50, 8))
//        println(fractionToDecimal(7, -12))
        println(fractionToDecimal(Int.MIN_VALUE, -1))


    }

    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val a = numerator.toLong() / denominator.toLong()
        if (a * denominator == numerator.toLong()) {
            return a.toString()
        }
        val ans = StringBuilder()
        if (a == 0L && numerator xor denominator < 0) {
            ans.append("-")
        }

        ans.append(numerator / denominator)
        ans.append(".")

        val newAns = StringBuilder()
        getAns(Math.abs(numerator % denominator.toLong() * 10), Math.abs(denominator.toLong()), mutableListOf(), newAns)

        return ans.append(newAns).toString()
    }

    fun getAns(numerator: Long, denominator: Long, list: MutableList<Long>, ans: StringBuilder) {
        if (list.contains(numerator)) {
            val index = list.indexOf(numerator)
            ans.insert(index, '(')
            ans.append(')')
            return
        } else {
            if (numerator / denominator * denominator == numerator) {
                ans.append(numerator / denominator)
                return
            } else {
                if (numerator < denominator) {
                    ans.append(0)
                    list.add(numerator)
                    getAns(numerator * 10, denominator, list, ans)
                } else {
                    ans.append(numerator / denominator)
                    list.add(numerator)
                    getAns(numerator % denominator * 10, denominator, list, ans)
                }
            }
        }
    }
}