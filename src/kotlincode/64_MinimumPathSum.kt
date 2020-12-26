package kotlincode

class Solution64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (i == 0 && j == 0) {
                    continue
                }
                grid[i][j] = Math.min(if ((i - 1) >= 0) grid[i - 1][j] else Int.MAX_VALUE, if ((j - 1) >= 0) grid[i][j - 1] else Int.MAX_VALUE) + grid[i][j]
            }
        }
        return grid[grid.size-1][grid[0].size-1]
    }
}