package javacode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class Solution133_CloneGraph {

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors = new ArrayList<>();
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node a = cloneGraph(node1);
        System.out.println(a.val);
    }

    public Node cloneGraph(Node node) {
        if (node != null) {
            Map<Integer, Node> set = new HashMap<>();
            return cloneHelp(set, node);
        }
        return null;

    }

    private Node cloneHelp(Map<Integer, Node> map, Node node) {
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        newNode.neighbors = new ArrayList<>();
        if (node.neighbors != null) {
            for (Node neighbor : node.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    newNode.neighbors.add(cloneHelp(map, neighbor));
                } else {
                    newNode.neighbors.add(map.get(neighbor.val));
                }
            }
        }
        return newNode;
    }
}
