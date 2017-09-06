class Solution {
    
        final Map <String, List<String>> map = new HashMap<>();  
    
    public List<String> helper(String s, Set<String> wordDict){
        
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        List<String>result = new LinkedList<String>();
        if(wordDict.contains(s)){
            result.add(s);
        }
        
        for(int i = 1; i < s.length() ; i++){
            
            String left = s.substring(0,i);
            String right = s.substring(i);
            
            if(wordDict.contains(left) && containsSuffix(wordDict,right)){
                
                for(String ss : helper(right, wordDict)){
                    result.add(left + " " + ss);
                }
                
            }   
        }
        map.put(s,result);
        return result;
         
    }
    
    public boolean containsSuffix(Set <String>dict, String str){
        
        for(int i = 0 ; i < str.length() ; i++){
            if(dict.contains(str.substring(i))){
                return true;
            }
        }
        return false;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set <String>set = initialize(wordDict);
        return helper(s,set);
        
    }
    
    public Set<String> initialize(List <String>wordDict){
        
        Set <String>set = new HashSet<String>();  
        for(String str : wordDict){
            set.add(str);
        }
        return set;
    }
    
}