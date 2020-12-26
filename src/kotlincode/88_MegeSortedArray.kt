package kotlincode

import org.junit.Test

class Solution88 {

    @Test
    fun test() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(-3, -2, -1)
        merge(nums1, 3, nums2, 3)
        println(nums1.joinToString { it.toString() })
    }


    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (n <= 0) {
            return
        }

        if (m == 0) {
            for (i in 0 until n) {
                nums1[i] = nums2[i]
            }
            return
        }


        when {
            nums2[0] >= nums1[m - 1] -> for (i in 0 until n) {
                nums1[m + i] = nums2[i]
            }
            nums2[n - 1] <= nums1[0] -> {
                for (i in m + n - 1 downTo n) {
                    val temp = nums1[i - n]
                    nums1[i - n] = nums1[i]
                    nums1[i] = temp
                }

                for (i in 0 until n) {
                    nums1[i] = nums2[i]
                }
            }
            else -> {
                var i = m - 1
                var j = n - 1
                var index = m + n - 1
                while (i >= 0 && j >= 0) {
                    when {
                        nums2[j] > nums1[i] -> {
                            nums1[index--] = nums2[j--]
                        }
                        nums1[i] > nums2[j] -> {
                            nums1[index--] = nums1[i--]
                        }
                        else -> {
                            nums1[index--] = nums2[j--]
                            nums1[index--] = nums1[i--]
                        }
                    }
                }

                while (j >= 0) {
                    nums1[index--] = nums2[j--]
                }
            }
        }
    }
}