import org.junit.Test

class Solution10 {


    @Test
    fun test() {
//        println(isMatch("aa","a"))
//        println(isMatch("aa","a*"))
//        println(isMatch("aa","a."))
//        println(isMatch("abcs","a*a.csi*"))
//        println(isMatch("",".*"))
        println(isMatch("aaa", "a*a"))
    }

    fun isMatch(s: String, p: String): Boolean {
        if (s == p) {
            return true
        }
        if (s.isEmpty()) {
            return canMatchEmpty(p, 0)
        }
        return isMatch(s, p, 0, 0)
    }

    fun isMatch(s: String, p: String, sIndex: Int, pIndex: Int): Boolean {

        if (sIndex == s.lastIndex) {
            if (pIndex > p.lastIndex) {
                return false
            } else if (s[sIndex] == p[pIndex] || p[pIndex] == '.') {
                var ans = canMatchEmpty(p, pIndex + 1)
                if (!ans) {
                    if (pIndex < p.lastIndex && p[pIndex + 1] == '*') {
                        ans = isMatch(s, p, sIndex, pIndex + 2)
                    }
                }
                return ans
            } else if (pIndex < p.lastIndex && p[pIndex + 1] == '*') {
                return isMatch(s, p, sIndex, pIndex + 2)
            } else {
                return false
            }
        } else {
            if (pIndex > p.lastIndex) {
                return false
            }

            if (s[sIndex] == p[pIndex] || p[pIndex] == '.') {
                if (pIndex < p.lastIndex && p[pIndex + 1] == '*') {
                    // 用
                    // 不用
                    var dontuse = isMatch(s, p, sIndex, pIndex + 2)
                    if (!dontuse) {
                        dontuse = isMatch(s, p, sIndex + 1, pIndex)
                    }
                    return dontuse
                } else {
                    return isMatch(s, p, sIndex + 1, pIndex + 1)
                }
            } else if (pIndex < p.lastIndex && p[pIndex + 1] == '*') {
                return isMatch(s, p, sIndex, pIndex + 2)
            } else {
                return false
            }
        }
    }

    fun canMatchEmpty(p: String, pIndex: Int): Boolean {
        if (pIndex > p.lastIndex) {
            return true
        }

        var index = pIndex
        if (p[pIndex] == '*') {
            index++
        }
        for (i in index..p.lastIndex) {
            if (p[i] == '.' || (p[i] in 'a'..'z')) {
                if (i == p.lastIndex) {
                    return false
                }
                if (p[i + 1] != '*') {
                    return false
                }
            }
        }
        return true
    }
}