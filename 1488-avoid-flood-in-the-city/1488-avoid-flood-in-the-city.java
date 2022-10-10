class Solution {
    public int[] avoidFlood(int[] rains) {
        // smth that wont work - counting elements & no rain days
            // we need to empty the lakes before it rains again on them

        // LinkedList not working either
           // [0,1,1]
            // Output
            // [1,-1,-1]
            // Expected
            // []
        
        // HashMap<Integer, Integer> map = new HashMap<>();
        // LinkedList<Integer> list = new LinkedList<>();
        // int idx = 0;
        // int[]ans=new int[rains.length];
        // Arrays.fill(ans, 1);
        // for(int i: rains) {
        //     if(i == 0) {
        //         list.add(idx);
        //     } else {
        //         ans[idx] = -1;
        //         if(map.containsKey(i)) {
        //             if(map.get(i)) {
        //                 if(list.size()==0) return new int[]{};
        //                 else {
        //                     int j = list.peek();
        //                     while(list.size() > 0 && j < map.get(i)) // problem!!!!
        //                         j = list.removeFirst();
        //                     ans[j]=i;
        //                 }
        //             }
        //         } else {
        //             map.put(i, true);
        //         }
        //     }
        //     idx++;
        // }
        // return ans;
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int idx = 0;
        int[]ans=new int[rains.length];
        Arrays.fill(ans, 1);
        for(int i: rains) {
            if(i == 0) {
                set.add(idx);
            } else {
                Integer id = map.get(i);
                if(id == null) {
                    map.put(i, idx);
                } else {
                    Integer dtd = set.higher(id);
                    
                    if(dtd == null) {
                        return new int[0];
                    }
                    ans[dtd] = i;
                    set.remove(dtd);
                    
                    map.put(i, idx);
                }
                ans[idx] = -1;
            }
            idx++;
        }
        return ans;
    }
}