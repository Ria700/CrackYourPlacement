class Solution {
    public int romanToInt(String s) {
        char a[] = s.toCharArray();
        int integ = getVal(a[a.length-1]);
        for(int i = 0; i < a.length-1; i++) {
            if(getVal(a[i]) >= getVal(a[i+1])) integ+=getVal(a[i]);
            else integ-=getVal(a[i]);
        }
        return integ;
    }
    
    private int getVal(char ch) {
        switch(ch){
            case 'I': return 1; 
            case 'V': return 5; 
            case 'X': return 10; 
            case 'L': return 50; 
            case 'C': return 100; 
            case 'D': return 500; 
            case 'M': return 1000; 
            default: return -1;
        }
    }
}