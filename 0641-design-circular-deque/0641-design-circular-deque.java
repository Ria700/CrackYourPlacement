class Node {
    int data;
    Node next, prev;
    
    Node(int d) {
        data = d;   
    }
}
class MyCircularDeque {

    Node head, tail, prev;
    int k, size;
    public MyCircularDeque(int k) {
        head = null;
        tail = null;
        tail = null;
        this.k = k;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if(size == k) return false;
        Node node = new Node(value); 
        if(head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == k) return false;
        Node node = new Node(value); 
        if(head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(head == null) return false;
        else if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(head == null) return false;
        else if(head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return head.data;
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return tail.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */