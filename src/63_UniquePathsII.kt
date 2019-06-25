
class Solution63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

        if (obstacleGrid[0][0] == 0) {
            obstacleGrid[0][0] = 1
        } else {
            return 0
        }


        for (i in 1 until  obstacleGrid[0].size) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i-1]
            }
        }
        for (i in 1 until  obstacleGrid.size) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0
            } else {
                obstacleGrid[i][0] = obstacleGrid[i-1][0]
            }
        }


        for (i in 1 until obstacleGrid.size) {
            for (j in 1 until obstacleGrid[0].size) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
                }
            }
        }

        return obstacleGrid[obstacleGrid.size-1] [obstacleGrid[0].size-1]
    }
}