package kotlincode

class Solution72 {
    fun minDistance(word1: String, word2: String): Int {

        if (word1.isEmpty()) return word2.length
        if (word2.isEmpty()) return word1.length

        val array = Array(word1.length) { IntArray(word2.length) }
        for (i in 0 until word1.length) {
            for (j in 0 until word2.length) {
                if (word2[j] == word1[i]) {
                    when {
                        i-1<0 -> array[i][j] = j
                        j-1<0 -> array[i][j] = i
                        else -> array[i][j] = array[i-1][j-1]
                    }
                } else {
                    if (i==0 && j== 0) {
                        array[i][j] = 1;
                        continue
                    }
                    val min1 = if (i>=1 && j>=1) array[i-1][j-1] + 1 else Int.MAX_VALUE
                    val min2 = if (j>=1) array[i][j-1] + 1 else i + 1
                    val min3 = if (i>=1) array[i-1][j] + 1 else j + 1
                    array[i][j] =  Math.min(Math.min(min1, min2),min3)
                }
            }
        }
        return array[word1.length - 1] [word2.length - 1]
    }


}