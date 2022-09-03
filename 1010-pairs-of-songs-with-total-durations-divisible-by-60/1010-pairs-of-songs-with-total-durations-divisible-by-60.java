class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long count = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i: time) {
            int rem = i%60;
            map.put(rem, map.getOrDefault(rem, 0L)+1);
        }
        for(int i: map.keySet()) {
            int find = 60-i;
            if(i == 0 || i == find) {
                count += map.get(i)*(map.get(i)-1)/2;
                // map.remove(0);
                continue;
            }
            
            if(find<i) continue;
            if(map.containsKey(find))               
                count+= (map.get(i)*map.get(find));
            // map.remove(i);
            // map.remove(find);
        }
        return (int)(count);
    }
}