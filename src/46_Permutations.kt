import org.junit.Test

class Solution46 {


    @Test
    fun test() {
        permute(intArrayOf(1, 2, 3))
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        permuteByStep(nums, ans, 0)
        return ans
    }

    fun permuteByStep(nums: IntArray, ans: ArrayList<List<Int>>, index: Int) {
        if (index == nums.size - 1) {
            ans.add(ArrayList<Int>(nums.toList()))
            return
        }

        for (i in index until nums.size) {
            val temp = nums[i]
            nums[i] = nums[index]
            nums[index] = temp

            permuteByStep(nums, ans, index + 1)

            nums[index] = nums[i]
            nums[i] = temp
        }
    }

}