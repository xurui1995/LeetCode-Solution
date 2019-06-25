class Solution75 {
    fun sortColors(nums: IntArray): Unit {
        var zero = -1
        var two = nums.size

        fun swap(i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        var i = 0
        while (i < two) {
           when(nums[i]) {
               1 -> {i++}
               0 -> {swap(++zero, i++)}
               2 -> {swap(--two, i)}
           }

            print("")
        }

        for (i in nums) {
            print(i)
        }

    }
}