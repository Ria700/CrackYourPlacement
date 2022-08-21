class MinStack {
    Stack<Integer> main = new Stack<>(), min = new Stack<>();
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);
        if(min.isEmpty()) min.push(val);
        else if(min.peek() >= val) min.push(val);
    }
    
    public void pop() {
        if(main.isEmpty()) return;
        int one = main.peek();
        int two = min.peek();
        if(one == two) min.pop();
        main.pop();
    }
    
    public int top() {
        if(main.isEmpty()) return -1;
        return main.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */