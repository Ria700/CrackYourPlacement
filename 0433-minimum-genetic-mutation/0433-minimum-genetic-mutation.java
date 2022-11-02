class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        int level = 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(q.size() > 0) {
            int size = q.size();
            while(size-->0) {
                String rem = q.remove();
                if(rem.equals(end)) return level;
                if(seen.contains(rem)) continue;
                seen.add(rem);
                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < rem.length(); i++) {
                        String neighbor = rem.substring(0, i) + c + rem.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            q.add(neighbor);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}