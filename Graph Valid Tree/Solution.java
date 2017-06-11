public class Solution {


    public int find(int s[], int target){

        while(s[target] != -1){
            target = s[target];
        }

        return target;

    }

    
    public boolean validTree(int n, int[][] edges) {


        if(edges == null || edges.length == 0 || edges[0].length == 0){
            if(n == 1){
                return true;
            }else{
                return false;
            }
        }


        int checked [] = new int[n];
        Arrays.fill(checked,-1);


        for(int i = 0 ; i < edges.length ; i++){

            int x = edges[i][0];
            int y = edges[i][1];

            int tempX = find(checked,x);
            int tempY = find(checked,y);

            if(tempX == tempY){
                return false;
            }

            //union
            checked[tempX] = tempY;

        }

        return edges.length == n - 1;

    }
}
