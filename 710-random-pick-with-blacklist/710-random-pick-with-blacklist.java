class Solution {
    HashMap<Integer, Integer> map;
    Random r;
    int limit;
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        limit = n-blacklist.length;
        int idx = limit;
        HashSet<Integer> set = new HashSet<>();
        for(int i: blacklist) {
            set.add(i);
        }
        for(int i: blacklist) {
            if(i < limit) {
                while(set.contains(idx)) idx++;
                map.put(i, idx);
                idx++;
            }
        }
    }
    
    public int pick() {
        int ridx = r.nextInt(limit); //exclusive
        if(map.containsKey(ridx)) return map.get(ridx);
        else return ridx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */