class Solution152 {
    fun maxProduct(nums: IntArray): Int {
        var first = 1
        var second = 0
        val f = IntArray(nums.size)

        for (i in 0 until nums.size) {
            first *= nums[i]
            second *= nums[i]
            when {
                nums[i] == 0 -> {
                   f[i] = 0
                    first = 1
                    second = 0
                }
                nums[i] > 0 -> {
                    if (i == 0) {
                        f[i] = nums[i]
                    } else {
                        f[i] = Math.max(f[i-1] * nums[i], nums[i])

                    }

                }
                else -> {
                    if (second == 0) {
                        f[i] = Math.max(first, nums[i])
                        if (i + 1 < nums.size) {
                            second = 1
                        }
                    } else {
                        f[i] = Math.max(Math.max(first, second), nums[i])
                    }
                }
            }
        }

        return f.max()?:0
    }
}