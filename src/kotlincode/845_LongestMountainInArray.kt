package kotlincode

import org.junit.Test

class Solution845 {

    @Test
    fun test() {
        println(longestMountain(intArrayOf(2, 1, 4, 7, 3, 2, 5)))
        println(longestMountain(intArrayOf(2, 2, 2)))
        println(longestMountain(intArrayOf(875, 884, 239, 731, 723, 685)))
    }

    fun longestMountain(arr: IntArray): Int {

        if (arr.size < 3) {
            return 0
        }

        var ans = 0
        var temp = 0
        var isDown = false

        for (i in 1..arr.lastIndex) {
            if (arr[i] > arr[i - 1]) {
                if (isDown) {
                    temp = 2
                    isDown = false
                } else {
                    if (temp == 0) {
                        temp = 2
                    } else {
                        temp++
                    }
                }

            } else if (arr[i] < arr[i - 1]) {
                if (temp != 0) {
                    isDown = true
                    temp++
                    if (temp > ans) {
                        ans = temp
                    }
                }
            } else {
                isDown = false
                temp = 0
            }
        }

        return ans
    }
}