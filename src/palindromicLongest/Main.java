package palindromicLongest;

public class Main {
	public static void main(String[] args) {
		String s = "bbaabbaa";
		
		System.out.println("Input: " + s);
		
		FindLongestPalindromicSubstringFunction solution = new FindLongestPalindromicSubstringFunction();
		
		System.out.println("Solution: " + solution.longestPalindrome(s));
	}
}
