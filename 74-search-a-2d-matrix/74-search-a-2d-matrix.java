class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int st = 0, en = m-1, mid = 0;
        while(st <= en) {
            mid = st + (en-st)/2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] < target) {
                if(mid == m-1 || matrix[mid+1][0] > target)
                    break;
                else st = mid+1;
            } else en = mid-1;
        }
        
        return binarySearch(matrix[mid], target);
    }
    
    private boolean binarySearch(int[] arr, int target) {
        int st = 0, en = arr.length-1;
        while(st <= en) {
            int mid = st + (en-st)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) en = mid-1;
            else st = mid+1;
        }
        return false;
    }
}