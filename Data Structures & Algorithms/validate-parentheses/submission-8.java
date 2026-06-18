class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        Map<Character, Character> lookup = new HashMap<>();
        lookup.put(')', '(');
        lookup.put(']', '[');
        lookup.put('}', '{');

        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lookup.containsKey(c)) {
                if (!dq.isEmpty() && lookup.get(c) == dq.peekFirst()) {
                    dq.pollFirst();
                } else {
                    return false;
                }
            } else {
                dq.addFirst(c);
            }
        }

        return dq.isEmpty();
    }
}

/**
    given: 
        - s: string
            - containing '(', ')', '{', '}', '[', ']'

    determine if the input string is valid
 */