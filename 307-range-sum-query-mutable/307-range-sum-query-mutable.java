class NumArray {
//     static class Node {
//         int val;
//         Node left, right;
        
//         Node(int val) {
//             this.val = val;
//         }
//     }
    
    int tree[];
    int a[];
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        a = nums;
        tree = new int[n*4];
        build(1, 0, n-1);
    }
    
    public void build(int node, int low, int high) {
        if(low == high) {
            tree[node] = a[low];
        } else if(low < high) {
            int left = node*2;
            int right = node*2+1;
            int mid = low + (high-low)/2;
            build(left, low, mid);
            build(right, mid+1, high);
            tree[node] = tree[left] + tree[right];
        }
    }
    
    public void update(int index, int val) {
        _update(1, 0, n-1, index, val);
    }
    
    private void _update(int node, int st, int en, int index, int val) {
        if(st == en) {
            a[st] = val;
            tree[node] = val;
        } else {
            int mid = st + (en-st)/2;
            if(st <= index && index <= mid) {
                _update(node*2, st, mid, index, val);
            }else {
                _update(node*2+1, mid+1, en, index, val);
            }
            tree[node] = tree[node*2]+tree[node*2+1];
        }
    }
    
    public int sumRange(int left, int right) {
        return _sumRange(1, 0, n-1, left, right);
    }
    
    private int _sumRange(int node, int st, int en, int l, int r) {
        if(en < l|| st > r) return 0;
        else if(st == en) return tree[node];
        else if(l<=st && en<=r) return tree[node];
        int left = node*2;
        int right = node*2+1;
        int mid = st + (en-st)/2;
        return _sumRange(left, st, mid, l, r) + _sumRange(right, mid+1, en, l, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */