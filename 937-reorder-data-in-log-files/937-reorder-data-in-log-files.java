class Solution {
    public String[] reorderLogFiles(String[] logs) {
//         Comparator<String> myComp = new Comparator<String>(){
//             @Override
//             public int compare(String o1, String o2) {
//                 String[] input1 = o1.split(" ", 2);
//                 String[] input2 = o2.split(" ", 2);

//                 boolean isDigit1 = Character.isDigit(input1[1].charAt(0));
//                 boolean isDigit2 = Character.isDigit(input2[1].charAt(0));
                
//                 if(!isDigit1 && !isDigit2) { // both are letter type data
//                     int ct = compare(input1[1], input2[1]); 
//                     if(ct != 0) return ct; // if both strings have the same data
//                     return compare(input1[0], input2[0]); // compare identifiers
//                 } else if(!isDigit1 && isDigit2){
//                     return -1; // letter input before digit
//                 } else if(isDigit1 && !isDigit2) {
//                     return 1;
//                 } else {
//                     return 0; // digits maintain their relative order
//                 }
//             }
//         };
        
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}