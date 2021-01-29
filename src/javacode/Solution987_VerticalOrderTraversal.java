package javacode;

import java.util.*;

class WrapperNode {
    int y;
    int val;

    WrapperNode(int val, int y) {
        this.val = val;
        this.y = y;
    }
}

public class Solution987_VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<WrapperNode>> map = new TreeMap();
        traversal(map, root, 0, 0);

        List<List<Integer>> ans = new ArrayList();
        for (List<WrapperNode> list : map.values()) {
            Collections.sort(list, new Comparator<WrapperNode>() {
                public int compare(WrapperNode o1, WrapperNode o2) {
                    if (o1.y != o2.y) {
                        return o1.y - o2.y;
                    } else {
                        return o1.val - o2.val;
                    }
                }
            });


            List<Integer> temp = new ArrayList();
            for (WrapperNode node : list) {
                temp.add(node.val);
            }
            ans.add(temp);
        }
        return ans;
    }

    void traversal(Map<Integer, List<WrapperNode>> map, TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        if (map.containsKey(x)) {
            map.get(x).add(new WrapperNode(root.val, y));
        } else {
            List<WrapperNode> list = new ArrayList();
            list.add(new WrapperNode(root.val, y));
            map.put(x, list);
        }

        traversal(map, root.left, x - 1, y + 1);
        traversal(map, root.right, x + 1, y + 1);
    }
}

