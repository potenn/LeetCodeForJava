
class Point{

    int x;
    int y;
    int value;

    public Point(int x, int y, int value){

        this.x = x;
        this.y = y;
        this.value = value;

    }
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}

public class Solution {

    public boolean isCorrectRange(List<List<Integer>>matrix, Point point){

        int xLength = matrix.size();
        int yLength = matrix.get(0).size();
        int x = point.x;
        int y = point.y;
        if((x >= 0 && x < xLength) && (y >= 0 && y < yLength)){
            return true;
        }else{
            return false;
        }
    }

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {

        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        int xLength = matrix.size();
        int yLength = matrix.get(0).size();

        Queue <Point>queue = new LinkedList<Point>();
        int visited[][] = new int[xLength][yLength];

        for(int x = 0 ; x < xLength ; x++){

            for(int y = 0 ; y < yLength ; y++){

                int element = matrix.get(x).get(y);
                if(element == 0){
                    queue.offer(new Point(x, y, element));
                }else{
                    matrix.get(x).set(y, Integer.MAX_VALUE);
                }
            }
        }

        //탐색시작
        while(!queue.isEmpty()){

            Point pollPoint = queue.poll();

                Point upPoint = new Point(pollPoint.x - 1, pollPoint.y);
                Point downPoint = new Point(pollPoint.x + 1, pollPoint.y);
                Point leftPoint = new Point(pollPoint.x, pollPoint.y - 1);
                Point rightPoint = new Point(pollPoint.x, pollPoint.y + 1);

                //up
                if(isCorrectRange(matrix, upPoint) && matrix.get(upPoint.x).get(upPoint.y) != 0 && visited[upPoint.x][upPoint.y] == 0){
                    Point point = new Point(pollPoint.x-1,pollPoint.y,pollPoint.value);
                    visited[point.x][point.y] = 1;
                        int temp = point.value + 1;
                        int pointValue = Math.min(matrix.get(point.x).get(point.y),temp);
                        matrix.get(point.x).set(point.y, pointValue);
                        queue.offer(new Point(point.x,point.y,pointValue));

                }
                 //down
                if(isCorrectRange(matrix, downPoint) && matrix.get(downPoint.x).get(downPoint.y) != 0 && visited[downPoint.x][downPoint.y] == 0){
                    Point point = new Point(pollPoint.x+1,pollPoint.y,pollPoint.value);
                    visited[point.x][point.y] = 1;
                        int temp = point.value + 1;
                        int pointValue = Math.min(matrix.get(point.x).get(point.y),temp);
                        matrix.get(point.x).set(point.y, pointValue);
                        queue.offer(new Point(point.x,point.y,pointValue));
                }
                //left
                if(isCorrectRange(matrix, leftPoint) && matrix.get(leftPoint.x).get(leftPoint.y) != 0 && visited[leftPoint.x][leftPoint.y] == 0){
                    Point point = new Point(pollPoint.x,pollPoint.y-1,pollPoint.value);
                    visited[point.x][point.y] = 1;
                        int temp = point.value + 1;
                        int pointValue = Math.min(matrix.get(point.x).get(point.y),temp);
                        matrix.get(point.x).set(point.y, pointValue);
                        queue.offer(new Point(point.x,point.y,pointValue));
                }
                //right
                if(isCorrectRange(matrix, rightPoint) && matrix.get(rightPoint.x).get(rightPoint.y) != 0 && visited[rightPoint.x][rightPoint.y] == 0){
                    Point point = new Point(pollPoint.x,pollPoint.y+1,pollPoint.value);
                    visited[point.x][point.y] = 1;
                        int temp = point.value + 1;
                        int pointValue = Math.min(matrix.get(point.x).get(point.y),temp);
                        matrix.get(point.x).set(point.y, pointValue);
                        queue.offer(new Point(point.x,point.y,pointValue));
                }

        } // end of Queue while isEmpty

        return matrix;

    } // 함수종료

}
