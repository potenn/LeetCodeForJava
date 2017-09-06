class Solution {

    public int minCostII(int[][] costs) {

        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;  
        } 
    
        //Num of houses
        int n = costs.length;
        
        //Num of colors
        int k = costs[0].length;
        
        if(k == 1) return (n==1? costs[0][0] : -1);
        
        int numOfHouse = costs.length;
        int numOfColor = costs[0].length;
        
        int firstMin = 0;
        int secondMin = 0;
        int prevColor = -1;

        for(int house = 0 ; house < numOfHouse ; house++){

        	int localFirstMin = Integer.MAX_VALUE;
        	int localSecondMin = Integer.MAX_VALUE;
        	int localPrevColor = -1;

        	for(int color = 0 ; color < numOfColor ; color++){

        		int cost = costs[house][color] + (color != prevColor ? firstMin : secondMin);

        		if(cost < firstMin){
        			localSecondMin = localFirstMin;
        			localFirstMin = cost;
        			localPrevColor = color;

        		}else if(cost < secondMin){
        			localSecondMin = cost;
        		}
        	}

        	firstMin = localFirstMin;
        	secondMin = localSecondMin;
        	prevColor = localPrevColor;
        }

        return firstMin;

    }

}