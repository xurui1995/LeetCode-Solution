class Solution167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val ans = intArrayOf(0,0)
        var left = 0
        var right = numbers.lastIndex
        while (left < right) {
            when{
                numbers[left] + numbers[right] == target -> {
                    ans[0] = left+1
                    ans[1] = right+1
                    return ans
                }
                numbers[left] + numbers[right] > target -> { right -- }
                else -> { left++ }
            }
        }

        return ans
    }
}