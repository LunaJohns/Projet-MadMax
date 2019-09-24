package vue;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;  
public class PasswordFieldExample { 
	
	private String id, pwd; 
	
	public PasswordFieldExample() {
		JFrame f=new JFrame("CONNEXION");    
		
		JPanel panel = new JPanel(); 
		
		panel.setBounds(0, 0, 1280, 700); 
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new BorderLayout(10, 10));
		
		String lyrics = "PAGE DE CONNEXION";
		JLabel label1 = new JLabel(lyrics);
		label1.setFont(new Font("Georgia", Font.PLAIN, 50)); 
		label1.setForeground(new Color(100, 0, 0)); 
		
		panel.add(label1, BorderLayout.CENTER); 
		panel.setBorder(BorderFactory.createEmptyBorder(0, 380, 400, 0));
		
	     final JLabel label2 = new JLabel();            
	     label2.setBounds(20,150, 200,50);  
	     
	     final JPasswordField value = new JPasswordField();   
	     value.setBounds(100,75,100,30);  
	     
	     JLabel label3=new JLabel("Username:");    
	     label3.setBounds(20,20, 80,30);  
	     
	     JLabel label4=new JLabel("Password:"); 
	     label4.setBounds(20,75, 80,30);  
	     
	     JLabel label5 = new JLabel("Page de connexion: "); 
	     label5.setBounds(20,75, 80,30); 
	     
	     JButton b = new JButton("Login");  
	     b.setBounds(100,120, 80,30);
	     
	     final JTextField text = new JTextField();  
	     text.setBounds(100,20, 100,30);  
	     
	     f.add(value); 
	     f.add(label3); 
	     f.add(label2); 
	     f.add(label4); 
	     f.add(b); 
	     f.add(text);  
	     f.setSize(500, 300);    
	     f.setLayout(null);    
	     f.setVisible(true);
	                
	                /* b.addActionListener(new ActionListener() {  
	                public void actionPerformed(ActionEvent e) {       
	                   String data = "Username " + text.getText();  
	                   data += ", Password: "   
	                   + new String(value.getPassword());   
	                   label.setText(data);          
	                } 
	             }); */  
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

    public static void main(String[] args) {    
         
       new PasswordFieldExample(); 
}  
} 