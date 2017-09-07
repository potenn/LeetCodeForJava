public class Solution {
    
    public int minDistance(String word1, String word2) {
        
        int word1Len = word1.length();
        int word2Len = word2.length();
        
        
        
        int cost[][] = new int[word1Len + 1][word2Len + 1];
        for(int i = 0 ; i <= word1Len ; i++){
            cost[i][0] = i;
        }
        for(int i = 0 ; i <= word2Len ; i++){
            cost[0][i] = i;
        }
        
        for(int i = 0 ; i < word1Len ; i++){
            
            for(int j = 0 ; j < word2Len ; j++){
                
                if(word1.charAt(i) == word2.charAt(j)){
                    cost[i+1][j+1] = cost[i][j];   
                }else{
                    
                    int replace = cost[i][j] + 1;
                    int insert = cost[i][j + 1] + 1;
                    int delete = cost[i+1][j] + 1;
                    int min = replace > insert ? insert : replace;
				    min = delete > min ? min : delete;
                    cost[i + 1][j + 1] = min;
                }
            }
            
        }
        
        return cost[word1Len][word2Len];
        
    }
}