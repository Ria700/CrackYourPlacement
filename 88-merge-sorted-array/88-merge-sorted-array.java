class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Brute Force
//         int i = 0, j = 0, k = 0;
//         int[] ans = new int[m+n];
//         while(i < m && j < n){
//             if(nums1[i] < nums2[j]){
//                 ans[k] = nums1[i];
//                 i++;
//             }else if(nums1[i] >= nums2[j]){
//                 ans[k] = nums2[j];
//                 j++;
//             }
//             k++;
//         }
        
//         while(i < m){
//             ans[k] = nums1[i];
//             i++;
//             k++;
//         }
        
//         while(j < n){
//             ans[k] = nums2[j];
//             j++;
//             k++;
//         }
        
//         k = 0;
//         while(k < m+n){
//             nums1[k] = ans[k];
//             k++;
//         }
        
        // Optimised
        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0){
           nums1[k--] = (nums1[i] > nums2[j]) ? // opp bec travelling from back
               nums1[i--] : nums2[j--]; 
        }
        
        while(j >= 0) {
           nums1[k--] = nums2[j--];
        }
    }
}