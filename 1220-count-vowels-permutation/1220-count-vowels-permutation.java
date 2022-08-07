class Solution {
    private HashMap<String, Long> map;
    private int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        long ans = 0;
        map = new HashMap<>();
        char charSet[] = new char[]{'a', 'e', 'i', 'o', 'u'};
        for(char c: charSet) {
            ans = (ans + helper(n-1, c))%MOD;
        }
        return (int)ans;
    }
    
    private long helper(int rem, char c) {
        if(rem == 0) return 1;
        
        String key = "" + rem + " " + c;
        if(map.containsKey(key)) return map.get(key);
        
        long total = 0;
        switch(c) {
            case 'a': total = helper(rem-1, 'e')%MOD;
                break;
            case 'e': total = (helper(rem-1, 'a') + helper(rem-1, 'i'))%MOD;
                break;
            case 'i': total = (helper(rem-1, 'a') + helper(rem-1, 'e') + helper(rem-1, 'o') + helper(rem-1, 'u'))%MOD;
                break;
            case 'o': total = (helper(rem-1, 'i') + helper(rem-1, 'u'))%MOD;
                break;
            case 'u': total = helper(rem-1, 'a')%MOD;
                break;
        }
        
        map.put(key, total);
        return total;
    }
}