package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ManipulationFichier
{
	public String data = new String();
	public String fichierLecture;
	public String fichierEcriture;
	
	public String lectureFichier() throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(fichierLecture)));
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
