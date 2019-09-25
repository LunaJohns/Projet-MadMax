package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectureFichier
{
	public static void lectureFichier(String data, String key) throws IOException
	{
		BufferedReader in = null;
		
		try
		{
			in = new BufferedReader(new FileReader("test.txt"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			data = in.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		char tab[] = new char[data.length()];
		
		System.out.println (data);
		
		for(int i=0;i<=data.length()-1;i++)
		{
			System.out.print(data.charAt(i) + " ");
		}
		
		System.out.println("");
		
		for (int ii=0; ii<=data.length()-1;ii++)
		{
			tab[ii] = data.charAt(ii);
			System.out.print(tab[ii] + " ");
		}
		
		in.close();
	}
	
}
