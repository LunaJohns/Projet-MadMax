package vue;

import javax.swing.*;

import controleur.Controleur_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.WindowListener;

public class Vue_Connexion { 
	
	private String id, pwd;
	
	public Vue_Connexion(Controleur_main controleurMain) {
		
		 
		JFrame f=new JFrame("CONNEXION");    
		
		JPanel panel = new JPanel(); 
		
		panel.setBounds(0, 0, 1280, 700); 
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new BorderLayout(10, 10));
				
	     final JLabel label2 = new JLabel();            
	     label2.setBounds(180,300, 400,30);  
	     
	     final JTextField text = new JTextField();  
	     text.setBounds(180,200, 300,30);  
	     
	     final JPasswordField value = new JPasswordField();   
	     value.setBounds(180,250,300,30);  
	     
	     JLabel label3=new JLabel("Username:");    
	     label3.setBounds(80,200, 80,30);  
	     
	     JLabel label4=new JLabel("Password:"); 
	     label4.setBounds(80,250, 80,30);  

	     JLabel label5 = new JLabel("Page de connexion: "); 
	     label5.setFont(new Font("Georgia", Font.PLAIN, 60));
	     label5.setForeground(new Color(100, 0, 0));
	     label5.setBounds(50,0,1000,175); 
	     
	     JButton b = new JButton("Login");  
	     b.setBounds(280,300, 80,30);
	     
	     f.add(value); 
	     f.add(label3); 
	     f.add(label2); 
	     f.add(label4); 
	     f.add(label5);
	     
	     f.add(b); 
	     f.add(text);  
	     f.setSize(600, 400);    
	     f.setLayout(null);    
	     f.setVisible(true);
	                
	     b.addActionListener(new ActionListener() 
	     {  
		     public void actionPerformed(ActionEvent e) 
		     {       
		    	
				boolean etatConnexion = controleurMain.model.cad.Connexion();
				Set_Id(text.getText());
				Set_Pwd(new String(value.getPassword()));
				String requete = controleurMain.model.mappersonne.requeteVerifierUtilisateur(id, pwd);
					
				if (etatConnexion == true)
				{
					int occurence = controleurMain.model.cad.executerRequete(requete);
					if (occurence > 0)
					{
						
						controleurMain.controleurConnexion.lancementConnexion(controleurMain.controleurDecryptage);

						
					}
					controleurMain.model.cad.Fermeture();
				}
				
		     } 
	     });
	     
	}
	
	public void fermeture(JFrame f) {
		WindowListener listener = new WindowAdapter() {

	        @Override

	        public void windowClosing(WindowEvent w) {

	           f.dispose();

	        }
	    };
	    f.addWindowListener(listener);
	}
	
	
	
	public void Set_Id(String id) {
		this.id = id; 
	}
	public void Set_Pwd(String pwd) {
		this.pwd = pwd; 
	}
	
	public String Get_Id() {
		return this.id; 
	}
	
	public String Get_Pwd() {
		return this.pwd; 
	}
 
} 