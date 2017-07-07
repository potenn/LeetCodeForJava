public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {

        if(strs == null| strs.length == 0){
            return 0;
        }


        int lenStrs = strs.length;

        int dp[][][] = new int[lenStrs+1][m+1][n+1];


        for(int i = 1 ; i <= lenStrs ; i++){

            int arr[] = new int[2];
            arr = calculate(strs[i-1]);

            //j는 m의 개수를 나타냄(0숫자)
            for(int j = 0 ; j < m + 1 ; j++){

                //k는 n의 개수를 나타냄(1숫자)
                for(int k = 0 ; k < n + 1 ; k++){
                    if(j>=arr[0] && k >= arr[1]){

                        dp[i][j][k] = Math.max(dp[i-1][j-arr[0]][k-arr[1]] +1 , dp[i-1][j][k]);

                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[lenStrs][m][n];
    }

    public int []calculate(String str){

        /*
        res배열은 각각
        0 index 0이 몇번나왔는지를 기록함.
        1 index는 1이 몇번 나왔는지를 기록.

        */
        int arr[] = new int[2];
        for(char ch : str.toCharArray()){
            if(ch == '0'){
                arr[0]++;
            }else if(ch == '1'){
                arr[1]++;
            }
        }
        return arr;
    }

}
