public class Solution {
    public int coinChange(int[] coins, int amount) {


            	int dp[] = new int[amount+1];
    	for(int i = 1 ; i <= amount ; i++){
    		dp[i] = Integer.MAX_VALUE-1;
    	}

    	for(int j = 0 ; j < coins.length ; j++){

    		for(int i = 1 ; i <= amount ; i++){

    			if(i >= coins[j]){

    				if(dp[i-coins[j]] + 1 < dp[i]){
    					dp[i] = dp[i-coins[j]] + 1;
    				}
    			}
    		}
    	}
    	if(dp[amount] == Integer.MAX_VALUE - 1){
    		return -1;
    	}
    	return dp[amount];

    }
}
