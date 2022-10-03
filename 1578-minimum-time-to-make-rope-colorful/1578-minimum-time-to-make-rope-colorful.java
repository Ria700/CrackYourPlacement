class Solution {
    public int minCost(String colors, int[] neededTime) {
        char prev = '*';
        int costprev = 0;
        int ans = 0;
        int i = 0;
        for(char c: colors.toCharArray()) {
            if(c == prev) {
                if(costprev < neededTime[i]) {
                    ans+=costprev;
                    costprev = neededTime[i];
                }
                else ans+=neededTime[i];
            } else {
                prev = c;
                costprev = neededTime[i];
            }
            i++;
        }
        return ans;
    }
    
//  Trash
//     public int minCost(String colors, int[] neededTime) {
//         StringBuilder sb = new StringBuilder(colors);
//         return helper(sb, 0, neededTime);
//     }
    
//     private int helper(StringBuilder sb, int i, int[] time) {
//         int op1 = 0, op2 = 0;
//         op1 = helper(sb, i+1, time);
//         if(i > 0 && sb.charAt(i) == sb.charAt(i-1)) {
//             sb.deleteCharAt(i);
//             op1 = time[i] + helper(sb, i, time);
//         }
//         StringBuilder nsb = new StringBuilder(sb);
//         nsb.deleteCharAt(i);
//         op2 = time[i] + helper(nsb, i, time);
        
//         return Math.min(op1, op2);
//     }
}