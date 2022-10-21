class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int idx = 0;
        for(int i: nums) {
            ArrayList<Integer> list = map.getOrDefault(i, new ArrayList<>());
            list.add(idx++);
            map.put(i, list);
        }
        
        for(int key: map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            for(int i = 0; i < list.size()-1; i++) {
                if(Math.abs(list.get(i)-list.get(i+1)) <= k) return true;
            }
        }
        return false;
    }
}