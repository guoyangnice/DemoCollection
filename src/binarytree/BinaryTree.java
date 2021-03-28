package binarytree;

public class BinaryTree {
    class BinaryTreeNode{
        private int data;
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BinaryTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BinaryTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public BinaryTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }

    private BinaryTreeNode root;
    public BinaryTree(){}

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    /**
     * 清除某个子树的所有节点
     * @param node
     */
    public void clear(BinaryTreeNode node){
        if(node != null){
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node =null;
        }
    }

    public void clear(){
        clear(root);
    }

    /**
     * 判断二叉树是否为空
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 求二叉树的高度
     * @return
     */
    public int height(BinaryTreeNode root){
        return root == null ? 0 : Math.max(height(root.getLeftChild()),height(root.getRightChild())) +1;
    }

    /**
     * 获取二叉树的节点数
     * @param node
     * @return
     */
    public int size(BinaryTreeNode node){
        if(node == null){
            return 0;
        }else{
            return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
        }
    }

    /**
     * 获取某个节点的左子树
     * @param node
     * @return
     */
    public BinaryTreeNode getLeftTree(BinaryTreeNode node){
        return node.getLeftChild();
    }

    public BinaryTreeNode getRightTree(BinaryTreeNode node){
        return node.getRightChild();
    }

    /**
     * 插入左节点
     * @param parent
     * @param newnode
     */
    public void insertLeft(BinaryTreeNode parent,BinaryTreeNode newnode){
        parent.setLeftChild(newnode);
    }

    /**
     * 插入右节点
     * @param parent
     * @param newnode
     */
    public void insertRight(BinaryTreeNode parent,BinaryTreeNode newnode){
        parent.setRightChild(newnode);
    }

    /**
     * 先序遍历-根左右
     * @param root
     */
    public void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.getData());
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    /**
     * 中序遍历-左根右
     * @param root
     */
    public void inOrder(BinaryTreeNode root){
        if(root != null){
            preOrder(root.getLeftChild());
            System.out.println(root.getData());
            preOrder(root.getRightChild());
        }
    }

    /**
     * 后序遍历-左右根
     * @param root
     */
    public void postOrder(BinaryTreeNode root){
        if(root != null){
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            System.out.println(root.getData());
        }
    }
}
