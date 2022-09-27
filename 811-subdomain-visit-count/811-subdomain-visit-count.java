class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: cpdomains) {
            String[] arr = s.split(" ", 2);
            int num = Integer.parseInt(arr[0]);
            ArrayList<String> domains = function(arr[1]);
            for(String domain: domains) {
                map.put(domain, map.getOrDefault(domain,0)+num);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(String s: map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(s));
            sb.append(" ");
            sb.append(s);
            ans.add(sb.toString());
        }
        
        return ans;
    }
    
    private ArrayList<String> function(String s) {
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        int idx = 0;
        for(char c: s.toCharArray()) {
            if(c == '.') {
                list.add(s.substring(idx+1));
            }
            idx++;
        }
        return list;
    }
}