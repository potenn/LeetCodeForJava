class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        if(s.length() == 0 && t.length() == 0){
            return false;
        }
        if(s.equals(t)){
            return false;
        }
        
        if(s.length() == t.length()){
            return oneEditReplace(s,t);
        }else if(s.length() + 1 == t.length()){
            return oneEditInsert(s,t);
        }else if(s.length() - 1 == t.length()){
            return oneEditInsert(t,s);
        }
        
        return false;
    }
    
    public boolean oneEditReplace(String s, String t){
        
        boolean foundDifference = false;
        int len = s.length();
        for(int i = 0 ; i < len ; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
    //s에 문자하나 삽입해서 t로 만들기 
    public boolean oneEditInsert(String s, String t){
        
        int sIndex = 0;
        int tIndex = 0;
        
        while(tIndex < t.length() && sIndex < s.length()){
            
            if(t.charAt(tIndex) != s.charAt(sIndex)){
                
                if(sIndex != tIndex){
                    return false;
                }
                tIndex++;
            }else{
                tIndex++;
                sIndex++;
            }
        
        }
        
        return true;
        
    }
    
    
}