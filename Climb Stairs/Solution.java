public class Solution {

	public static int climbStairs(int n){

		int nStairs[] = new int[n];
		nStairs[0] = 1;

		for(int i = 1 ; i < n ; i++){

			if(i == 1){
				nStairs[i] = 2;
			}else{
				nStairs[i] = nStairs[i-1] + nStairs[i-2];
			}

		}
		return nStairs[n-1];

	}

}
