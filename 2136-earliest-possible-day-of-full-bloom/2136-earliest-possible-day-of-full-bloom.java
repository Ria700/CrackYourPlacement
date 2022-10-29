class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // we need the minimum plant time
        // max growth time is also ideal
        List<Integer> plants = new ArrayList<>();
        for(int i = 0; i < plantTime.length; i++) {
            plants.add(i); // add indices
        }
        // Collections.sort(plants, (a,b)-> plantTime[a]==plantTime[b]? growTime[b]-growTime[a] : plantTime[a]-plantTime[b]);
        Collections.sort(plants, (a,b)-> growTime[b]-growTime[a]);
        int max = 0, time = 0;
        for(int i = 0; i < plantTime.length; i++) {
            time += plantTime[plants.get(i)];
            if(time+growTime[plants.get(i)] > max) max = time+growTime[plants.get(i)];
        }
        return max;
    }
}