class Pair{
    String c;
    double val;
    
    Pair(String a, double b){
        c = a;
        val = b;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int k = 0;
        HashMap<String, ArrayList<Pair>> adj = new HashMap<>();
        for(List<String> list: equations){
            String u = list.get(0);
            String v = list.get(1);
            double wt = values[k];
            ArrayList<Pair> child = adj.getOrDefault(u, new ArrayList<>());
            child.add(new Pair(v, wt));
            adj.put(u, child);
            child = adj.getOrDefault(v, new ArrayList<>());
            child.add(new Pair(u, 1/wt));
            adj.put(v, child);
            k++;
        }
        
        double[] ans = new double[queries.size()];
        k = 0;
        for(List<String> list: queries){
            String u = list.get(0);
            String v = list.get(1);
            ans[k] = path(u, v, adj, 1, new HashSet<String>());
            k++;
        }
        
        return ans;
    }
    
    public double path(String src, String des, HashMap<String, ArrayList<Pair>> adj, double asf, HashSet<String> vis){
        if(!adj.containsKey(src)){
            return -1.0;
        }
        
        if(!adj.containsKey(des)){
            return -1.0;
        }
        
        if(src.equals(des)){
            return asf;
        }
        
        if(vis.contains(src)){
            return -1;
        }
        
        vis.add(src);
        double val = -1;
        for(Pair p: adj.get(src)){
            if(!vis.contains(p.c))
                val = path(p.c, des, adj, asf*p.val, vis);
            if(val!= -1.0) return val;
        }
        
        return -1;
    }
}