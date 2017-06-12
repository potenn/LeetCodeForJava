public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answerList = new ArrayList<List<String>>();
        if(strs.length == 0 || strs == null){
            return answerList;
        }

        Map <String,List<String>>map = new HashMap<String,List<String>>();

        for(String str : strs){

            char strArr[] = str.toCharArray();
            Arrays.sort(strArr);
            String temp = new String(strArr);
            if(map.containsKey(temp)){
                List<String> tempList = map.get(temp);
                tempList.add(str);
                map.put(temp,tempList);
            }else{
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                map.put(temp,newList);
            }

        }

        for(List <String>list : map.values()){
            answerList.add(list);
        }
        return answerList;
    }
}
