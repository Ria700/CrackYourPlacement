class pair {
    int price, day;
    
    pair(int a, int b) {
        price = a;
        day = b;
    }
}

class StockSpanner {
    Stack<pair> st;
    int day = 0;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        day++;
        
        while(!st.isEmpty() && st.peek().price <= price) st.pop();
        
        // ans forming
        int ans = 1; 
        if(st.isEmpty()) ans = day;
        else ans = day-st.peek().day;
        
        st.push(new pair(price, day));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */