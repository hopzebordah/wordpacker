package com.ske;

public class BitEncoder 
{
	// doubleword = int
	// quadword = long
	// i'm trying to be technical, can't you see
	
	public static final int INT_32 = 32;
	public static final int INT_64 = 64;
	
	// method to encode a four letter word. returns an int 
	public int encodeDoubleword(int [] doubleword)
	{
		// pack each int in array into a single int
		int packed = 0;
		for (int i=0; i<4; i++)
		{
			doubleword[i] = doubleword[i] << 24 - (i * 8);
			packed = packed | doubleword[i];
		}
		
		return packed;
	}
	
	public int [] decodeDoubleword(int packed)
	{
		int [] decoded = new int [4];
		for (int i=3; i>-1; i--)
		{
			decoded[i] = (packed & 0xFF);
			packed = packed >> 8;
		}
		return decoded;
	}
	
	// method to encode an eight letter word. returns a long
	public long encodeDoubleIntToLong(int x, int y)
	{
		long xL = Long.valueOf(x);
		long yL = Long.valueOf(y);
		
		xL = xL << 32;
		
		return (xL | yL);
	}
	
	public int [] decodeLongToDoubleInt(long packed)
	{
		// reverse the function of encode8chars
		int x = (int)(packed >> 32);
		int y = (int)(packed);
		return new int [] { x, y };
	}
}
