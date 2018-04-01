package zlj.algo;

import java.util.LinkedList;

/**
 * Created by Zhuang on 2018/3/31.
 */

public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

    }

    private Node root;
    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Value search(Key key) {
        return search(root, key);
    }

    //前序遍历
    void preOrder(){
        preOrder(root);
    }

    //中序遍历
    void inOrder(){
        inOrder(root);
    }

    //后序遍历
    void postOrder(){
        postOrder(root);
    }

    //层序遍历
    void levelOrder(){

        // 我们使用LinkedList来作为我们的队列
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while( !q.isEmpty() ){

            //取出队首
            Node node = q.remove();

            System.out.println(node.key);

            //左右孩子分别入队
            if( node.left != null )
                q.add( node.left );
            if( node.right != null )
                q.add( node.right );
        }
    }

    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;
        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contain(node.left, key);
        else
            return contain(node.right, key);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    private Value search(Node node,Key key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            return node.value;
        }
        else if(key.compareTo(node.key) < 0){
            return search(node.left,key);
        }
        else {
            return search(node.right,key);
        }
    }

    //对以node为根的二叉树进行前序遍历
    void preOrder(Node node){
        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //对以node为根的二叉树进行中序遍历
    void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    //对以node为根的二叉树进行后序遍历
    void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    public static void main(String[] args) {

    }

}
