class LRUCache {

    class Node {
        int key, val;
        Node prev, next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node head = null, tail = null;
    int size;
    
    HashMap<Integer, Node> map;
        // key vs address HashMap
    
    int cap;
    
    public LRUCache(int capacity) {
        // head = null;
        // tail = null;
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node nn = map.get(key);
            makeMostRecent(nn);
            return nn.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node nn = map.get(key);
            nn.val = value;
            makeMostRecent(nn);
        } else {
            Node nn = new Node(key, value);
            addLast(nn);
            map.put(key, nn);
            
            if(size > cap) {
                map.remove(head.key);
                removeFirst();
            }
        }
    }
    
    private void makeMostRecent(Node node) {
        if(size > 1) {
            removeNode(node);
            addLast(node);
        }
    }
    
    private void removeNode(Node node) {
        if(size == 0) return;
        
        if(node == head) {
            removeFirst();
        }
        else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
            size--;
        } else {
            Node inm1 = node.prev;
            Node inp1 = node.next;
            
            inm1.next = inp1;
            inp1.prev = inm1;
            
            node.next = node.prev = null;
            
            size--;
        }
    }
    
    private void addLast(Node node) {
        if(size == 0) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    
    private void removeFirst() {
        if(size == 0) return;
        
        if(size == 1) head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */