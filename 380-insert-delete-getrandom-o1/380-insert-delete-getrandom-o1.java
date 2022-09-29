class RandomizedSet {

    HashMap<Integer, Integer> map; //val vs index
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
         if(map.containsKey(val)) return false;
        int index = list.size();
        map.put(val, index);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        if(index == list.size()-1) {
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        list.set(index, list.get(list.size()-1));
        list.remove(list.size()-1);
        
        map.put(list.get(index), index);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int rand = r.nextInt(list.size()); // exclusive
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */