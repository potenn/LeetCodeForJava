
public class Solution {

    public int longestValidParentheses(String s) {
            
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int max = 0;
        int left = -1;
        
        Stack <Integer>stack = new Stack<Integer>();
        
        int len = s.length();
        
        for(int i = 0 ; i < len ; i++){
            
            char c = s.charAt(i);
            
            if(c == '('){
                
                stack.push(i);   
                
            }
            /*
            String중 ')' 이거일때 처리
            */
            else{
                
                if(stack.isEmpty()){
                    left = i;   
                }else{
                    
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i - left);
                    }else{
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        
        return max;
        
        
    }
}