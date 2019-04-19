package ch14;

/*Java实现图遍历算法：深度优先与宽度优先搜索
  深度优先：对于新发现的顶点，若该点还有以此为起点的为探测到的边，则沿着这条边继续探测下去(明显是个递归过程)。当顶点v所有边都已被探寻过后，
  搜索将回到发现顶点v有起始的那些边。此过程一直进行到已发现从源顶点可达的所有顶点为止。
  宽度优先：当访问顶点v时，记录其所有未被访问的相邻顶点(加入待访问队列中)，然后结束这个顶点v的访问。接着从待访问队列中取出队头
  顶点，作为下一个访问顶点，重复上述过程，直至队列为空！
 * */

import java.util.*;

/*定义图中的节点的数据结构*/
class Node {
    int val;                // 节点数据
    List<Node> neighbours;  // 相邻其他节点

    public Node(int x) {
        val = x;
        neighbours = new ArrayList<Node>();
    }
}

public class Code1 {
    public static void main(String[] args) {
        Node begin = createGraph();
        Set<Node> visited = new HashSet<>();
        System.out.println("DFS:");
        DFS(begin, visited);
        System.out.println("BFS:");
        BFS(begin);
    }

    /* 创建图，返回一个节点 */
    public static Node createGraph() {
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);
        Node v6 = new Node(6);
        Node v7 = new Node(7);
        Node v8 = new Node(8);

        v1.neighbours.add(v2);
        v1.neighbours.add(v3);
        v1.neighbours.add(v4);
        v1.neighbours.add(v5);

        v2.neighbours.add(v6);
        v2.neighbours.add(v7);

        v4.neighbours.add(v8);
        return v1;
    }

    /**
     * 深度优先
     *
     * @param v       源顶点
     * @param visited 集合类型，记录所有已访问顶点
     */
    public static void DFS(Node v, Set<Node> visited) {
        if (visited.contains(v))
            return;
        else {
            System.out.println("Visit node:" + v.val);
            visited.add(v);
            for (Node next : v.neighbours) {
                DFS(next, visited);
            }
        }
    }

    /**
     * 宽度优先
     *
     * @param v 源顶点，即出发顶点
     */
    public static void BFS(Node v) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(v);     // 入队列
        while (!queue.isEmpty()) {
            Node node = queue.poll();   // 出队列并删除
            if (!visited.contains(node)) {
                System.out.println("Visit node:" + node.val);
                visited.add(node);
                for (Node next : node.neighbours) {
                    queue.offer(next);
                }
            }
        }
    }
}