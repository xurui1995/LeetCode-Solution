import org.junit.Test

class Solution215 {

    @Test
    fun test() {
        println(findKthLargest(intArrayOf(2,1), 1))
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        var l = nums.size - k
        var from = 0
        var end = nums.lastIndex
        while (true) {
            val j = getIndex(nums, from, end)
            if (j == l) {
                break
            } else if (j > l) {
                end = j - 1
            } else {
                from = j + 1
            }
        }
        return nums[l]
    }

    fun getIndex(nums: IntArray, from: Int, end: Int): Int {
        var varFrom = from + 1
        var varEnd = end
        while (true) {
            while (varFrom <= varEnd && nums[varFrom] < nums[from]) {
                varFrom++
            }

            while (varEnd >= varFrom && nums[varEnd] > nums[from]) {
                varEnd--
            }

            if (varFrom >= varEnd) {
                break
            }
            swap(nums, varFrom, varEnd)
        }
        swap(nums, from, varEnd)
        return varEnd
    }

    fun swap(nums: IntArray, from: Int, end: Int) {
        val temp = nums[from]
        nums[from] = nums[end]
        nums[end] = temp
    }
}