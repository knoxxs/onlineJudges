public class PalindromePartitioningWithDP {
// public class Solution {
	private Boolean[][] table;
    public int minCut(String s) {
    	table = new Boolean[s.length()][s.length()];
    	for(int i = 0; i < s.length(); i++){
    		for(int j = i; j < s.length(); j++){
    			table[i][j] = isPalindrome(s.substring(i, j+1));
    		}
    	}
	    print2dArray(table);

    	for(int column = s.length()-1; column >= 0; column--) {
    		for(int row = 0; row < s.length() - column ; row++){
    			if(table[row][column]) {
    				// System.out.println(column + "\t" + String.valueOf(table[row][column]) + "\t" + row);
    				return s.length() - column - 1;
    			}
    		}
    	}
    	return 100;
	}

    private boolean isPalindrome(String s) {
        return s.substring(0, s.length() / 2).equals(new StringBuilder(s.substring((int)Math.ceil((double)s.length() / 2))).reverse().toString());
    }

    public static void main(String[] args){
    	String s = "leet";
    	PalindromePartitioningWithDP pp = new PalindromePartitioningWithDP();
    	System.out.format("%d", pp.minCut(s));
    }

    static <T> void print2dArray(T[][] a){
    	for(T[] i : a) {
	    	for(T j : i) {
	    		System.out.format(String.valueOf(j) + "\t");
	    	}
	    	System.out.println();
	    }
    }
}
