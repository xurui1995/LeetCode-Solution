import org.junit.Test

class Solution287 {

    @Test
    fun test() {
        println(findDuplicate(intArrayOf(1,3,4,2,2)))
        println(findDuplicate(intArrayOf(3,1,3,4,2)))
    }

    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = nums[0]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }

}