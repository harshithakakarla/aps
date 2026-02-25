import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone();  // copy original prices
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            
            // If current price is <= price at stack top
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] -= prices[i];
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}