package kotlincode

import org.junit.Test

class Solution146 {

    @Test
    fun test() {
        val cache = LRUCache(2/* capacity */)

        cache.put(2, 1)
        cache.put(1, 1)
        cache.put(2, 3)
        cache.put(4, 1)
        println( cache.get(1) )
        println( cache.get(2) )

    }
}

class LRUCache(capacity: Int) {

    val capacity = capacity
    var tail : DuLNode? = null
    var head: DuLNode? = null
    var map = HashMap<Int, DuLNode>()

    fun get(key: Int): Int {
        val node = map[key]
        if (node != null) {
            if (node != head) {
                node.prior?.next = node.next
                node.next?.prior = node.prior
                if (node == tail) {
                    tail = tail?.prior
                }
                node.next = head
                node.prior = null
                head?.prior = node
                head = node

            }
            return node.data
        }
        return -1

    }

    fun put(key: Int, value: Int) {

        val already  = map[key]
        if (already != null) {
            if (already != head) {
                already.prior?.next = already.next
                already.next?.prior = already.prior
                if (already == tail) {
                    tail = tail?.prior
                }
                already.next = head
                already.prior = null
                head?.prior = already
                head = already
            }
            already.data = value
        } else {
            if (map.size == capacity) {
                map.remove(tail?.key)
                if (tail == head) {
                    head = null
                }
                tail = tail?.prior
                tail?.next = null
            }
            val node = DuLNode(null, null, key, value)
            if (head == null) {
                head = node
                tail = head
            } else {
                node.next = head
                head?.prior = node
                head = node
            }
            map[key] = node
        }
    }
}

class DuLNode(var prior: DuLNode?, var next: DuLNode?, var key: Int,var data: Int)