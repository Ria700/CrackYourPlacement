class FreqStack {
    HashMap<Integer, Stack<Integer>> map;
    HashMap<Integer, Integer> freqMap;
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
        maxFreq = Math.max(maxFreq, freqMap.get(val));
        addToMap(val);
    }
    
    public int pop() {
        Stack<Integer> st = map.get(maxFreq);
        int result = st.pop();
        freqMap.put(result, freqMap.get(result)-1);
        if(st.isEmpty()) {
            map.remove(maxFreq);
            maxFreq--;
        }
        return result;
    }
    
    private void addToMap(int val) {
        int freq = freqMap.get(val);
        Stack<Integer> st = map.getOrDefault(freq, new Stack<>());
        st.push(val);
        map.put(freq, st);
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */