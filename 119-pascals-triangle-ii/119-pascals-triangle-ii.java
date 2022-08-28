class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans= new ArrayList<Integer>();
        long prev= 1;
        ans.add((int)prev);
        int n = rowIndex, r=0;
        while(r < n) {
            long next = prev * (n-r) / (r+1);
            ans.add((int) next);
            prev = next;
            r++;
        }
        return ans;
    }
}