public class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        /*
        HashMap으로 각 캐릭터와 그 인덱스값을 벨류로 값을 저장해나간다.
        */
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();

        Map <Character, Integer> map = new HashMap<Character, Integer>();

        int compareLen = 0;
        int result = 0;

        char preChar = s.charAt(0);

        int i = 0 ;
        while(i < len){

            char c = s.charAt(i);

            if(map.containsKey(c)){

                compareLen = compareLen  + 1;
                if(compareLen > result){
                    result = compareLen;
                }

            }else{

                if(map.size() == 0){
                    preChar = c;
                }

                map.put(c,i);

                if(map.size() == 3){
                    i = map.get(preChar) + 1;
                    compareLen = 0;
                    map.clear();
                    continue;
                }
                compareLen = compareLen + 1;
                if(compareLen > result){
                    result = compareLen;
                }

            }

            i = i + 1;

        }
        return result;

    }
}
