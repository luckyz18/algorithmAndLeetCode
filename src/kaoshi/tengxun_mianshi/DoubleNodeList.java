package kaoshi.tengxun_mianshi;

public class DoubleNodeList<V> {
    private Node head;
    private Node tail;

    public DoubleNodeList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public  void moveNodeToTail(Node<V> node) {
        if (node == this.tail){
            return;
        }
        if (node == this.head) {
            head = head.next;
            head.last = null;
        } else {
            node.last.next = node.next;
            node.next.last = node.last;
        }
        this.tail.next = node;
        node.last = tail;
        node.next = null;
        this.tail = node;
    }

    public void addNodeToTail(Node newNode) {
        if (this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.last = tail;
            tail = newNode;
        }
    }

    public Node removeHead() {
        if (this.head == null) {
            return null;
        }
        Node res = this.head;
        if (res == tail) {
            this.head = null;
            this.tail = null;
        } else {
            head = res.next;
            head.last = null;
            res.next = null;
        }
        return res;
    }
}
