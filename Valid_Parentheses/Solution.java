class Solution{



  public boolean isValid(String s) {

      if(s == null || s.length() == 0 || (s.length() %2 != 0)){
        return false;
      }

      Stack <Character>stack = new Stack<Character>();
      int len = s.length();

      for(int i = 0 ; i < len ; i++){

        char c = s.charAt(i);
        if(c == '(' || c == '{' || c == '['){
          stack.push(c);
        }else{

          if(stack.isEmpty()){
            return false;
          }

          char peekChar = stack.peek();
          if(peekChar == '(' && c == ')'){
            stack.pop();
          }else if(peekChar == '{' && c == '}'){
            stack.pop();
          }else if(peekChar == '[' && c == ']'){
            stack.pop();
          }
        }
      }
      if(stack.size() != 0){
        return false;
      }

      return true;
  }

}
