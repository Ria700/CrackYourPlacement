class Solution {
    public int nextGreaterElement(int m) {
        long n = m;
        int[] count = new int[10];
        int curr = -1;
        int prev = -1;
        
        while(n > 0) {
            curr = (int)n%10;
            n/=10;
            count[curr]++;
            if(curr < prev) {
                int num = curr+1;
                while(count[num] == 0) num++;
                count[num]--;
                n = n*10 + num;
                
                for(int i = 0; i < 10; i++) {
                    while(count[i]-- > 0) {
                        n = n*10 + i;
                    }
                }
                return n > Integer.MAX_VALUE ? -1 : (int)n;
            }
            prev = curr;
        }
        return -1;
    }
}