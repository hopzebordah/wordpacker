package com.ske;

public class Main 
{
	public static void main(String [] args)
	{
		StringEncoder encoder = new StringEncoder();
		
		long encoded = encoder.encode8chars("heyaheya");
		System.out.println(encoded);
		
		String decoded = encoder.decodeLong(encoded);
		System.out.println(decoded);
	}
}
