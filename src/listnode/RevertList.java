package listnode;

public class RevertList {
    public ListNode revertListNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = revertListNode(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class ListNode{
    public ListNode next;
    private int val;

    public ListNode(){

    }

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }
}