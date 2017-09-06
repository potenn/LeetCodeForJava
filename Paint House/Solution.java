class Solution{

	public int minCost(int [][]costs){

		if(cost == null || costs.length == 0){
			return 0;
		}

		int len = costs.length

		int dp[][] = new int[len+1][3];
		for(int i = 1; i <= len ; i++){

			dp[i][0] = Math.min(dp[i][1],dp[i][2]) + costs[i-1][0];
			dp[i][1] = Math.min(dp[i][0],dp[i][2]) + costs[i-1][1];
			dp[i][2] = Math.min(dp[i][0],dp[i][1]) + costs[i-1][2];

		}

		int min = Integer.MAX_VALUE;
		for(int i = 1 ; i <= len ; i++){
			dp[len][i] = Math.min(dp[len][i],min);
		}

		return min;

	}
}