class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int k = 0;
        for(char c: arr) {
            map.put(c, k);
            k++;
        }
        int maxRange = 0;
        int i = 0, j = 0;
        while(j < arr.length) {
            maxRange = map.get(arr[i]);
            while(j < arr.length && j < maxRange) {
                char curr = arr[j];
                maxRange = Math.max(maxRange, map.get(curr));
                j++;
            }
            ans.add((j-i+1));
            i = j+1;
            j = i;
        }
        return ans;
    }
}