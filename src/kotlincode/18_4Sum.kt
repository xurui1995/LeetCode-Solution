import org.junit.Test

class Solution18 {

    @Test
    fun test() {
        println(fourSum(intArrayOf(-3,-2,-1,0,0,1,2,3), 0))
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (i in 0..nums.size - 4) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            if (target < nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
                return ans
            }
            loop@ for (j in i + 1..nums.size - 3) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue@loop
                }
                if (target - nums[i] < nums[j] + nums[j + 1] + nums[j + 2]) {
                    break@loop
                }

                val key = target - nums[i] - nums[j]
                var left = j + 1
                var right = nums.lastIndex
                while (left < right) {
                    if (nums[left] + nums[right] == key) {
                        ans.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        val leftValue = nums[left]
                        var rightvalue = nums[right]
                        while (left < right && nums[left] == leftValue) {
                            left++
                        }

                        while (right > left && nums[right] == rightvalue) {
                            right--
                        }

                    } else if (nums[left] + nums[right] > key) {
                        right--
                    } else {
                        left++
                    }
                }

            }
        }
        return ans
    }
}