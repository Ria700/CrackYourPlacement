class MyStack {
    Queue<Integer> main, helper;
    public MyStack() {
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }
    
    public void push(int x) {
        main.add(x);
    }
    
    public int pop() {
        int size = main.size();
        while(size-->1) helper.add(main.remove());
        int val = main.remove();
        main = helper;
        helper = new ArrayDeque<>();
        return val;
    }
    
    public int top() {
        int size = main.size();
        while(size-->1) helper.add(main.remove());
        int val = main.remove();
        helper.add(val);
        main = helper;
        helper = new ArrayDeque<>();
        return val;
    }
    
    public boolean empty() {
        return main.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */