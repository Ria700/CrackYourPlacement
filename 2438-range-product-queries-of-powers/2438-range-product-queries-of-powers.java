class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int ans[] = new int[queries.length];
        ArrayList<Long> list = new ArrayList<>();
        char[] ch = Integer.toBinaryString(n).toCharArray();
        long pow = 1;
        for(int i = ch.length-1; i >= 0; i--) {
            if(ch[i]!='0') list.add(pow);
            pow*=2;
        }
        // System.out.println(list);
        int idx = 0;
        for(int[] row: queries) {
            long curr = 1;
            for(int i = row[0]; i <= row[1]; i++) {
                curr=((curr%1000000007)*list.get(i))%1000000007;
            }
            ans[idx] = (int)(curr%1000000007);
            idx++;
        }
    
        return ans;
    }
}