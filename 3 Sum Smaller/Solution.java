class Solution {
    
    /*
    we need three pointer Index.
    
    if i have Array[2,0,1,3,6],
    
    2 0 1 3 6
    a b c
    a b   c
    a b     c
    a   b c 
    a   b   c
    a     b c
      a b c
      a b   c
      a   b c
        a b c
        
    */
    
    
    
    public int threeSumSmaller(int[] nums, int target) {
        
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int criticalIndex = 0;
        int secondIndex = criticalIndex + 1;
        int thirdIndex = 0;
        int answer = 0;
        int len = nums.length;
        
        while(criticalIndex < len - 2){
            
            thirdIndex = secondIndex + 1;
            
            while(thirdIndex < len){
                
                int val1 = nums[criticalIndex];
                int val2 = nums[secondIndex];
                int val3 = nums[thirdIndex];
                int sum = val1 + val2 + val3;
                
                if(sum < target){
                    answer++;
                }
                
                thirdIndex++;
            }
            if(secondIndex < len-1){
                secondIndex++;
                continue;
            }else{
                criticalIndex++;
                secondIndex = criticalIndex + 1;
            }
            
            
        }
        
        
        return answer;
        
        
        
        
    }
}