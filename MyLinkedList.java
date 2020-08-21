class Node1 {
    //Node: 节点(有data（保存数据）、next（保存下一个节点的地址（引用））)
    public int data;
    public Node1 next;//Node也是类型(引用)

    public Node1(int data) {
        this.data = data;//初始化
        //next初始化只能为null，无意义
    }
}

public class MyLinkedList {
    public Node1 head;

    public MyLinkedList() {

    }

    public MyLinkedList(Node1 head) {
        this.head = head;
    }

    //头插法
    public void addFirst1(int data) {
        Node1 node1 = new Node1(data);

        if(this.head == null) {
            this.head = node1;
            return;
        }
        node1.next = this.head;
        this.head = node1;
    }

    public void display() {
        Node1 cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    //删除所有指定节点(val)
    public void removeAll(int val) {
        Node1 cur = this.head;
        Node1 prev = this.head.next;

        while (prev != null) {
            if(prev.data == val) {
                cur.next = prev.next;
                prev = prev.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
            if(this.head.data == val) {
                this.head = this.head.next;
            }
        }
    }

    //回环列表的第一个节点
    public Node1 inCircle() {
        Node1 fast = this.head;
        Node1 slow = this.head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

