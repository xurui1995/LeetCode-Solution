package kotlincode

class Solution217 {

    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.toHashSet().size != nums.size
    }
}