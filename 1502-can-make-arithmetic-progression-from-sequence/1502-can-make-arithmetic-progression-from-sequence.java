class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr) {
            set.add(i);
            if(i < min) {
                smin = min;
                min = i;
            } else if(i < smin) smin = i;
        }

        int k = arr.length, a = min, cd = smin-min;
        if(cd == 0 && set.size() == 1) return true;
        while(k-->0) {
            if(!set.contains(a)) return false;
            set.remove(a);
            a += cd;
        }
        return true;
    }
}