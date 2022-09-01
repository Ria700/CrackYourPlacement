class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int index = ceil(arr, x);
        if(index > arr.length) {
            // add add elements from n-k to n-1
            for(int i = n-k; i < n; i++) ans.add(arr[i]);
            return ans;
        } else if(index == 0) {
            for(int i = 0; i < k; i++) ans.add(arr[i]);
            return ans;
        } else {
            int i = index-1, j = index;
            while(ans.size() < k && i >= 0 && j < n) {
                if(Math.abs(x-arr[i]) <= Math.abs(x-arr[j])) {
                    ans.add(arr[i]);
                    i--;
                } else {
                    ans.add(arr[j]);
                    j++;
                }
            }
            
            if(ans.size() < k) {
                if(i >= 0) {
                    while(ans.size() < k) {
                        ans.add(arr[i]);
                        i--;
                    }
                } else {
                    while(ans.size() < k) {
                        ans.add(arr[j]);
                        j++;
                    }
                }
            }
        }
        Collections.sort(ans);
        // System.out.println(index);
        
        return ans;
    }
        
    public int ceil(int[] arr, int x){
        int st = 0, en = arr.length-1; 
        
        while(st <= en){
            int mid = st + (en-st)/2;
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] > x){
                en = mid-1;
            }else{
                st = mid+1;
            }
        }
        return st;
    }
}