package model;

public class Decryptage 
{
	
	public int[] listeCle;
	

	public Decryptage()
	{
		listeCle = new int[12];
		
		for (int i = 0; i < listeCle.length; i++) 
		{

			listeCle[i] = 97;
		}
		
	}
	
	public void genererListeCle(int index)
	{
		if (index < listeCle.length)
		{
			for (int x = 97; x <= 122;x++)
			{
				
				listeCle[index] = x;
				toString(listeCle);
				genererListeCle(index + 1);
				
				
			}
		}
		

	}
	
	
	public void toString(int[] tab) 
	{

		char[] tabChar = new char[tab.length];

		for (int i = 0; i < tab.length; i++) 
		{

			tabChar[i] = (char) tab[i];

		}

		String output = new String(tabChar);
		System.out.println(output);
		
	}
	
}
