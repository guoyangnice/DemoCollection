package listnode;
//打牢基础，链表-20210327
public class SingleListNode {

    //结点结构
    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head;
    public SingleListNode(){
        this.head = head;
    }

    /**
     * 头插法
     * @param data
     */
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = head;
            head = node;
        }
    }

    /**
     * 尾插法-头不能动，需要记住尾
     * @param data
     */
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if(head == null){
            head = node;
        }else{
            //找到尾巴
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    /**
     * 检测下标是否合法
     * @param index
     */
    public void checkIndex(int index){
        if(index < 0 || index > getLength()){
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }

    /**
     * 获取链表长度
     * @return
     */
    public int getLength(){
        if(head == null){
            return 0;
        }
        int i = 0;
        Node cur = head;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        return i;
    }

    /**
     * 遍历显示
     */
    private void display() {
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 找到下标尾index-1位置的结点
     * @param index
     * @return
     */
    public Node searchIndex(int index){
        checkIndex(index);
        if(index == 0){
            return null;
        }
        Node cur = this.head;
        int i = 0;
        while(cur.next != null && i < index -1){
            cur = cur.next;
            i++;
        }
        return cur;
    }

    /**
     * 任意位置插入，第一数据结点为0号下标
     * @param index
     * @param data
     * @return
     */
    public boolean addIndex(int index ,int data){
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if(cur == null){
            node.next = head;
            this.head = node;
        }else{
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    public boolean contains(int key){
        Node cur = head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     *     找第一次出现的关键字为 key 的节点的前驱
     */
    private Node searchPre(int key) {
        // 1. 是不是第一个节点 if(head,data == key)
        Node pre = this.head;
        if (pre.data == key) {
            // 或者 return null;
            return this.head;
        }

        // 2. if(cur.next.data == key)
        while (pre.next != null) {
            if (pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }

        return null;
    }

    /**
     * 删除第一次出现的关键字为key的结点-先找再删
     * @param key
     * @return
     */
    public int remove(int key){
        int oldData = 0;
        Node pre = searchPre(key);

        if(pre == null){
            throw new UnsupportedOperationException("找不到key的前驱");
        }

        if(pre == this.head && pre.data == key){
            oldData = head.data;
            head = head.next;
            return oldData;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        return 0;
    }

    /**
     * 清空单链表以防内存泄漏
     */
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        SingleListNode mySingleList = new SingleListNode();
        mySingleList.addFirst(10);
        mySingleList.addFirst(20);
        mySingleList.addFirst(30);
        mySingleList.addFirst(40);
        mySingleList.addFirst(50);
        System.out.println("头插法：");
        mySingleList.display();
//        System.out.println("链表长度：" + mySingleList.getLength());

        mySingleList.addLast(100);
        mySingleList.addLast(200);
        System.out.println("尾插：");
        mySingleList.display();
        System.out.println();

        System.out.print("单链表的长度：");
        System.out.println(mySingleList.getLength());
        System.out.println();

        mySingleList.addIndex(1,15);
        System.out.println("任意位置插入：");
        mySingleList.display();
        System.out.println();

        System.out.println("删除第一次出现的关键字为 key 的节点：");
        System.out.println("删除头节点50：");
        mySingleList.remove(50); //删除头节点
        mySingleList.display();

        System.out.print("单链表的长度：");
        System.out.println(mySingleList.getLength());
        System.out.println();
    }

}
