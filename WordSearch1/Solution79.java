
import static org.junit.Assert.*;
import org.junit.Test;

public class Solution79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordSearch wordSearch = new WordSearch();
		char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		wordSearch.testWordSearch(board);

	}

}

class Point{

	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

}

class WordSearch{

	@Test
	public void testWordSearch(char board[][]){
		assertEquals(true,exist(board, "ABCCED"));
		assertEquals(true,exist(board, "SEE"));
		assertEquals(false,exist(board, "ABCB"));
	}

	public boolean isCorrectRange(Point point, int xLength, int yLength){

		if((point.x >= 0 && point.x < xLength) && (point.y >= 0 && point.y < yLength)){
			return true;
		}else{
			return false;
		}

	}

    public boolean exist(char[][] board, String word) {

    	//Using DFS, solve the problem.
        if(board == null || word == null || word.length() == 0){
            return false;
          }

          int xLength = board.length;
          if(xLength == 0){
            return false;
          }
          int yLength = board[0].length;

          int visited[][] = new int[xLength][yLength];

          for(int x = 0 ; x < xLength ; x++){

        	  for(int y = 0 ; y < yLength ; y++){

        		  if(backtrackingDFS(visited, board, word, 0, new Point(x,y), xLength, yLength)){
        			  return true;
        		  }
        	  }
          }
          return false;
    }

    public boolean backtrackingDFS(int visited[][],char board[][],String word,int depth, Point point,int xLength, int yLength){


    	//terminate this Method
    	if(board[point.x][point.y] != word.charAt(depth) || visited[point.x][point.y]== 1){
    		return false;
    	}

    	if(depth == word.length() - 1){
    		return true;
    	}

    	/**
    	 * i = 0, UP
    	 * i = 1, Down
    	 * i = 2, Left
    	 * i = 3, Right
    	 */

    	visited[point.x][point.y] = 1;
    	for(int i = 0 ; i < 4 ; i++){

    		Point newPoint = null;
    		switch(i){
    		case 0 :
    			newPoint = new Point(point.x - 1, point.y);
    			break;
    		case 1 :
    			newPoint = new Point(point.x + 1, point.y);
    			break;
    		case 2 :
    			newPoint = new Point(point.x, point.y - 1);
    			break;
    		case 3 :
    			newPoint = new Point(point.x, point.y + 1);
    			break;
    		}

    		if(isCorrectRange(newPoint, xLength, yLength) && backtrackingDFS(visited, board, word, depth + 1, newPoint, xLength, yLength)){
    			return true;
    		}
    	}
    	visited[point.x][point.y] = 0;

    	return false;
    }


}
