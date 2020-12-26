import org.junit.Test

class Solution4 {

    @Test
    fun test() {
        println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
        println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3)))
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val k = (nums1.size + nums2.size + 1) / 2
        if ((nums1.size + nums2.size) % 2 == 0) {
            return (findKth(nums1, nums2, k, 0, 0) + findKth(nums1, nums2, k + 1, 0, 0)) / 2.toDouble()
        }
        return findKth(nums1, nums2, k, 0, 0).toDouble()
    }

    fun findKth(nums1: IntArray, nums2: IntArray, k: Int, start1: Int, start2: Int): Int {
        if (start1 >= nums1.size) {
            return nums2[start2 + k - 1]
        }

        if (nums1.size - start1 > nums2.size - start2) {
            return findKth(nums2, nums1, k, start2, start1)
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2])
        }

        val newK = k / 2
        val leftIndex = if (start1 + newK - 1 >= nums1.size) nums1.lastIndex else start1 + newK - 1
        val rightIndex = start2 + newK - 1
        if (nums1[leftIndex] < nums2[rightIndex]) {
            return findKth(nums1, nums2, k - (leftIndex - start1 + 1), leftIndex + 1, start2)
        } else {
            return findKth(nums1, nums2, k - (rightIndex - start2 + 1), start1, rightIndex + 1)
        }
    }
}