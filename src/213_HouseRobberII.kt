class Solution213 {
    fun rob(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        val f = IntArray(nums.size)
        f[0] = nums[0]
        f[1] = Math.max(nums[0], nums[1])

        val j = IntArray(nums.size)
        j[0] = 0
        j[1] = nums[1]
        for (i in 2 until nums.size - 1) {
            j[i] = Math.max(j[i-1], j[i-2] + nums[i])

            f[i] = Math.max(f[i-1], f[i-2] + nums[i])
        }
        j[nums.size-1] = Math.max(j[nums.size-2], j[nums.size - 3] + nums[nums.size - 1])

        return Math.max(f[nums.size - 2], j[nums.size - 1])
    }
}