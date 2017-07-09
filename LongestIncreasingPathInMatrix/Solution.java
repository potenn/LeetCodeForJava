public class Solution {


    public boolean isCorrectRange(Point newPoint, int xLen, int yLen){

        if(((newPoint.x >= 0 && newPoint.x < xLen) && (newPoint.y >= 0 && newPoint.y < yLen))){
            return true;
        }else{
            return false;
        }
    }
    public boolean isCanMoveBiggerNumber(Point beforePoint, Point afterPoint, int matrix[][]){
        if(matrix[beforePoint.x][beforePoint.y] < matrix[afterPoint.x][afterPoint.y]){
            return true;
        }else{
            return false;
        }
    }

    public int searchMaxPath(int directions[][], Point newPoint, int dp[][], int matrix[][]){

        int xLen = matrix.length;
        int yLen = matrix[0].length;

        if(dp[newPoint.x][newPoint.y] != -1){
            return dp[newPoint.x][newPoint.y];
        }
        dp[newPoint.x][newPoint.y] = 1;

        for(int direc = 0 ; direc < directions.length ; direc++){

            int moveX = newPoint.x + directions[direc][0];
            int moveY = newPoint.y + directions[direc][1];
            if(isCorrectRange(new Point(moveX, moveY), xLen, yLen) && isCanMoveBiggerNumber(newPoint, new Point(moveX, moveY), matrix)){
                dp[newPoint.x][newPoint.y] =  Math.max(dp[newPoint.x][newPoint.y], searchMaxPath(directions, new Point(moveX,moveY), dp,matrix) + 1);

            }
        }

        return dp[newPoint.x][newPoint.y];
    }

    public int longestIncreasingPath(int[][] matrix) {


        int xLength = matrix.length;
        if(xLength == 0){
            return 0;
        }

        int yLength = matrix[0].length;

        int dp[][] = new int[xLength][yLength];

        for(int x = 0 ; x < xLength ; x++){
            for(int y = 0 ; y < yLength ; y++){
                dp[x][y] =  -1;
            }
        }

        int max = -1;

        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int x = 0 ; x < xLength ; x++){

            for(int y = 0 ; y < yLength ; y++){

                Point newPoint = new Point(x,y);
                max = Math.max(max, searchMaxPath(directions, newPoint, dp, matrix));

            }
        }



        return max;

    }
}
