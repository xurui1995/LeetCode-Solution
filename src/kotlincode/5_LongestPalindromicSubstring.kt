class Solution5 {
    fun longestPalindrome(s: String): String {
        var newStr = "#";
        s.forEach {
            newStr += "$it#"
        }
        var pos = 0
        var maxRight = 0
        val R = IntArray(newStr.length){1}

        fun findR(i: Int, pre1: Int, post1: Int) {
            var pre = pre1
            var post = post1
            while (pre >= 0 && post < newStr.length && newStr[pre] == newStr[post]) {
                R[i] ++
                pre--
                post++
            }
            if (i + R[i] - 1 > maxRight) {
                maxRight = i + R[i] - 1
                pos = i
            }
        }

        for (i in 0 until newStr.length) {
                if (i < maxRight) {
                    val ii = pos - (i-pos)
                    val start = ii + 1 - R[ii]
                    val end = pos + 1 - R[pos]
                    if (start >= end) {
                        R[i] = R[ii]
                        findR(i, i-R[ii], i+ R[ii])
                    } else {
                        R[i] = (maxRight - i)
                        findR(i, i-R[ii], maxRight)
                    }
                } else {
                    findR(i,i-1,i+1)
                }
        }
        val max = R.max()?:1
        val index = R.indexOf(max)
        var result = newStr[index].toString()
        for (i in 1 until max) {
            result = result.plus(newStr[index + i])
            result = newStr[index + i].plus(result)
        }

        return result.filter { it != '#' }
    }
}