class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<String>();
        
        StringBuilder digitBuilder = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                    digitBuilder.append(c);
                    continue;
            }else{
                stack.push(digitBuilder.toString());
                digitBuilder = new StringBuilder();
            }
            
            if(c == ']'){
                StringBuilder builder = new StringBuilder();
                while(!stack.peek().equals("[")){
                    builder.append(stack.pop());
                }
                stack.pop();
                
                String temp = stack.pop();
                int value = Integer.parseInt(temp);
                String original = builder.toString();
                for(int j = 0 ; j < value-1 ; j++){
                    builder.append(original);
                }
                stack.push(builder.toString());
                continue;
            }
    
            String str = Character.toString(c);
            stack.push(str);
            
        }
        StringBuilder answerBuilder = new StringBuilder();
        
        while(!stack.isEmpty()){
            answerBuilder.append(stack.pop());
        }
        
        return answerBuilder.reverse().toString();
        
    }
}