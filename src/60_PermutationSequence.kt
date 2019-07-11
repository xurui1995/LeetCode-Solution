import org.junit.Test

class Solution60 {


    @Test
    fun test() {
        println(getPermutation(3, 1)) //123
        println(getPermutation(3, 3)) //213
        println(getPermutation(4, 9)) //2314
        println(getPermutation(1, 1)) //1
        println(getPermutation(3, 2)) //132
    }

    fun getPermutation(n: Int, k: Int): String {

        val ans = StringBuilder()
        val list = arrayListOf<Int>()
        var i = 1
        var temp = 1
        while (i <= n) {
            temp *= i
            if (temp >= k) {
                break
            }
            i++
        }

        for (x in 1 .. n - i) {
            ans.append(x.toString())
        }

        for (x in ans.length + 1..n) {
            list.add(x)
        }

        getPermutationStep(list, temp, k, ans)
        return ans.toString()
    }

    fun getPermutationStep(list: ArrayList<Int>, temp: Int, k: Int, ans: StringBuilder) {
        if (list.size == 2) {
            if (k == 2) {
                ans.append(list[1].toString())
                ans.append(list[0].toString())
            } else {
                ans.append(list[0].toString())
                ans.append(list[1].toString())
            }
        } else {

            val nextSize = temp / list.size

            val a = (k - 1) / nextSize
            val b = (k - 1) % nextSize

            if (a != 0) {
                ans.append(list[a].toString())
                list.removeAt(a)
            } else {
                ans.append(list[0].toString())
                list.removeAt(0)
            }

            if (b != 0) {
                getPermutationStep(list, nextSize, b + 1, ans)
            } else {
                list.forEach {
                    ans.append(it.toString())
                }
            }
        }
    }

}