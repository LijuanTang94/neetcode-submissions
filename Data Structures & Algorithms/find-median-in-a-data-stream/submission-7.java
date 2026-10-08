class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        large = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        balance(small, large);
    }

    private void balance(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        } else if (large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() == large.size()) return (small.peek() + large.peek()) / 2.0;
        else return small.size() > large.size() ? small.peek() : large.peek();
    }
}
