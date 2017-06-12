

class Point{
    int x;
    int y;
    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
}

public class Solution {

    public boolean isOutSide(Point point,int xLength, int yLength){

      int x = point.x;
      int y = point.y;
      if(point.x - 1 < 0 || point.y - 1 < 0 || point.x + 1 >= xLength || point.y + 1 >= yLength){
        return true;
      }else{
        return false;
      }
    }
    public boolean isCorrectRange(Point point, int xLength, int yLength){

      int x = point.x;
      int y=  point.y;

      if((x>=0 && x<xLength) && (y>=0 && y < yLength)){
          return true;
      }else{
        return false;
      }
    }
    /*
    1. board 가 O인가
    2. 범위 벗어나지않았는가
    3. 방문여부
    */
    public void changeOToXProcess(char board[][], int xLength, int yLength, ArrayList<Point>pointList){

        int length = pointList.size();
        boolean isChangeOToXValue = true;
        for(int i = 0 ; i< length ; i++){

          Point tempPoint = pointList.get(i);
          //외곽 여부 판단.
          if(isOutSide(tempPoint,xLength,yLength)){
              isChangeOToXValue = false;
              return;
          }
        }
        //외곽여부조건을 통과했다면
        if(isChangeOToXValue == true){
          for(int i = 0 ; i< length ; i++){

            Point tempPoint = pointList.get(i);
            board[tempPoint.x][tempPoint.y] = 'X';
          }
        }
    }

    public Point[] moveType(Point point){


      Point upPoint = new Point(point.x - 1, point.y);
      Point downPoint = new Point(point.x + 1, point.y);
      Point leftPoint = new Point(point.x, point.y - 1);
      Point rightPoint = new Point(point.x, point.y + 1);
      Point []moveTypePoint = {upPoint,downPoint,leftPoint,rightPoint};
      return moveTypePoint;

    }
    public void solve(char[][] board) {

      int xLength = board.length;
      if(xLength == 0){
          return;
      }
      int yLength = board[0].length;
      if(board == null){
          return;
      }
      if(xLength == 0 || yLength == 0){
           return;
      }


      //방문여부를 판단하는 2차원 배열
      int visited[][] = new int[xLength][yLength];
      Queue <Point>queue = new LinkedList<Point>();
      ArrayList <Point>list = new ArrayList<Point>();

      //1. 2차원 배열을 탐색해야 한다.
      // 탐색해서 그 board가 'O'인지와 방문여부를 봐야한다.
      // 맞다면 큐에 추가하고 순환을 돌린다.
      // 큐에서 빠질때 list에 추가를 한다.
      /*
      * * * * * 여기서 핵심은 list에 추가한 Point들중에 하나라도 외곽쪽에 있는 Point가 있다면
      그것은 O -> X로 바꾸지 않는다.
      */

      for(int x = 0 ; x < xLength ; x++){

          for(int y = 0 ; y < yLength ; y++){

              if(board[x][y] == 'O' && visited[x][y] == 0){

                Point startPoint = new Point(x,y);
                queue.offer(startPoint);
                visited[startPoint.x][startPoint.y] = 1;

                while(!queue.isEmpty()){

                  Point tempPoint = queue.poll();
                  list.add(tempPoint);
                  Point moveTypePointArr[] = moveType(tempPoint);
                  int moveTypeLen = moveTypePointArr.length;
                  for(int i = 0 ;  i < moveTypeLen ; i++ ){
                    Point movePoint = moveTypePointArr[i];
                    if(isCorrectRange(movePoint,xLength,yLength) && visited[movePoint.x][movePoint.y] == 0 && board[movePoint.x][movePoint.y] == 'O'){
                      queue.offer(movePoint);
                      visited[movePoint.x][movePoint.y] = 1;
                    }
                  }
                } // end of While

                if(queue.isEmpty()){
                  // 바꿀수있는지검사
                  changeOToXProcess(board,xLength,yLength,list);

                  list = null;
                  list = new ArrayList<Point>();
                } // end of Queue isEmpty()
              }
          }
      }
    }
}
