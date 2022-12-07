package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayWithKDistinctCharacters {
	public static int maxSubarrayWithDistinctCharacters(String s,int k)
	{
		int windowStart=0;
		int maxLength=Integer.MIN_VALUE;
		Map<Character,Integer> map=new HashMap<>();
		for(int windowEnd=0; windowEnd<s.length();windowEnd++)
		{
			char currChar=s.charAt(windowEnd);
			map.put(currChar, map.getOrDefault(currChar,0)+1);
			//invalid windowCase ,we need to shrink the window size until window becomes valid
			while(map.size()>k)
			{
				char leftChar=s.charAt(windowStart);
				windowStart++;
				map.put(leftChar, map.get(leftChar)-1);
				if(map.get(leftChar)==0)
				{
					map.remove(leftChar);
				}
			}
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
		}
		return maxLength;
	}
	public static void main(String args[])
	{
		String s="abacdcdcdabcd";
		int k=3;	
		System.out.println(SubarrayWithKDistinctCharacters.maxSubarrayWithDistinctCharacters(s, k));
	}
}
