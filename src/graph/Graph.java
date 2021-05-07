package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * DFS-深度遍历算法
 *
 * @author yangjie
 */
public class Graph {
    private int V;

    /**
     * 顶点集合
     */
    private LinkedList<Integer> adj[];

    Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边
     * @param v
     * @param w
     */
    void addEdge(int v, int w){
        adj[v].add(w);
    }

    /**
     * DFS
     * @param v
     * @param visited
     */
    void DFSUtil(int v,boolean visited[]){
        visited[v] = true;
        System.out.println(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    /**
     * 深度遍历
     * @param v
     */
    void DFS(int v){
        boolean[] visited = new boolean[V];
        DFSUtil(v,visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("从顶点2开始遍历：");
        g.DFS(2);


    }
}
