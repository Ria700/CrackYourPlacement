class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> list: wall) {
            int ps = 0;
            for(int i = 0;  i < list.size()-1; i++) { // travel only till the last element to avoid last line of cross = no need for width
                ps+=list.get(i);
                map.put(ps, map.getOrDefault(ps,0)+1);
            }
        }
        int maxGaps = 0;
        for(int i : map.keySet()) {
            if(map.get(i) > maxGaps) maxGaps = map.get(i);
        }
        
        return wall.size()-maxGaps;
    }
    
}