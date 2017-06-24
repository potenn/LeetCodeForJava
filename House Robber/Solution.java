public class Solution {

	/*
 	nums 배열은 각 집의 돈의수를 의미
 	i -> 집, nums[i] -> 돈

 	경찰 Alerting 안울릴 조건 :  인접 두곳 털릴떄


	dp 정의  -> 매 인덱스까지 털때의 최대값.

	5 6 4 7 9 라는 데이터가 있다고 치자.
    house 배열

    int house[] = {5,6,4,7,9};
    f( n ) -> n번째까지 훔쳤을 때, 최대 금액
    f( 0 ) = 5,
    f(1) = Max(f(1),f(0))
    f(2) = Max(f(0)+f(2),f(1))
    f(3) = Max(f(2),f(1)+f(3))
    f(4) = Max(f(3), f(2)+f(4))
    f(n) = Max(f(n-1),f(n-2)+f(n))

    즉, 기저(base)
    n = 0, f( 0 ) = 5
    n = 1, f( 1 ) = Max( f(1), f(0) )
    n >= 2, f(n) = Max(f(n-1),f(n-2)+f(n))



	*/
    public int rob(int[] nums) {

    	int length = nums.length;
        if(length == 0){
            return 0;
        }
    	if(length == 1){
    		return nums[0];
    	}

    	int []robMax = new int[length];
    	robMax[0] = nums[0];
    	robMax[1] = Math.max(nums[0],nums[1]);

    	for(int i = 2 ; i < length ; i++){
    		robMax[i] = Math.max(robMax[i-2] + nums[i], robMax[i-1]);
    	}

    	return robMax[length - 1];
    }
}
