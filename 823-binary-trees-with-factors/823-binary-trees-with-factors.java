class Solution {
    private long MOD = (long)1e9 + 7;;
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> map = new HashMap(); // arr[i] vs its numBinaryTree
        long ans = 0;
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1L);
            for(int j = 0; j < i; j++) {
                if(arr[i]%arr[j] == 0) {
                    map.put(arr[i], (map.get(arr[i]) + map.get(arr[j]) * map.getOrDefault(arr[i]/arr[j],0L)%MOD));
                }
            }
            ans=(ans+map.get(arr[i]))%MOD;
        }    
        return (int)ans;
    }
}

// didnt use
    // int n = arr.length;
    // int dp[] = new int[n];
    // map.add(1, 1);
// for(int i: map.keySet()) System.out.println(i+" "+map.get(i));
        