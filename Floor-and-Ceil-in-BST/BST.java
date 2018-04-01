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

        public Node(Node node){
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
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
    public void preOrder(){
        preOrder(root);
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //层序遍历
    public void levelOrder(){

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

    //寻找最小键值
    public Key minimum(){
        assert (count != 0);
        Node minNode = minimum(root);
        return minNode.key;
    }

    //寻找最大键值
    public Key maximum(){
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    //从二叉树中删除最小值所在节点
    public void removeMin(){
        if(root != null)
            root = removeMin(root);
    }

    //从二叉树中删除最大值所在节点
    public void removeMax(){
        if(root != null){
            root = removeMax(root);
        }
    }

    //从二叉树中删除键值为key的节点
    public void remove(Key key){
        root = remove(root,key);
    }

    public Key floor(Key key){
        if(count == 0 || key.compareTo(minimum())<0)
            return null;
        Node floorNode = floor(root,key);
        return floorNode.key;

    }

    public Key ceil(Key key){
        if(count == 0 || key.compareTo(maximum()) > 0)
            return null;
        Node ceilNode = ceil(root,key);
        return ceilNode.key;
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
    private void preOrder(Node node){
        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //对以node为根的二叉树进行中序遍历
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    //对以node为根的二叉树进行后序遍历
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    //在以node 为根的二叉搜索树中，返回最小键值的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //在以node 为根的二叉搜索树中，返回最大键值的节点
    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }

    //删除以Node为根的二分搜素树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private  Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            count --;
            return rightNode;
        }
        node.left = removeMin(node.left);

        return node;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            count --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除以node为根的二分搜索树中键值为key的节点
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node,Key key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }
        else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }
        else{
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                count --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if( node.right == null ){
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            Node successor =new Node(minimum(node.right));
            count ++;
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count --;
            return successor;
        }
    }

    private Node floor(Node node,Key key){
        if(node == null)
            return null;

        if(node.key.compareTo(key)==0)
            return node;
        if(node.key.compareTo(key) > 0)
            return floor(node.left,key);

        Node tempNode = floor(node.right,key);
        if(tempNode != null)
            return tempNode;

        return node;
    }

    private Node ceil(Node node,Key key){
        if(node == null)
            return null;

        if(node.key.compareTo(key) == 0)
            return node;

        if(node.key.compareTo(key) < 0)
            return ceil(node.right,key);

        Node tempNode = ceil(node.left,key);
        if(tempNode != null)
            return tempNode;

        return node;
    }

    public static void main(String[] args) {

    }

}
