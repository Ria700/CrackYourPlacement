class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxgaps = 0;
        for(List<Integer> row: wall) {
            int ps = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                ps += row.get(i);
                map.put(ps, map.getOrDefault(ps, 0) + 1);
                maxgaps = Math.max(map.get(ps), maxgaps);
            }
        }
        
        return wall.size() - maxgaps;
    }
}