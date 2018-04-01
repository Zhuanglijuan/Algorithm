/**
 * Created by Zhuang on 2018/4/1.
 */
public class UnionFind3 {
    private int[] parent;
    private int[] rank;    //rank[i]表示以i为根的集合所表示的树的层数
    private int count;

    public UnionFind3(int count){
        parent = new int[count];
        this.count = count;
        rank = new int[count];
        for(int i = 0;i < count ; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p){
        assert p >= 0 && p <count;
        while(p != parent[p])
            p = parent[p];
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        return p;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected(int p,int q){
        return find(q) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

}
