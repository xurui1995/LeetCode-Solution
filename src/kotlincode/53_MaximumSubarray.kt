package kotlincode

class Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var tempSum = 0;
        for (i in 0 until nums.size) {
            if (tempSum > 0) {
                tempSum += nums[i]
            } else {
                tempSum = nums[i]
            }
            if (tempSum > maxSum) {
                maxSum = tempSum
            }
        }
        return maxSum
    }
}
