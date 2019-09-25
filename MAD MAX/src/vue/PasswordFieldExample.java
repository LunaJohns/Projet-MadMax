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
				
	     final JLabel label2 = new JLabel();            
	     label2.setBounds(480,300, 400,30);  
	     
	     final JTextField text = new JTextField();  
	     text.setBounds(480,300, 300,30);  
	     
	     final JPasswordField value = new JPasswordField();   
	     value.setBounds(480,350,300,30);  
	     
	     JLabel label3=new JLabel("Username:");    
	     label3.setBounds(380,300, 80,30);  
	     
	     JLabel label4=new JLabel("Password:"); 
	     label4.setBounds(380,350, 80,30);  
	     
	     JLabel label5 = new JLabel("Page de connexion: "); 
	     label5.setFont(new Font("Georgia", Font.PLAIN, 100));
	     label5.setForeground(new Color(100, 0, 0));
	     label5.setBounds(180,100,1000,175); 
	     
	     JButton b = new JButton("Login");  
	     b.setBounds(570,400, 80,30);
	     
	     
	     f.add(value); 
	     f.add(label3); 
	     f.add(label2); 
	     f.add(label4); 
	     f.add(label5);
	     
	     f.add(b); 
	     f.add(text);  
	     f.setSize(1500, 680);    
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