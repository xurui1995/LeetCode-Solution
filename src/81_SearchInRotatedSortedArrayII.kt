import org.junit.Test

class Solution81 {

    @Test
    fun test() {
        println(search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0))
        println(search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 3))
        println(search(intArrayOf(2), 3))
        println(search(intArrayOf(2), 1))
        println(search(intArrayOf(2), 2))
        println(search(intArrayOf(1, 3), 3))
        println(search(intArrayOf(1, 1, 0, 0, 1, 1), 1))
        println(search(intArrayOf(1, 1, 0, 0, 1, 1), 0))
    }

    fun search(nums: IntArray, target: Int): Boolean {

        if (nums.isEmpty()) {
            return false
        }

        val isLeft = target >= nums[0]

        var end = nums.size - 1
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] != nums[0]) {
                end = i
                break
            }
        }
        var left = 0
        var right = end
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return true
            }
            if (nums[mid] > target) {
                if (isLeft) {
                    right = mid - 1
                } else {
                    if (nums[mid] >= nums[0]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            } else {
                if (!isLeft) {
                    left = mid + 1
                } else {
                    if (nums[mid] >= nums[0]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }

        }
        return false
    }
}