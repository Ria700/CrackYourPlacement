class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for(int i: arr) {
            set.add(i);
            if(i < min) {
                smin = min;
                min = i;
            } else if(i < smin) {
                smin = i;
            }
        }
        
        int cd = smin-min, a = min;
        if(cd == 0 && set.size() == 1) return true;
        int k = arr.length;
        while(k-->0) {
            if(!set.contains(a)) return false;
            set.remove(a);
            a+=cd;
        }
        
        return true;
    }
}