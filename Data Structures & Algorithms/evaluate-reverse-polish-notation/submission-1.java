class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        // Using a standard index-based for loop
        for (int i = 0; i < tokens.length; i++) {
            
            // Grab the string at the current index
            String token = tokens[i];
            
            // 1. Check for operators
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            else if (token.equals("-")) {
                int right = stack.pop(); // The first pop is the RIGHT operand
                int left = stack.pop();  // The second pop is the LEFT operand
                stack.push(left - right);
            } 
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            else if (token.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            } 
            // 2. If it's not an operator, it must be a number
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only number left on the stack
        return stack.pop();
    }
}