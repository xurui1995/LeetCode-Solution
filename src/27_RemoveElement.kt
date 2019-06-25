import org.junit.Test

class Solution27 {

    fun removeElement(nums: IntArray, `val`: Int) : Int {
        var count = nums.size
        for (i in 0 until nums.size) {

            if (i >= count)   {
                break
            }
            if (nums[i] == `val`) {
                while (count - 1 >= 0 &&nums[count -1] == `val`) {
                    count --
                }
                if (i >= count -1)   {
                    break
                }
                nums[i] = nums[count -1]
                nums[count -1] = `val`
                count --

            }
        }
        return count
    }


    @Test
    fun test() {
        val array = intArrayOf(3,3)
        println(removeElement(array, 3))
        println(array.toList())
    }
}