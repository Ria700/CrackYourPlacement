class MyCalendar {
    ArrayList<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(calendar.size() == 0) {
            calendar.add(new int[]{start, end});
            return true;
        }
        
        if(calendar.size() == 1) {
            int prev[] = calendar.get(0);
            if((prev[1] > start && prev[0] < start) || (end > prev[0] && end <= prev[1])) {
                return false;
            }   
            if(prev[0] >= end) calendar.add(0, new int[]{start, end});
            else calendar.add(new int[]{start, end});
            return true;
        }
        
        int i = 0;
        while(i < calendar.size() && calendar.get(i)[0]<start){
            i++;
        }
        if(i == 0) {
            if(end <= calendar.get(0)[0]) {
                calendar.add(0, new int[]{start, end});
                return true;
            }
            else return false;
        }
        
        if(i == calendar.size()) {
            if(start >= calendar.get(calendar.size()-1)[1]) {
                calendar.add(new int[]{start, end});
                return true;
            }
            else return false;
        }
        int prev[] = calendar.get(i-1);
        int next[] = calendar.get(i);
        if(prev[1] <= start && end <= next[0]) {
            calendar.add(i, new int[]{start, end});
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */