class Solution {
    List<Integer> ans;
    public int[] numsSameConsecDiff(int n, int k) {
        ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            helper(k, i, n-1, i);
        }
        int arr[] = new int[ans.size()];
        int idx = 0;
        for(int i: ans) {
            arr[idx++] = i;
        }
        return arr;
    }
    
    private void helper(int k, int prev, int rem, int num) {
        if(rem == 0) {
            ans.add(num);
            return;
        }
        
        for(int i = 0; i <= 9; i++) {
            if(Math.abs(prev-i) == k) {
                helper(k, i, rem-1, num*10+i);
            }
        }
    }
}