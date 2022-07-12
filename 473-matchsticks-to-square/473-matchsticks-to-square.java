class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        
        for (int i : matchsticks) {
            total += i;
        }
        
        if (total % 4 != 0) return false;
        
        Arrays.sort(matchsticks);
        
        return match(matchsticks, matchsticks.length-1, 0, 0, 0, 0, total/4);
    }
    
    private boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {
        
        if (top == target && bottom == target && left == target && right == target) return true;
        // 1) this way we dont have to check each sum
        // 2) we dont even need to check i == n bec we're comapring total target
        
        if (top > target || bottom > target || left > target || right > target) return false;
                        
        int val = matchsticks[index]; // index
        
        boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
        if (t) return true;
        boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
        if (b) return true;
        boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
        if (l) return true;
        boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
        if (r) return true;
        
        return false;
    }
    
//     private boolean kSubsets(int arr[], int k, int ss, List<List<Integer>> ans, int i){
//         if(i >= arr.length){
//             if(ss == k){
//                 int last = 0;
//                 for(List<Integer> sub: ans){
//                     int sum = 0;
//                     for(int j: sub) sum+=j;
//                     if(last == 0) last = sum;
//                     else if(sum != last) return false;
//                 }
//                 return true;
//             }
//             else 
//                 return false;
//         }
        
//         for(List<Integer> sub: ans){
//             if(sub.size() > 0){
//                 sub.add(arr[i]);
//                 if(kSubsets(arr, k, ss, ans, i+1)) return true;
//                 sub.remove(sub.size()-1);
//             }else{
//                 sub.add(arr[i]);
//                 if(kSubsets(arr, k, ss+1, ans, i+1)) return true;
//                 sub.remove(sub.size()-1);
//                 break;
//             }
//         }
//         return false;
//     }
}