import java.util.Vector;

/**
 * Created by Zhuang on 2018/4/1.
 */
//稀疏图 - 邻接表
public class SparseGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;// 是否为有向图
    private Vector<Integer>[] g;//图的具体数据

    public SparseGraph(int n,boolean directed){
        this.n = n;
        this.m = 0;//初始化时没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Integer>[])new Vector[n];
        for(int i = 0 ; i < n ; i ++)
            g[i] = new Vector<Integer>();
    }

    //返回节点个数
    public int V() {
        return n;
    }

    //但会边的个数
    public int E() {
        return m;
    }

    //向图中添加一个边
    public void addEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);

        if(v != w && !directed)
            g[w].add(v);

        m ++;
    }

    //判断图中是否有从v到w的边
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for( int i = 0 ; i < g[v].size() ; i ++ )
            if( g[v].elementAt(i) == w )
                return true;
        return false;
    }
}
