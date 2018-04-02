/**
 * Created by Zhuang on 2018/4/1.
 */
//稠密图 - 邻接矩阵
public class DenseGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;// 是否为有向图
    private boolean[][] g;//图的具体数据

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w))
            return;

        g[v][w] = true;
        if (!directed)
            g[w][v] = true;

        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

}
