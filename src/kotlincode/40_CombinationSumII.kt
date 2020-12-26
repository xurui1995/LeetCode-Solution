package kotlincode

import org.junit.Test

class Solution40 {

    @Test
    fun test() {
        combinationSum2(intArrayOf(1, 2, 5, 7, 1, 6), 8)
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        val map = HashMap<Int, Int>()
        candidates.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        combinationSum2Step(candidates.distinct().toIntArray(), target, ArrayList(), map, ans, from = 0)
        return ans
    }

    fun combinationSum2Step(candidates: IntArray, target: Int, list: ArrayList<Int>, map: Map<Int, Int>, ans: ArrayList<List<Int>>, from: Int, count: Int = 1) {
        if (from > candidates.size - 1 || target < 0) {
            return
        }

        if (count > map.getValue(candidates[from])) {
            combinationSum2Step(candidates, target, list, map, ans, from + 1)
            return
        }
        if (target == candidates[from]) {
            list.add(target)
            ans.add(ArrayList<Int>(list))
            list.remove(target)
        } else {
            list.add(candidates[from])
            combinationSum2Step(candidates, target - candidates[from], list, map, ans, from, count + 1)
            list.remove(candidates[from])
        }

        combinationSum2Step(candidates, target, list, map, ans, from + 1)
    }
}