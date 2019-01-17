class SmallestWindowSubstring
{
	// Explanation: https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
	
	static final int CHARS = 256;

	public static String smallestWindow(String str, String pattern)
	{
		int l1 = str.length();
		int l2 = pattern.length();
		
		if(l2>l1)
			return "No window found";
		
		int[] strChars = new int[CHARS];
		int[] patternChars = new int[CHARS];
		
		// store occurrence ofs characters of pattern
		for(int i=0;i<l2;i++)
			patternChars[pattern.charAt(i)]++;
		
		int start = 0;
		int minLen = Integer.MAX_VALUE;
		int startIndex = -1;
		int count = 0;
		
		for(int i=0;i<l1;i++)
		{
			// count occurrence of characters of string 
			strChars[str.charAt(i)]++;
			
			// If string's char matches with pattern's char 
			// then increment count 
			if(strChars[str.charAt(i)] <= patternChars[str.charAt(i)] && patternChars[str.charAt(i)] != 0)
				count++;
			
			if(count == pattern.length())
			{
				// Try to minimize the window i.e., check if 
				// any character is occurring more no. of times 
				// than its occurrence in pattern, if yes 
				// then remove it from starting and also remove 
				// the useless characters. 
				
				while(patternChars[str.charAt(start)] == 0 || strChars[str.charAt(start)] > patternChars[str.charAt(start)])
				{
					if(strChars[str.charAt(start)] > patternChars[str.charAt(start)])
						strChars[str.charAt(start)]--;
					start++;
				}
				
				// update window size 
				int windowLenght = i - start + 1;
				if(minLen > windowLenght)
				{
					minLen = windowLenght;
					startIndex = start;
				}
				
			}
		}
		
		if(startIndex == -1)
		{
			return "No window found";
		}
		// Return substring starting from start_index 
		// and length min_len
		return str.substring(startIndex, startIndex+minLen);
	}
	
	
	
	
	
	public static void main(String args[])
	{
		String str = "Abkibar Modi sarkar";
		String pattern = "kr";
		
		String res = smallestWindow(str,pattern);
		System.out.println(res);
	}
}
