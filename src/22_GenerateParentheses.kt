package LeetCode

class Solution22 {

    fun generateParenthesis(n: Int): List<String> {
        val list = ArrayList<String>()
        if (n > 0) {
            add("(", 1, 0, n, list)
        }
        return list
    }

    fun add(current: String, leftNum: Int, rightNum: Int, totalNum: Int, list: ArrayList<String>) {
        if (rightNum > leftNum || leftNum > totalNum || rightNum > totalNum) {
            return
        }
        if (leftNum == totalNum && rightNum == totalNum) {
            list.add(current)
            return
        }
        add("$current(", leftNum + 1, rightNum, totalNum, list)
        add("$current)", leftNum, rightNum + 1, totalNum, list)
    }
}