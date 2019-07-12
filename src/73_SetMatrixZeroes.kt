import org.junit.Test

class Solution73 {

    @Test
    fun test() {
        val matrix = arrayOf(intArrayOf(0,1,2,5,0),
                intArrayOf(3,4,5,0,2),
                intArrayOf(1,3,1,4,5))
        setZeroes(matrix)
        println(matrix.joinToString(separator = "\n"){ it -> it.joinToString { i -> i.toString() }})
    }

    fun setZeroes(matrix: Array<IntArray>): Unit {

        if (matrix.isEmpty()) {
            return
        }

        var firstRowFlag = false
        matrix.forEachIndexed { i, ints ->
            if (i != 0) {
                ints.forEachIndexed { j, value ->
                    if (value == 0) {
                        matrix[i][0] = 0
                        matrix[0][j] = 0
                    }
                }
            } else {
                if (ints.contains(0)) {
                    firstRowFlag = true
                }
            }
        }

        matrix.forEachIndexed { i, ints ->
          if (i == 0) {
              ints.forEachIndexed{j, value ->
                  if (value == 0 && j != 0) {
                      for (x in matrix) {
                          x[j] = 0
                      }
                  }
              }
          } else {
              if (ints[0] == 0) {
                  ints.fill(0)
              }
          }
        }

        if (matrix[0][0] == 0) {
            for (x in matrix) {
                x[0] = 0
            }
        }
        if (firstRowFlag) {
            matrix[0].fill(0)
        }
    }
}