package palindromicLongest;

public class FindLongestPalindromicSubstringFunction {
    private int start;
    private int maxLen;
    
    public String longestPalindrome(String s) {
        int slength = s.length();
        
        // If there is only one element, edge case
        if(slength < 2){
        	return s;
        }
        
        for(int i = 0; i < slength - 1; i++){
        	// This will stop the loop if the a letter is repeated for more than 6 times
        	if(slength - 1 < maxLen / 2){
        		break;
        	}
        	
        	// If the palindrome is odd, starts from middle index, and then move left and move right to compare
        	extend(s, i, i);
        	
        	// If the palindrome is even, always compare two letters at first, and then move left and move right to compare.
        	extend(s, i, i + 1);
        }
        
        // The start is the starting index, start + maxLen is how many element after start
        return s.substring(start, start + maxLen);
    }
    
    private void extend(String s, int moveLeft, int moveRight){
    	// Left have to be greater than zero since there is no negative index
    	// Right can not be greater than the actual string length, cause it is not possible
    	// The left and right value have to equal or else its not a palindrome
    	while(moveLeft >= 0 && moveRight < s.length() && s.charAt(moveLeft) == s.charAt(moveRight)){
    		moveLeft--;
    		
    		moveRight++;
    	}
    	
    	// Always minus one to get the correct index since it cannot go over the original string length
    	int maybeMaxLength = moveRight - moveLeft - 1;
    	
    	if(maxLen < maybeMaxLength){
    		// Always plus one since moveLeft might be less than zero
    		start = moveLeft + 1;
    		maxLen = maybeMaxLength;
    	}
    }	
}
