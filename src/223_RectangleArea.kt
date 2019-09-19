import org.junit.Test

class Solution223 {

    @Test
    fun test() {
        println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
        println(computeArea(-2, -2, 2, 2, 1, -3, 3, -1))

    }

    fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
        val area1 = (C - A) * (D - B)
        val area2 = (G - E) * (H - F)

        if ((A <= E && C <= E) || (A >= G && C >= G) || (D >= H && B >= H) || (D <= F && B <= H)) {
            return area1 + area2
        } else {
            val commonWidth = if (E <= A && G >= C) {
                Math.abs(C - A)
            } else if (E >= A && G <= C) {
                Math.abs(G - E)
            } else if (G > C) {
                Math.abs(E - C)
            } else {
                Math.abs(G - A)
            }

            val commonHeight = if (H >= D && F <= B) {
                Math.abs(D - B)
            } else if (H <= D && F >= B) {
                Math.abs(H - F)
            } else if (D > H) {
                Math.abs(H - B)
            } else {
                Math.abs(D - F)
            }
            return area1 + area2 - commonHeight * commonWidth
        }
    }
}