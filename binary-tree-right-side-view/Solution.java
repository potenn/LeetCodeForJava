/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {

      ArrayList <Integer>list = new ArrayList<Integer>();

      if(root == null){
        return list;
      }
      Queue <TreeNode>queue = new LinkedList<TreeNode>();
      queue.offer(root);
      list.add(root.val);

      int queueSize = queue.size();

      // 무조건 큐에 들어갔을떄 가장 마지막에 있는
      // Element만 가져오면됨.

      while(!queue.isEmpty()){

        queueSize = queue.size();

        while(queueSize > 0){

          TreeNode tempTreeNode = queue.poll();

          if(tempTreeNode.right != null){
            queue.offer(tempTreeNode.right);
          }

          if(tempTreeNode.left != null){
            queue.offer(tempTreeNode.left);
          }
          queueSize --;
        }

        if(!queue.isEmpty()){
          TreeNode peekTreeNode = queue.peek();
          list.add(peekTreeNode.val);
        }


      }
      return list;

    }
}
