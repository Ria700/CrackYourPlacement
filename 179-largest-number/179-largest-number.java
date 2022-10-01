class Solution {
    public String largestNumber(int[] nums) {
        // sorting on the basis of first digit
        // convert int array to String array - > 
            // java Arrays.sort() sorts string array in lexographically order
            // ie [3,30,34,5,7,9] => 3 30 34 5 7 9
            // except: THERE IS A PROBLEM: sometimes direct lexographical order doesnt work. For example: [3, 32] max number = 332 nor 323.
            // so to check this we can:
            // Either check the whole strings
            // Or APPEND AND CHECK!!
        
        String[] arr = new String[nums.length];
        int k = 0;
        for(int i: nums) {
            arr[k++] = i+"";
        }
        Arrays.sort(arr, (a, b) -> {
            long n1 = Long.parseLong(a+b);
            long n2 = Long.parseLong(b+a);
            if(n1 > n2) return 1;
            else return -1;
        });
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
    
    
}