package kotlincode
class Solution91 {
    fun numDecodings(s: String): Int {
        if (s.isEmpty() || s[0] == '0' || s.contains("00")) {
            return 0
        }
        val f = IntArray(s.length)
        f[0] = 1
        if (s.length >= 2) {
            when {
                s[1] == '0' -> {
                    if (s[0].toInt() - 48 > 2) {
                        return 0
                    }
                    f[1] = 1
                }
                ((s[0].toInt()-48)*10 + s[1].toInt() - 48) <= 26 -> f[1] = 2
                else -> f[1] = 1
            }
        }
        for(n in 2 until  s.length) {
            if (s[n] == '0') {
                if (s[n-1].toInt() - 48 > 2) {
                    return 0
                }
                f[n] = f[n-2]
            } else if (s[n-1] == '0' || ((s[n-1].toInt()-48)*10 + s[n].toInt() - 48) > 26) {
                f[n] = f[n-1]
            }
            else  {
                f[n] = f[n-1] + f[n-2]
            }
        }
        return f[s.length-1]
    }
}