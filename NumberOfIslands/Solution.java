
class Point{

	int x;
	int y;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	public boolean isCorrectRange(int xLen, int yLen, Point point){

		if((point.x >=0 && point.x< xLen) && (point.y >=0 && point.y<yLen)){
			return true;
		}
		else{
			return false;
		}
	}

	public int numIslands(char[][] grid) {

        if(grid == null)
        {
            return 0;
        }
        int xLength = grid.length;

        if(xLength == 0){
            return 0;
        }
        int yLength = grid[0].length;

        int idOfIslands = 0;
        Queue <Point> queue = new LinkedList<Point>();

        //1이 방문, 0은 방문하지않
        int visited[][] = new int[xLength][yLength];

        //순서대로 위,아래,왼쪽,오른
        //나중에 기타 다른 방법움직임도 대응가능. (대각선으로움직이고 뭐 두칸움직이고 그런것들)
        int directions[][] = {{-1,0},{1,0},{0,-1},{0,1}};


        for(int x = 0 ; x < xLength ; x++){

            for(int y = 0 ; y < yLength ; y++){

            	/*
			grid[x][y]가 1이어야하고, 방문하지않았을 때, 큐에 넣고 작업시작.
            	*/
            	if(grid[x][y] == '1' && visited[x][y] == 0){

            		//BFS 큐작업 시작.
            		queue.offer(new Point(x,y));
            		visited[x][y] = 1;

            		while(!queue.isEmpty()){
            			//큐에서 뽑았지?
            			Point pollPoint = queue.poll();

            			//뽑았으면 뭐해야하니.
            			// 가지칠준비해야지.
            			// 차례대로 위,아래,왼쪽,오른쪽
            			for(int i = 0 ; i < directions.length ; i++){

            				int moveX = pollPoint.x + directions[i][0];
            				int moveY = pollPoint.y + directions[i][1];

            				// 1. 먼저범위부터검사해야지 외곽으로뛰쳐나가는거 방지해야하고.
            				// 2. &&연산이니 두번째로 검사할경우 외곽검사는 통과했다는 얘기니까 이제 주어진 grid가 1(land)인지 확인하고
            				// 3. 방문을 한 애인지아닌지 판단해야하고. 방문을 안해야 가지치기에 들어가지.

            				if(isCorrectRange(xLength, yLength, new Point(moveX,moveY)) && grid[moveX][moveY] == '1' && visited[moveX][moveY] == 0){
            					queue.offer(new Point(moveX,moveY));
            					visited[moveX][moveY] = 1;
            				}
					
            			} // end of directions

            		} // end of Queue isEmpty
            		//탐색이 끝났지? 뭘해야할까 땅덩어리 증가시켜야지
            		idOfIslands++;
            	} // end of if grid[x][y] == '1' && visited[x][y] == 0
            } // end of for statement y
        }// end of for statement x
		
	return idOfIslands;

	}
}
