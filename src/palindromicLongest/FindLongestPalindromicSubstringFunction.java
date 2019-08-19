package palindromicLongest;

public class FindLongestPalindromicSubstringFunction {
    private int start;
    private int maxLen;
    
    public String longestPalindrome(String s) {
        int sLength = s.length();
        
        // This happen when it is one element or less
        if(sLength < 2){
            return s;
        }
        
        for(int i = 0; i < sLength - 1; i++){
            // This could stop the loop when its apear 6 times or more b
            if(sLength - i < maxLen / 2){
                break;
            }
            
            // If its odd length
            extend(s, i, i);
            // If its even length
            extend(s, i, i + 1);
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private void extend(String s, int j, int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        
        if(maxLen < k - j -1){
            start = j + 1;
            maxLen = k - j - 1;
        }
    }	
}
