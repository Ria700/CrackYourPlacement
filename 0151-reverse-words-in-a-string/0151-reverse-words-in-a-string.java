class Solution {
    public String reverseWords(String s) {
        int i=0;
        int j=0;
        s=' '+s;
        String str="";
        String snew="";
        for(int k=s.length()-1;k >= 0;k--){
            if(s.charAt(k)!=' ' && i==0){
                i = k;
            }
            if(s.charAt(k)==' ' && i!=0){
                j = k;
                str=s.substring(j+1,i+1);
                i=0;
                snew=snew+" "+str;
            }
        }  
        if(snew.length()!=0)
        snew=snew.substring(1);
        return snew;
    }
}