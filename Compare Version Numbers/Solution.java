public class Solution {

    public int compareVersion(String version1, String version2) {

        String version1Arr[] = version1.split("\\.");
        String version2Arr[] = version2.split("\\.");

        int len = version1Arr.length <= version2Arr.length ? version2Arr.length : version1Arr.length;

        for(int i = 0 ; i < len ; i++){

            Integer v1 = i < version1Arr.length ? Integer.parseInt(version1Arr[i]) : 0;
    	    Integer v2 = i < version2Arr.length ? Integer.parseInt(version2Arr[i]) : 0;
    	    int compare = v1.compareTo(v2);
    	    if (compare != 0) {
    		    return compare;
    	    }

        }

        return 0;

    }
}
