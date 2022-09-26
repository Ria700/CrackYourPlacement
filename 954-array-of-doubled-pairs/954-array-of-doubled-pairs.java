class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        ArrayList<Integer> a = new ArrayList(map.keySet());
        
        Collections.sort(a);
        
        for(int i: a) {
            if(map.get(i) != 0) {
                int key = 2*i;
                if(i < 0 && i%2 != 0) return false;
                if(i < 0) key = i/2;
                if(map.getOrDefault(key, 0) < map.get(i)) return false;
                map.put(key, map.get(key)-map.get(i));
            } 
        }
        return true;
    }
}