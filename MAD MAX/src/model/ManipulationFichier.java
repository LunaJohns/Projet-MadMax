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
	public String data = new String();
	public String fichierLecture;
	public String fichierEcriture;
	
	public String lectureFichier() throws IOException
	{
		BufferedReader in = null;
	
		try
		{
			in = new BufferedReader(new FileReader(fichierLecture));
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
		
		for (int ii=0; ii<=data.length()-1;ii++)
		{
			tab[ii] = data.charAt(ii);
		}
		
		
		in.close();
		return data;
	}
	
	
	public void ecritureFichier(String textDecrypte) throws IOException
	{
		
		FileWriter out = new FileWriter(fichierEcriture);
		
		out.write(textDecrypte);
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
