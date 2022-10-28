class Solution {
    public int largestInteger(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        
        //Calculate the frequency of each digit from 0 - 9
        int[] frequency = new int[10];
        for (int index = 0; index < nums.length; index++) {
            frequency[nums[index] - '0']++;
        }
        
        int newNumber = 0;
        int evenIndex = 8; // corresponds to the number 8 
        int oddIndex = 9; // corresponds to the number 9 

        // construct the number
        for(int index = 0; index < nums.length; index++) {
            // If the parity of number in current index is even
            if(nums[index] % 2 == 0) {
                // Get first even digit of non-zero frequency
                while(frequency[evenIndex]==0) {
                    evenIndex -= 2;
                }
                frequency[evenIndex]--;
                newNumber = newNumber*10 + evenIndex;
            } else {
                // If the parity of number in current index is odd
                // Get first odd digit of non-zero frequency
                while(frequency[oddIndex]==0) {
                    oddIndex -= 2;
                }
                frequency[oddIndex]--;
                newNumber = newNumber*10 + oddIndex;
            }
        }
       
        return newNumber;
    }
}