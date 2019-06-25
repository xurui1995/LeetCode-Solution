//package LeetCode
//
//class Solution139 {
//    fun wordBreak(s: String, wordDict: List<String>): Boolean {
//        if (wordDict.isEmpty()) {
//            return false
//        }
//        return  break1(s, wordDict, wordDict.size-1)
//    }
//
//    fun break1(s: String, wordDict: List<String>, n: Int): Boolean {
//
//        if (s.contains(wordDict[n])) {
//            if (s == wordDict[n]) {
//                return true
//            }
//            val start = s.indexOf(wordDict[n])
//
//            if (newS == "") {
//                return true
//            } else {
//                return break1(newS, wordDict, n) || (if (n-1>=0) break1(s, wordDict, n-1) else false)
//            }
//        } else {
//            if (n == 0) {
//                return false
//            } else {
//                return break1(s, wordDict, n-1)
//            }
//        }
//    }
//}