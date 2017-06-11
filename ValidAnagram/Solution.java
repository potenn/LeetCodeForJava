public class Solution {

    public boolean isAnagram(String s, String t) {

    	if(s.length() != t.length()){
		return false;
	}

	//아스키 코드값을 기준으로 일치여부를 판단할겁니다.
	int s1Arr[] = new int[128];
	int s2Arr[] = new int[128];

	for(char c : s.toCharArray()){
		s1Arr[c]++;
	}
	for(char c : t.toCharArray()){
		s2Arr[c]++;
	}
	//여기서 즉
	for(int i = 0 ; i < s1Arr.length ; i++){
		if(s1Arr[i] != s2Arr[i]){
			return false;
		}
	}
	return true;
    }

}
