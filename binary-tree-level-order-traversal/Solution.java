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

    public List<List<Integer>> levelOrder(TreeNode root) {

    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> numberList = new ArrayList<Integer>();
    	LinkedList <TreeNode>queue = new LinkedList<TreeNode>();
    	LinkedList <TreeNode>childQueue = new LinkedList<TreeNode>();

    	if(root == null){
    		return result;
    	}

    	queue.offer(root);

    	while(!queue.isEmpty()){

    		TreeNode treeNode = queue.poll();

    		numberList.add(treeNode.val);

    		if(treeNode.left!=null){
    			childQueue.offer(treeNode.left);

    		}
    		if(treeNode.right!=null){
    			childQueue.offer(treeNode.right);
    		}

    		if(queue.isEmpty()){

    		result.add(numberList);

    		queue = childQueue;
    		childQueue = new LinkedList<TreeNode>();
    		numberList = new ArrayList<Integer>();


    		}


    	}

    	return result;


    }


}
