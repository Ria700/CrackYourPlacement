class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int i = triangle.size()-1;
        List<Integer> data = triangle.get(i--);
        while(i>=0){
            List<Integer> list = triangle.get(i--);
            List<Integer> currdata = new ArrayList();
            for(int j = 0; j < list.size(); j++){
                currdata.add(list.get(j) + Math.min(data.get(j), data.get(j+1)));
            }
            data = currdata;
        }
        return data.get(0);
    }
}