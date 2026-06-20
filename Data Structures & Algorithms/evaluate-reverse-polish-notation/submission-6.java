class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int b = stack.pollFirst();
                int a = stack.pollFirst();
                stack.addFirst(a + b);
            } else if (t.equals("-")) {
                int b = stack.pollFirst();
                int a = stack.pollFirst();
                stack.addFirst(a - b);
            } else if (t.equals("*")) {
                int b = stack.pollFirst();
                int a = stack.pollFirst();
                stack.addFirst(a * b);
            } else if (t.equals("/")) {
                int b = stack.pollFirst();
                int a = stack.pollFirst();
                stack.addFirst(a / b);
            } else {
                stack.addFirst(Integer.parseInt(t));
            }
        }

        return stack.peekFirst();
    }

    private boolean isNumber(String str) {
        if (str == null || str.isBlank()) return false;

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

/**
    given:
    - tokens: String[]

    evaluate the expression.
    return an integer that represents the value of the expression

    valid operators: "+", "-", "*", "/"
    each operand may be an integer or another expression
    
    e.g.
    tokens = ["2","1","+","3","*"], output = 9

 */