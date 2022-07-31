// SEGMENT TREE - cant believe i could solve this question
// (Also July LeetCode Challenge Finale question)
class NumArray {
    // no Node needed - can just form tree using array(like heap)
    // static class Node {
    //     int val;
    //     Node left, right;
    //     Node(int val) {
    //         this.val = val;
    //     }
    // }
    
    // tree in form of array just like heap
    int tree[];
    // so that we can access `nums`
    int a[];
    // length of array - also max range
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        a = nums;
        tree = new int[n*4]; // extra nodes
        build(1, 0, n-1); // tree is 1-base indexed
    }
     // build segment tree
    public void build(int node, int low, int high) {
        if(low == high) {
            // base node
            tree[node] = a[low];
        } else if(low < high) {
            int left = node*2;
            int right = node*2+1;
            int mid = low + (high-low)/2;
            // bulid left
            build(left, low, mid);
            // bulid right
            build(right, mid+1, high);
            // build curr by just accessing the left and right nodes
            tree[node] = tree[left] + tree[right]; // plus or max or min... depending on ques
        }
    }
    
    // 1
    public void update(int index, int val) {
        _update(1, 0, n-1, index, val);
    }
    
    private void _update(int node, int st, int en, int index, int val) {
        if(st == en) {
            //update
            a[st] = val;
            tree[node] = val;
        } else {
            int mid = st + (en-st)/2;
            if(st <= index && index <= mid) {
                _update(node*2, st, mid, index, val);
            }else {
                _update(node*2+1, mid+1, en, index, val);
            }
            //backtrack update
            tree[node] = tree[node*2]+tree[node*2+1];
        }
    }
    
    // 2
    public int sumRange(int left, int right) {
        return _sumRange(1, 0, n-1, left, right);
    }
    
    // left and right are query - remains same through-out
    // st & en change for defining the curr (valid) range
    private int _sumRange(int node, int st, int en, int l, int r) {
        if(en < l|| st > r) return 0; // inavlid range
        else if(st == en) return tree[node]; // single node
        else if(l<=st && en<=r) return tree[node]; // lies within range
        // else - calculate for range
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