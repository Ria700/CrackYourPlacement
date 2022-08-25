class CustomStack {
    int[] arr;
    int[] inc;
    int top;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        inc = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top+1 == arr.length) return;
        arr[++top] = x;
    }
    
    public int pop() {
        if(top == -1) return -1;
        int val = arr[top] + inc[top];
        if(top!=0) inc[top-1] += inc[top];
        inc[top] = 0;
        top--;
        return val;
    }
    
    public void increment(int k, int val) {
        if(top == -1) return;
        if(k-1 >= top) inc[top] += val;
        else inc[k-1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */