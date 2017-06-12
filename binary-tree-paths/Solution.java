/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
StringBuilder char 삭제
deleteCharAt


*/

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

      List <String> list = new ArrayList<String>();
      if(root == null){
        return list;
      }
      // StringBuilder builder = new StringBuilder();
      List<String> subList = new ArrayList<String>();
      dfs(root, list, subList);

      return list;

    }

    public void dfs(TreeNode root, List<String>list, List<String> subList){

      if(root == null){
          return;
      }

      if(root.left == null && root.right == null){
        // builder.append(root.val);
        String value = String.valueOf(root.val);
        subList.add(value);
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < subList.size() ; i++){

          builder.append(subList.get(i));

          if(i != subList.size() -1){
              builder.append("->");
          }
        }
        list.add(builder.toString());
        // String answer = generateDirectionMark(builder);
        // list.add(answer);
        subList.remove(subList.size()-1);
        return;
      }


      // builder.append(root.val);
      String value = String.valueOf(root.val);
      subList.add(value);
      dfs(root.left,list,subList);


      dfs(root.right,list,subList);
      subList.remove(subList.size()-1);
      // builder.deleteCharAt(builder.toString().length() - 1);


    }



}
