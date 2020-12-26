package kotlincode

import org.junit.Test

class Solution34 {

    @Test
    fun test() {
        val nums = intArrayOf()

        println(searchRange(nums, 8).joinToString { it.toString() })
        println(searchRange(nums, 6).joinToString { it.toString() })
        println(searchRange(nums, 7).joinToString { it.toString() })

    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        val left = searchLeft(nums, target)
        if (left == -1) {
            return intArrayOf(-1, -1)
        }
        var right = searchRight(nums, left, target)

        return intArrayOf(left, right)
    }

    fun searchLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            var mid = (left + right) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return if (nums[left] == target) left else -1
    }

    fun searchRight(num: IntArray, from: Int, target: Int): Int {
        var left = from
        var right = num.size - 1
        while (left < right) {
            var mid = (left + right) / 2 + 1
            if (num[mid] > target) {
                right = mid - 1
            } else {
                left = mid
            }
        }
        return if (num[left] == target) left else from
    }
}