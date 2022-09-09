class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] cor = new int[2];
        int state = 0;
        
        for(char c: instructions.toCharArray()) {
            if(c == 'G') {
                move(cor, state);
            } else {
                state = changeDir(c, state);
            }
        }
        
        return cor[0] == 0 && cor[1] == 0 || state > 0;
    }
    
    private void move(int[] cor, int state) {
        if(state == 0) {
            cor[1] += 1;
        } else if(state == 1) {
            cor[0] += 1;
        } else if(state == 2) {
            cor[1] -= 1;
        } else if(state == 3) {
            cor[0] -= 1;
        } 
    }
    
    private int changeDir(char c, int state) {
        if(c == 'L') {
            return ((state-1)+4)%4;
        } else {
            return (state+1)%4;
        }
    }
}