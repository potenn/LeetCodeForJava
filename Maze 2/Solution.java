
class Point{

    int x;
    int y;
    int cost;

    public Point(int x, int y, int cost){

        this.x = x;
        this.y = y;
        this.cost = cost;

    }
}

public class Solution {

    public boolean isCorrectRange(Point point, int xLen, int yLen){

        if((point.x >= 0 && point.x < xLen) && (point.y >= 0 && point.y < yLen)){
            return true;
        }else{
            return false;
        }

    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {


        if(maze == null || maze.length == 0 || maze[0].length == 0){
            return -1;
        }

        //위, 아래, 왼, 오
        int directions[][] = {{-1,0},{1,0},{0,-1},{0,1}};

        int xLen = maze.length;
        int yLen = maze[0].length;

        Point startPoint = new Point(start[0],start[1], 0);

        int distance[][] = new int[xLen][yLen];
        for(int i = 0 ; i < xLen ; i++){
            for(int j = 0 ; j < yLen ; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        //O(n)으로 채우기
        //  for (int i=0;i<m*n;i++){
        //     length[i/n][i%n]=Integer.MAX_VALUE;
        //  }


        PriorityQueue<Point> pQueue = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if(o1.cost < o2.cost){
					return -1;
				}else if(o1.cost > o2.cost){
					return 1;
				}
				return 0;
			}
		});

		pQueue.offer(startPoint);


		while(!pQueue.isEmpty()){

		    Point pollPoint = pQueue.poll();
		    if(distance[pollPoint.x][pollPoint.y] <= pollPoint.cost){
		        continue;
		    }

		    distance[pollPoint.x][pollPoint.y] = pollPoint.cost;

		    for(int i = 0 ; i < directions.length ; i++){

		        int movingX = pollPoint.x;
		        int movingY = pollPoint.y;
		        int movingCost = pollPoint.cost;

		        while(isCorrectRange(new Point(movingX,movingY,movingCost), xLen, yLen) && maze[movingX][movingY] == 0){
		            movingX = movingX + directions[i][0];
		            movingY = movingY + directions[i][1];
		            movingCost++;
		        }
		        //조건이안맞는경우에 그 값이 여전히 존재하므로 원래상태로 돌려줘야한다.
		        movingX = movingX - directions[i][0];
		        movingY = movingY - directions[i][1];
		        movingCost--;

		        pQueue.offer(new Point(movingX,movingY,movingCost));

		    }
		}

		return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

}
