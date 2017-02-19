
import static org.junit.Assert.*;
import org.junit.Test;

public class Solution44 {

	public static void main(String args[]){
		wildCardTest();
	}

	@Test
	public static void wildCardTest(){

		assertEquals(false,isMatch("aa","a"));
		assertEquals(true,isMatch("aa","aa"));
		assertEquals(false,isMatch("aaa","a"));
		assertEquals(true,isMatch("aa","*"));
		assertEquals(true,isMatch("aa","a*"));
		assertEquals(true,isMatch("ab","?*"));
		assertEquals(false,isMatch("aab","c*a*b"));

	}

	public static boolean isMatch(String s, String p) {

        int sIndex = 0;
        int pIndex = 0;

        int sentenceLen = s.length();
        int patternLen = p.length();

        /**
         * Very important Index for solving this problem
         */
        //When the Asterisk comes out and does not match at all
        int startIndex = -1;

        int matchIndex = 0;

        // Traveling Start
        while(sIndex < sentenceLen){

        	//1. When '?' appears, or when characters match
        	if(pIndex < patternLen && ((p.charAt(pIndex) == '?') || (p.charAt(pIndex) == s.charAt(sIndex)))){
        		sIndex++;
        		pIndex++;
        	}
        	//2. When '*' appears
        	else if(pIndex < patternLen && (p.charAt(pIndex) == '*')){

        		startIndex = pIndex;
        		matchIndex = sIndex;
        		pIndex++;

        	}
        	//3. When the Asterisk comes out before and does not match at all
        	else if(startIndex != -1){

        		pIndex = startIndex + 1;
        		matchIndex = matchIndex + 1;
        		sIndex = matchIndex;

        	}
        	//4. doesn't match
        	else{
        		return false;
        	}
        }

        // In pattern String, remaining characters proceed.
        while(pIndex < patternLen && p.charAt(pIndex) == '*'){
        	pIndex++;
        }

        return pIndex == patternLen;

	}

}
