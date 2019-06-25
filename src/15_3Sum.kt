class Solution15 {

    fun test() {
        print(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))

    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closeSum = Int.MAX_VALUE
        var answser = target
        nums.sort()
        nums.forEachIndexed { index, i ->
            val search = target - i
            var start = index + 1
            var end = nums.size - 1
           while (start < end) {
               val gap = Math.abs(search - (nums[start] + nums[end]))

               if(gap == 0 ) {
                   return target

               }

               if(gap < closeSum ) {
                   closeSum = gap
                   answser = i + nums[start] + nums[end]

               }

               if (nums[start] + nums[end] > search) {
                   end --
               } else {
                   start ++
               }

           }

        }

        return answser
    }

}

