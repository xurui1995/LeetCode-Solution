import org.junit.Test

class Solution219 {

    @Test
    fun test() {
        println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
        println(containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
        println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    }

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (map.containsKey(i)) {
                if (index - map.getOrDefault(i,0) <= k) {
                    return true
                }
            }
            map[i] = index
        }
        return false
    }
}