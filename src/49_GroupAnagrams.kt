import org.junit.Test

class Solution49 {

    @Test
    fun test() {
        val result = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        for (i in result) {
            println(i.joinToString { it })
        }
    }


    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val map = mutableMapOf<String, MutableList<String>>()
        val array = Array<Int>(26) { 0 }
        for (str in strs) {
            array.fill(0)
            for (i in str) {
                array[i - 'a']++
            }

            val temp = StringBuilder()
            array.forEachIndexed { index, i ->
                temp.append("$index$i#")
            }

            if (map.containsKey(temp.toString())) {
                map.get(temp.toString())?.add(str)
            } else {
                map.put(temp.toString(), mutableListOf(str))
            }
        }

        for ((_, list) in map) {
            ans.add(list)
        }

        return ans
    }


}