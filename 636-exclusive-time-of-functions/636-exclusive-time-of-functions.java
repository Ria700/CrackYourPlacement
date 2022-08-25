class meta {
    int id, stTime, wt;
    meta() {
        
    }
    meta(int a, int b, int c) {
        id = a;
        stTime = b;
        wt = c;
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
            
            if(isStart) st.push(new meta(funcId, timeStamp, 0));
            else {
                meta fn = st.pop();
                int ext = timeStamp-fn.stTime + 1 ;
                ans[fn.id] += ext- fn.wt;
                if(!st.isEmpty()) st.peek().wt += ext;
            }           
        }
        return ans;
    }
}