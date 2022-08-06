class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : deck) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int gcd = 0;
        if(map.size() < 1) return false;
        for(int i: map.keySet()) {
            gcd = GCD(gcd, map.get(i));
        }
        if(gcd == 1) return false; 
        return true;
    }
    
    private int GCD(int a, int b) {
        if(a == 0) return b;
        return GCD(b%a, a);
    }
}