class Solution1 {


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (map.containsKey(target - i)) {
                return intArrayOf(map.getOrDefault(target - i, 0), index)
            } else {
                map.put(i, index)
            }
        }
        return intArrayOf(0, 0)
    }
}