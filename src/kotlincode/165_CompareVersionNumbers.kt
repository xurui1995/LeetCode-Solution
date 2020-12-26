package kotlincode

import org.junit.Test

class Solution165 {


    @Test
    fun test() {
        println(compareVersion("1.2", "1.10"))


    }


    fun compareVersion(version1: String, version2: String): Int {

        val needReversed = if (version1.length > version2.length) -1 else 1
        val list1 = if (version1.length > version2.length) version2.split('.') else version1.split('.')
        val list2 = if (version1.length <= version2.length) version2.split('.') else version1.split('.')

        for (i in 0 until list1.size) {
            val ans = compare(list1[i], list2[i])
            if (ans != 0) {
                return ans * needReversed
            }
        }

        for (i in list1.size until list2.size) {
            if (list2[i].all { it == '0' }.not()) {
                return -1 * needReversed
            }
        }

        return 0
    }


    fun compare(version1: String, version2: String): Int {
        if (version1 == version2) {
            return 0
        }
        var start1 = 0
        while (start1 <= version1.length) {
            if (start1 <= version1.lastIndex && version1[start1] == '0') {
                start1++
            } else {
                break
            }
        }

        var start2 = 0
        while (start2 <= version2.length) {
            if (start2 <= version2.lastIndex && version2[start2] == '0') {
                start2++
            } else {
                break
            }
        }

        return if (start1 == version1.length && start2 == version2.length) {
            0
        } else if (start1 == version1.length) {
            -1
        } else if (start2 == version2.length) {
            1
        } else {
            val sub1 = version1.substring(start1)
            val sub2 = version2.substring(start2)
            if (sub1.length < sub2.length) {
                -1
            } else if (sub1.length > sub2.length) {
                1
            } else {
                val v = version1.substring(start1).compareTo(version2.substring(start2))
                if (v > 0) {
                    1
                } else if (v < 0) {
                    -1
                } else {
                    0
                }
            }
        }
    }
}