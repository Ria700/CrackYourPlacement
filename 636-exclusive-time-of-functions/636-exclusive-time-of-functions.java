class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>(); // callStack
        int ans[] = new int[n];
        int lastTime = -1;
        for(String log: logs) {
            String data[] = log.split(":");
            int funcId = Integer.parseInt(data[0]);
            boolean isStart = "start".equals(data[1]);
            int timeStamp = Integer.parseInt(data[2]);
            
            if(!isStart) timeStamp+=1;
            
            if(!st.isEmpty()) {
                int currentFn = st.peek();
                ans[currentFn] += timeStamp-lastTime;
            }
            
            if(isStart) {
                st.push(funcId);
            } else {
                st.pop();
            }
            
            lastTime = timeStamp;
        }
        return ans;
    }
}