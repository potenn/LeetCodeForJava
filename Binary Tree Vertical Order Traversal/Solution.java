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

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> answerList = new ArrayList<List<Integer>>();
        if(root == null){
            return answerList;
        }

        int min = 0;
        int max = 0;

        Map <Integer, List<Integer>>map = new HashMap<Integer, List<Integer>>();

        Queue <Integer>colQueue = new LinkedList<Integer>();
        Queue <TreeNode>treeNodeQueue = new LinkedList<TreeNode>();

        colQueue.offer(0);
        treeNodeQueue.offer(root);

        while(!treeNodeQueue.isEmpty()){

            TreeNode pollNode = treeNodeQueue.poll();
            int colNum = colQueue.poll();

            if(!map.containsKey(colNum)){
                map.put(colNum, new ArrayList<Integer>());
            }
            List <Integer>tempList = map.get(colNum);
            tempList.add(pollNode.val);

            if(pollNode.left != null){

                colQueue.offer(colNum-1);
                treeNodeQueue.offer(pollNode.left);
                min = Math.min(colNum-1,min);
            }

            if(pollNode.right != null){
                colQueue.offer(colNum+1);
                treeNodeQueue.offer(pollNode.right);
                max = Math.max(colNum+1,max);
            }
        }

        for(int i = min ; i <= max ; i++){
            List<Integer>list = map.get(i);
            answerList.add(list);
        }

        return answerList;

    }

}
