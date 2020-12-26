package kotlincode

import org.junit.Test


class Solution43 {


    @Test
    fun test() {
        println(multiply("123", "456"))
    }

    fun multiply(num1: String, num2: String): String {
        // can be better
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        val array = Array<String>(10) { "0" }
        var temp = "0"
        for ( i in 1 .. 9) {
            temp = strAdd(num1, temp)
            array[i] = temp
        }

        var ans = "0"
        var times = 1
        for ( i in num2.length-1 downTo 0) {
            if (num2[i] != '0') {
                var value = array[num2[i].toString().toInt()]
                for (j in 1 until  times) {
                    value += "0"
                }
                ans = strAdd(ans, value)
            }
            times ++
        }

        return ans

    }

    fun strAdd(str1:String, str2: String): String {
        var next = 0
        var i = str1.length - 1
        var j = str2.length - 1
        val ans = StringBuilder()
        while (i >= 0 && j >= 0) {
            ans.insert(0, (str1[i].toString().toInt() + str2[j].toString().toInt() + next)%10)
            next = (str1[i].toString().toInt() + str2[j].toString().toInt() + next)/10
            i --
            j --
        }

        while (i >= 0) {
            ans.insert(0, (str1[i].toString().toInt() +  next)%10)
            next = (str1[i].toString().toInt() + next)/10
            i --
        }


        while (j >= 0) {
            ans.insert(0, (str2[j].toString().toInt() +  next)%10)
            next = (str2[j].toString().toInt() + next)/10
            j--
        }

        if (next != 0) {
            ans.insert(0, next)
        }

        return ans.toString()

    }
}