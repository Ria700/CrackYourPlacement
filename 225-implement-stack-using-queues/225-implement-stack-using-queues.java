class MyStack {
    Queue<Integer> main, helper;
    public MyStack() {
        main = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int size = main.size();
        while(size-->0) helper.add(main.remove());
        main.add(x);
        while(helper.size() > 0) main.add(helper.remove());
    }
    
    public int pop() {
        return main.remove();
    }
    
    public int top() {
        return main.peek();
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