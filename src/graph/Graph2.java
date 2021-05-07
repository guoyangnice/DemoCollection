package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * BFS：与DFS不同的是，这里未使用递归
 * 因为广度搜索需要以本顶点开始遍历，而深度搜索的顶点是变化的
 * @author yangjie
 */
public class Graph2 {
    /**
     * 顶点数量
     */
    private int V;

    /**
     * 顶点集合
     */
    private LinkedList<Integer> adj[];

    Graph2(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     * @param v
     * @param w
     */
    void addEdge(int v,int w){
        adj[v].add(w);
    }

    void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + "");

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[])
    {
        Graph2 g = new Graph2(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("从定点2开始访问：");

        g.BFS(2);
    }
}
