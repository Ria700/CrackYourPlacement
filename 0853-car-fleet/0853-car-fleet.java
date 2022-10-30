class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < position.length; i++) list.add(i);
        Collections.sort(list, (a,b) -> position[a] - position[b]);
        int ans = 1; // number of fleet // atleast 1 car
        int firstCarIndex = list.get(list.size()-1);
        double tt = (target-position[firstCarIndex])*1.0/speed[firstCarIndex];
        for(int i = list.size()-2; i >= 0; i--) {
            int index = list.get(i);
            double time = (target-position[index]*1.0)/speed[index];
            if(time > tt) { ans++; tt = time;}
        }
        return ans;
    }
}