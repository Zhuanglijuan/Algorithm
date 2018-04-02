public class Main {

    // 测试无权图最短路径算法
    public static void main(String[] args) {

        String filename = "testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path dfs = new Path(g,0);
        System.out.print("DFS : ");
        dfs.showPath(6);

        ShortestPath bfs = new ShortestPath(g,0);
        System.out.print("BFS : ");
        bfs.showPath(6);
    }
}