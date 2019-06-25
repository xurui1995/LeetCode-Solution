class Solution198 {

    fun test() {
        print(rob(intArrayOf(2,7,9,3,1)))
    }

    fun rob(nums: IntArray): Int {
        val answer : IntArray = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            when (index) {
                0 -> answer[0] = i
                1 -> answer[1] = Math.max(nums[0], nums[1])
                else -> answer[index] = Math.max(answer[index - 2] + i, answer[index-1])
            }
        }
        return if (answer.isNotEmpty()) answer[answer.size-1] else 0
    }
}
