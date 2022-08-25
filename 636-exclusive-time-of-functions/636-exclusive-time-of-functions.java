class meta {
    int id, stTime;
    meta() {
        
    }
    meta(int a, int b) {
        id = a;
        stTime = b;
        // wt = c;
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<meta> st = new Stack<>(); // callStack
        int ans[] = new int[n];
        
        for(String log: logs) {
            String data[] = log.split(":");
            int funcId = Integer.parseInt(data[0]);
            boolean isStart = "start".equals(data[1]);
            int timeStamp = Integer.parseInt(data[2]);
            
            if(isStart) st.push(new meta(funcId, timeStamp));
            else {
                meta fn = st.pop();
                int ext = timeStamp-fn.stTime+1;
                ans[fn.id] += ext;
                if(!st.isEmpty()) ans[st.peek().id] -= ext;
            }           
        }
        return ans;
    }
}