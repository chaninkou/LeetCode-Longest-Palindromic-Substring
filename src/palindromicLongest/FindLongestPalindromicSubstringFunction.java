package palindromicLongest;

public class FindLongestPalindromicSubstringFunction {
    public String longestPalindrome(String s) {
    	if(s == null || s.length() <= 1){
    		return "";
    	}
    	
    	// The exact start index
    	int start = 0;
    	
    	// The exact end index
    	int end = 0;
    	
    	// Go through each characters
    	for(int i = 0; i < s.length(); i++){
    		// example: aba
    		int odd = expandFromMiddle(s, i, i);
    		
    		// example: abba
    		int even = expandFromMiddle(s, i, i + 1);
    		
    		// Get the max of it
    		int currentMaxLength = Math.max(odd, even);
    		
    		// If current palindrome is longer than our previous max
    		if(currentMaxLength > end - start){
    			// Update the start and end index
    			
    			// Divide the currentmaxlength by 2 and minus that from i to get the starting index
    			start = i - (currentMaxLength - 1)/2;
    			
    			// Add the currentmaxlength that got divided by 2
    			end = i + currentMaxLength/2;
    		}
    	}
    	
    	
    	// end + 1 because the end of substring doesn't include that index
    	return s.substring(start, end + 1);
    }
    
    
    private int expandFromMiddle(String s, int left, int right){
    	// Make sure we don't overflow
    	if(s == null || left > right){
    		return 0;
    	}
    	
    	// When left and right is still in between the string length, and they equal to each other
    	while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
    		// Update the 2 pointers
    		left--;
    		right++;
    	}
    	
    	// Example: aba
    	// right = 3
    	// left = -1
    	// 3 - -1 - 1 = 3
    	return right - left - 1;
    }	
    
    
    private int start;
    private int maxLen;
    
    public String longestPalindrome1(String s) {
        int slength = s.length();
        
        // If there is only one element, edge case
        if(slength <= 1){
        	return s;
        }
        
        for(int i = 0; i < slength - 1; i++){
        	// This will stop the loop if the a letter is repeated for more than 6 times
        	// Unique
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
    		// Move the left pointer to left now
    		moveLeft--;
    		
    		// Move the right pointer to right now
    		moveRight++;
    	}
    	
    	// Always minus one to get the correct index since it cannot go over the original string length
    	int maybeMaxLength = moveRight - moveLeft - 1;
    	
    	// Check if this length is more than our current max value
    	if(maxLen < maybeMaxLength){
    		// Always plus one since moveLeft might be less than zero
    		start = moveLeft + 1;
    		maxLen = maybeMaxLength;
    	}
    }	
    
}
