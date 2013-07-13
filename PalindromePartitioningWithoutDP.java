// public class PalindromePartitioningWithoutDP {
public class Solution {
    private int startIndex = 0;

    public int minCut(String s) {
    	return minCut(s, startIndex);
    }

    public int minCut(String s, int index) {
    	index++;
    	// System.out.format("%d\n", index);
    	if(isPalindrome(s.substring(0, index))) {
    		// System.out.format("Here1\n");
    		int usingPalindrom, noPalindrome;
    		if(index < s.length()) {
	    		noPalindrome = minCut(s, index);
	    		usingPalindrom = 1 + minCut(s.substring(index), startIndex);
	    		return noPalindrome < usingPalindrom ? noPalindrome : usingPalindrom;
	    	} else {
	    		return 0;
	    	}
    	} else {
    		// System.out.format("Here2\n");
    		return (index < s.length()) ? (minCut(s, index)) : (s.length()-1);
    	}
    }

    private boolean isPalindrome(String s) {
        return s.substring(0, s.length() / 2).equals(new StringBuilder(s.substring((int)Math.ceil((double)s.length() / 2))).reverse().toString());
    }

    // public static void main(String[] args){
    // 	String s = "abbab";
    // 	PalindromePartitioningWithoutDP pp = new PalindromePartitioningWithoutDP();
    // 	System.out.format("aa%d", pp.minCut(s));
    // }
}
