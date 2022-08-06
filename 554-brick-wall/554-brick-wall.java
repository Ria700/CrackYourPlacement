class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int width = 0;
        for(int i: wall.get(0)) {
            width+=i;
        }
        for(List<Integer> list: wall) {
            int ps = 0;
            for(int i: list) {
                ps+=i;
                if(ps < width) map.put(ps, map.getOrDefault(ps,0)+1);
            }
        }
        int maxGaps = 0;
        // for(int i = 1; i < width; i++) {
        //     if(map.getOrDefault(i,0) > max) max = map.get(i);
        // }
        for(int i : map.keySet()) {
            if(map.get(i) > maxGaps) maxGaps = map.get(i);
        }
        
        return wall.size()-maxGaps;
    }
    
}