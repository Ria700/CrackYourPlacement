class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            int rem = i%k;
            if(rem<0) rem+=k;
            // int rem = ((i%k)+k)%k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        
        for(int i: map.keySet()) {
            if(i == 0 || (k%2==0 && i==k/2)) {
                if(map.get(i)%2!=0) return false;
            }else{
                int f1 = map.get(i);
                int f2 = map.getOrDefault(k-i, -1);
                if(f1==-1 || f2!=f1) return false;
                // else map.remove(k-i);
            }
        }
        
        return true;
    }
}