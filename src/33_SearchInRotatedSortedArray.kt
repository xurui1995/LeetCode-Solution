import org.junit.Test

class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1

        while (left < right) {
            var mid: Int = (left + right)/2
            if (left == mid) {
                if (nums[mid] != target) {
                    left++
                    mid++
                }
            }
            when {
                target == nums[mid] -> return mid
                nums[mid] > target -> {
                    if (nums[mid] >= nums[0]) {
                        left = mid
                    } else {
                        right = mid
                    }
                }
                else -> {
                    left = mid
                }
            }
        }

        if (nums.isEmpty()) {
            return -1
        }
        return if (nums[left] == target) left else -1
    }



    @Test
    fun test() {
        val array = intArrayOf(1,3,5)
        print(search(array, 1))
    }
}