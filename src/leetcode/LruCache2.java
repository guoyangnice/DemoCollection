package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 本次代码不用现成的数据结构LinkedHashMap,借鉴lc中的官方回答
 *     作者：LeetCode-Solution
 *     链接：https://leetcode-cn.com/problems/lru-cache-lcci/solution/lruhuan-cun-by-leetcode-solution/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author yangjie
 */
public class LruCache2 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LruCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        //建立了两个空节点
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 添加键值对
     * @param key
     * @param value
     */
    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            ++size;
            if(size > capacity){
                //删除双向链表中的尾结点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 添加结点到头部,结点的断裂顺序问题注意下
     */
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移除结点
     * @param node
     */
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移到头部，相当于访问后，或者插入时
     * @param node
     */
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    /**
     * 这里删除的尾结点，实际上是删除倒数第二个结点，注意
     * @return
     */
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
