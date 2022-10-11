class Solution {
    class pair {
        char ch;
        int f;
        public pair(char a, int b) {
            ch = a;
            f = b;
        }
    }
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->(b.f-a.f));
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.add(new pair((char)('a'+i), freq[i]));
            }
        }
        StringBuilder ans = new StringBuilder();
        pair block = pq.poll();
        ans.append(block.ch);
        block.f--;
        while(pq.size() > 0) {
            pair temp = pq.poll();
            ans.append(temp.ch);
            temp.f--;
            if(block.f>0) pq.add(block);
            block = temp;
        }
        if(block.f>0) return "";
        return ans.toString();
        
    }
}