import org.junit.Test
import kotlin.collections.ArrayList

class Solution39 {

    @Test
    fun test() {
        combinationSum(intArrayOf(4,2,8), 8)
    }
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>>{
        val ans = ArrayList<List<Int>>()
        combinationSumStep(candidates, target, 0, ArrayList<Int>(), ans)
        return ans
    }

    fun combinationSumStep(candidates: IntArray, target: Int, from: Int, list: ArrayList<Int>, ans: ArrayList<List<Int>>) {
        if (from > candidates.size - 1 || target < 0) {
            return
        }
        if (candidates[from] == target) {
            list.add(target)
            ans.add(ArrayList<Int>(list))
            list.remove(target)
        } else {
            list.add(candidates[from])
            combinationSumStep(candidates, target - candidates[from], from, list, ans)
            list.remove(candidates[from])
        }

        combinationSumStep(candidates, target, from + 1, list, ans)

    }
}