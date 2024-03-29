package vue;

import javax.swing.*;

import controleur.Controleur_decryptage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;  

//PAGE DECRYPTAGE

public class Vue_Decryptage 
{ 
	String path = new String();
	public Vue_Decryptage(Controleur_decryptage controleurDecryptage) {
		
		JFrame f=new JFrame("Page de decryptage");    
		
		JPanel panel = new JPanel(); 
		
		panel.setBounds(0, 0, 1280, 700); 
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout(10, 10));
	     
	     final JTextField text = new JTextField();  
	     text.setBounds(180,130, 300,30);  
	     
	     final JTextField textfin = new JTextField();  
	     textfin.setBounds(180,200, 300,30); 
	     
	     JLabel label3=new JLabel("inserer votre fichier:");    
	     label3.setBounds(20,130, 120,30); 
	     
	     JLabel label4=new JLabel("votre texte decrypte:"); 
	     label4.setBounds(20,200, 120,30); 

	     JLabel label5 = new JLabel("Page de decryptage: "); 
	     label5.setFont(new Font("Georgia", Font.PLAIN, 60));
	     label5.setForeground(new Color(100, 0, 0));
	     label5.setBounds(20,-50,1000,175); 
	     
	     JButton b = new JButton("Decrypter");  
	     b.setBounds(390,300, 180,40);
	      
	     JButton c = new JButton("Chemin fichier crypt�");  
	     c.setBounds(10,300, 180,40);
	     
	     JButton d = new JButton("Chemin fichier destination");  
	     d.setBounds(200,300, 180,40);
	     
	     f.add(label3);  
	     f.add(label4); 
	     f.add(label5);
	     
	     f.add(b);
	     f.add(c); 
	     f.add(d); 
	     f.add(text);
	     f.add(textfin);
	     f.setSize(600, 400);    
	     f.setLayout(null);    
	     f.setVisible(true);
	     
	     b.addActionListener(new ActionListener() 
	     {  
		     public void actionPerformed(ActionEvent e) 
		     {       
		    	 try {
					controleurDecryptage.lancementDecryptage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}         
		     } 
	     });
	     
	     c.addActionListener(new ActionListener() 
         {
             public void actionPerformed(ActionEvent e) 
             {
                     JFileChooser fc = new JFileChooser();
                     fc.setCurrentDirectory(new File("/User"));

                     int result = fc.showOpenDialog(new JFrame());

                     if (result == JFileChooser.APPROVE_OPTION)
                     {
                         File selectedFile = fc.getSelectedFile();

                         path = selectedFile.getAbsolutePath();
                     }

                    text.setText(path);
                    controleurDecryptage.model.manipulationfichier.fichierLecture = path;

              }

         });
	     
	     d.addActionListener(new ActionListener() 
         {
             public void actionPerformed(ActionEvent e) 
             {
                     JFileChooser fc = new JFileChooser();
                     fc.setCurrentDirectory(new File("/User"));

                     int result = fc.showOpenDialog(new JFrame());

                     if (result == JFileChooser.APPROVE_OPTION)
                     {
                         File selectedFile = fc.getSelectedFile();

                         path = selectedFile.getAbsolutePath();
                     }

                    textfin.setText(path);
                    controleurDecryptage.model.manipulationfichier.fichierEcriture = path;
           	     	
              }

         });
	     Fermeture(f);
	}
	public void Fermeture(JFrame f) {
		WindowListener listener = new WindowAdapter() {
			 
			 @Override
			  
			 public void windowClosing(WindowEvent w) {
			  
			     System.exit(0);
			  
			 }
		 };
		f.addWindowListener(listener);
	}
} 