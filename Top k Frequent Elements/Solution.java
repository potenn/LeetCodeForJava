
class Node implements Comparable<Node>{
    int key;
    int value;
    public Node(int key, int value){
        super();
        this.key = key;
        this.value = value;
    }
    // 내림차순
    public int compareTo(Node o){

        if(this.value > o.value){
            return -1;
        }else if(this.value < o.value){
            return 1;
        }else{
            return 0;
        }

    }
}

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap <Integer,Integer>hashMap = new HashMap<Integer, Integer>();
        PriorityQueue <Node>priorityQueue = new PriorityQueue<Node>();
        List <Integer>answerList = new ArrayList<Integer>();
        // List <Node>nodeList = new ArrayList<Node>();


        for(int i = 0 ; i < nums.length ; i ++){

            if(hashMap.containsKey(nums[i])){

                int value = hashMap.get(nums[i]) + 1;
                hashMap.put(nums[i],value);

            }else{

                hashMap.put(nums[i],1);
            }
        }


        for(int key : hashMap.keySet()){

            Node newNode = new Node(key, hashMap.get(key));
            // nodeList.add(newNode);
            priorityQueue.offer(newNode);
        }

        for(int i = 0 ; i < k ; i++){
            Node pollNode = priorityQueue.poll();
            answerList.add(pollNode.key);
        }


        return answerList;

    }
}
