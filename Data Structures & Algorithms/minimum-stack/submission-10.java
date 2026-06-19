class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int value) {
        this.stack.addFirst(value);
        if (this.minStack.isEmpty() || value <= this.minStack.peekFirst()) {
            this.minStack.addFirst(value);
        }
    }
    
    public void pop() {
        if (this.stack.isEmpty()) return;

        int val = this.stack.removeFirst();
        if (this.minStack.peekFirst() == val) {
            this.minStack.removeFirst();
        }
    }
    
    public int top() {
        return this.stack.peekFirst();
    }
    
    public int getMin() {
        return this.minStack.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */