package com.ske;

public class StringEncoder extends BitEncoder 
{
	public int encode4chars(String word)
	{
		int [] nums = new int [4];
		
		for (int i=0; i<4; i++)
		{ 
			nums[i] = (int) word.charAt(i); 
		}
		
		return encodeDoubleword(nums);
	}
	
	public String decodeInt(int packed)
	{
		int [] decodedInts = decodeDoubleword(packed);
		char [] decodedChars = new char [4];
		
		for (int i=0; i<decodedChars.length; i++)
		{
			decodedChars[i] = (char)decodedInts[i];
		}

		return new String(decodedChars);
	}
	
	public long encode8chars(String word)
	{
		// use encode4chars method to create two encoded 
		// ints for each half of the word
		int x = encode4chars(word.substring(0, 4));
		int y = encode4chars(word.substring(4));
		
		// return the combined encoded long product of x and y
		return encodeDoubleIntToLong(x, y);
	}
	
	public String decodeLong(long packed)
	{
		int [] decodedLong = decodeLongToDoubleInt(packed);
		String x = decodeInt(decodedLong[0]);
		String y = decodeInt(decodedLong[1]);
		return x + y;
	}
}
