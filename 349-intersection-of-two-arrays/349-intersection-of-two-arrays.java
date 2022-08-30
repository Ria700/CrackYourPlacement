class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j] && (ans.size() == 0 ||  nums1[i] != ans.get(ans.size()-1))) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        Integer[] objects = ans.toArray(new Integer[ans.size()]);
  
        int k = 0;
        int[] arr = new int[ans.size()];
        for (Integer obj : objects)
            arr[k++] = obj;
//         return ans.toArray(new int[ans.size()]);
        return arr;
    }
}