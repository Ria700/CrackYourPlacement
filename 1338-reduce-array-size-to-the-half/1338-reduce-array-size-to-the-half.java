class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int n = arr.length;
        ArrayList<Integer> a = new ArrayList(map.values());
        Collections.sort(a);
        int i = 0, sum = 0; // sum of frequencies
        for(i = a.size()-1; i >= 0; i--) {
            sum+=a.get(i);
            if(sum >= n/2) break;
        }
        return a.size()-i;
    }
}