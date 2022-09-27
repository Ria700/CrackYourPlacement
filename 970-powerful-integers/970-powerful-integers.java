class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        // TC analysis
        // int a = x == 1 ? bound : (int) (Math.log(bound) / Math.log(x));
        // int b = y == 1 ? bound : (int) (Math.log(bound) / Math.log(y));
        
        for(int i = 1; i < bound; i *= x) {
            for(int j = 1; i+j <= bound; j *= y) {
                set.add(i+j);
                if(y == 1) break;
            }
            if(x == 1) break;
        }
        return new ArrayList<>(set);
        
        // Exception case : x == 1 || y == 1
    }
}