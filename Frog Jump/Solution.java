class Solution {

    public boolean canCross(int[] stones) {
        
        if(stones.length == 0){
            return true;
        }
        
        /*
        Key is (Unit --> reach)
        Value is to save step values.
        */
        
        HashMap<Integer, HashSet<Integer>>map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        /*
        from 0,  Start
        */
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        map.put(0,set);
        
        for(int i = 1 ; i < stones.length ; i++){
            map.put(stones[i], new HashSet<Integer>());
        }
        
        for(int i = 0 ; i < stones.length -1 ; i++){
            
            int stoneValue = stones[i];
            
            for(int step : map.get(stoneValue)){
                
                int reach = step + stoneValue;
                if(reach == stones[stones.length-1]){
                    return true;
                }
                
                Set <Integer>tempSet = map.get(reach);
                if(tempSet != null){
                    tempSet.add(step);
                    if(step -1 > 0){
                        tempSet.add(step-1);
                    }
                    tempSet.add(step+1);
                }
            }
        }
        
        return false;
        
    }
}