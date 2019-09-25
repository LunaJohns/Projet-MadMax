package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ManipulationFichier
{
	String data = new String();
	
	public void lectureFichier() throws IOException
	{
		BufferedReader in = null;
		File f = new File(data);
		int i;
		
		System.out.println(f.getAbsolutePath());
		System.out.println();
		
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
		
		System.out.println (data);
		
		for(i=0;i<=data.length()-1;i++)
		{
			System.out.print(data.charAt(i) + " ");
		}
		
		char tab[] = new char[data.length()];
		
		System.out.println("");
		for (int ii=0; ii<=data.length()-1;ii++)
		{
			tab[ii] = data.charAt(ii);
			System.out.print(tab[ii] + " ");
		}
		
		in.close();
	}
	
	
	public void ecritureFichier(FileWriter out) throws IOException
	{
		out = new FileWriter("test.txt");
		
		out.write("Abdelrahmane et Java ca fait 1");
		out.close();
	}
	
	public void ouvrirExplorateur()
	 {
		 JFileChooser fc = new JFileChooser();
		 fc.setCurrentDirectory(new File("/User"));
		 
		 int result = fc.showOpenDialog(new JFrame());
		 
		 if (result == JFileChooser.APPROVE_OPTION)
		 {
			 File selectedFile = fc.getSelectedFile();
			 
			 String path = selectedFile.getAbsolutePath();
			 
			 System.out.println(path);
		 }
	}
}
