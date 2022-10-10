class RandomizedCollection {
    ArrayList<Integer> list;
    HashMap<Integer, HashSet<Integer>> map;
    Random r;
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        boolean flag = true;
        int idx = list.size();
        list.add(val);
        HashSet<Integer> set = map.getOrDefault(val, new HashSet<>());
        if(set.size() > 0) flag = false;
        set.add(idx);
        map.put(val, set);
        return flag;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        else {
            HashSet<Integer> set = map.get(val);
            int remi = 0;
            for(int i: set) {
                remi = i;
                break;
            }
            set.remove(remi);
            if(set.size() == 0) map.remove(val);
            if(remi == list.size()-1) {
                list.remove(list.size()-1);
                return true;
            }
            set.remove(remi);
            if(set.size() == 0) map.remove(val);
            int nval = list.get(list.size()-1);            
            HashSet<Integer> set2 = map.get(nval);
            set2.add(remi);
            set2.remove(list.size()-1);
            list.remove(list.size()-1);
            list.set(remi, nval);
            return true;
        }
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */