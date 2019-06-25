class NumArray(val nums: IntArray) {

    fun sumRange(i: Int, j: Int): Int {
        return if (i > j) {
            0
        } else {
            nums[i] + sumRange(i+1, j)
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */