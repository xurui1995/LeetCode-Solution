
import java.util.ArrayList


class Solution17 {

    fun letterCombinations(digits: String): List<String> {
        val result = ArrayList<String>()
        append(result, 0, "", digits)
        return result
    }
    fun append(list: ArrayList<String>, index: Int, currentStr: String, digits: String) {
        if (index < digits.length) {
            val str = getStrByNum(digits[index])
            if (index == digits.lastIndex) {
                str.forEach {
                    list.add(currentStr + it)
                }
            } else {
                str.forEach {
                    append(list, index + 1,currentStr + it, digits )
                }
            }
        }
    }

    fun getStrByNum(num: Char): String {
        return when(num) {
            '2' -> "abc"
            '3' -> "def"
            '4' -> "ghi"
            '5' -> "jkl"
            '6' -> "mno"
            '7' -> "pqrs"
            '8' -> "tuv"
            '9' -> "wxyz"
            else -> ""
        }
    }
}