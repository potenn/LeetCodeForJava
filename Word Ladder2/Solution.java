
class Node{

    String word;
    int steps;
    Node pre;

    public Node(String word, int steps, Node pre){
        this.word = word;
        this.steps = steps;
        this.pre = pre;
    }

}


public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>>answerList = new ArrayList<List<String>>();

        Queue<Node> queue = new LinkedList<Node>();

        //1. Begin Node
        Node beginNode = new Node(beginWord,1,null);
        queue.offer(beginNode);

        //주어진 wordList
        // wordList.add(endWord);

        //방문한 set과 방문하지 않은 set
        Set <String>visited = new HashSet<String>();
        Set <String>unVisited = new HashSet<String>();

        unVisited.addAll(wordList);

        int preNumSteps = 0;
        int minStep = 0;


        while(!queue.isEmpty()){

            Node node = queue.poll();
            String word = node.word;

            int currentSteps = node.steps;

            //만족.
            if(word.equals(endWord)){

                //맨처음으로 들어오는 놈이 bfs특성상
                // 최소 스텝임
                if(minStep == 0){
                    minStep = node.steps;
                }
                if(minStep == node.steps && minStep != 0){

                    List<String>tempList = new ArrayList<String>();
                    tempList.add(node.word);
                    while(node.pre != null){
                        tempList.add(0, node.pre.word);
                        node = node.pre;
                    }
                    answerList.add(tempList);
                    continue;
                }
            }


            if(preNumSteps < currentSteps){
                unVisited.removeAll(visited);
            }

            preNumSteps = currentSteps;

            char arrayChar[] = word.toCharArray();

            for(int i = 0 ; i < arrayChar.length ; i++){

                for(char c = 'a' ; c <= 'z' ; c++){

                    char temp = arrayChar[i];
                    if(arrayChar[i] != c){
                        arrayChar[i] = c;
                    }
                    String newWord = new String(arrayChar);
                    if(unVisited.contains(newWord)){

                        Node newNode = new Node(newWord,node.steps+1, node);
                        queue.offer(newNode);
                        visited.add(newWord);

                    }
                    arrayChar[i] = temp;
                }
            }



        }

        return answerList;

    }
}
