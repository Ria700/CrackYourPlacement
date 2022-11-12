class MedianFinder {
    PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        minheap = new PriorityQueue<>(); // larger ele
        maxheap = new PriorityQueue<>(Collections.reverseOrder()); // smaller ele
    }
    
    public void addNum(int num) {
        if(maxheap.size() == 0 || num <= maxheap.peek()) maxheap.add(num);
        else minheap.add(num);
        balance();
    }
    
    public double findMedian() {
        if(maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else {
            return (maxheap.peek()+minheap.peek()*1.0)/2;
        }
    }
    
    private void balance() {
        if(maxheap.size() > minheap.size()+1) {
            minheap.add(maxheap.poll());
        }
        else if(maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */