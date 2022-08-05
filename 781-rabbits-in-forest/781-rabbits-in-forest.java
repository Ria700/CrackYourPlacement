class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rab = 0;
        for(int i: answers) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int i: map.keySet()) {
            int groupSize = i+1;
            rab += Math.ceil(map.get(i)*1.0/groupSize) // ceil // 1.0 for val < gs
                            // no of groups
            * groupSize; 
        }
        return rab;
    }
}