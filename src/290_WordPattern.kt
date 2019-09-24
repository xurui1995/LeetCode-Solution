import org.junit.Test

class Solution290 {

    @Test
    fun test() {
        println(wordPattern(pattern = "abba", str = "dog cat cat dog"))
        println(wordPattern(pattern = "abba", str = "dog cat cat fish"))
        println(wordPattern(pattern = "abba", str = "dog cat cat dog"))
        println(wordPattern(pattern = "abba", str = "dog dog dog dog"))
    }

    fun wordPattern(pattern: String, str: String): Boolean {
        val list = str.split(" ")
        if (list.size != pattern.length) {
            return false
        }
        val map = mutableMapOf<Char, String>()
        val values = mutableSetOf<String>()
        pattern.forEachIndexed { index, c ->
            if (map.contains(c)) {
                if (list[index] != map[c]) {
                    return false
                }
            } else {
                if (values.contains(list[index])) {
                    return false
                }
                map[c] = list[index]
                values.add(list[index])
            }
        }
        return true
    }
}