package vue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.FileReader;

//PAGE DECRYPTAGE

public class Vue_Decryptage {

	public Vue_Decryptage() {
		JFrame f = new JFrame("Page de decryptage");
		f.setSize(600, 400);
		f.setLayout(null);
		f.setVisible(true);
		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 1280, 700);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout(10, 10));

		final JTextField text = new JTextField();
		text.setBounds(180, 130, 300, 30);

		final JTextField textfin = new JTextField();
		textfin.setBounds(180, 200, 300, 30);

		JLabel label3 = new JLabel("inserer votre fichier:");
		label3.setBounds(20, 130, 120, 30);

		JLabel label4 = new JLabel("votre texte decrypte:");
		label4.setBounds(20, 200, 120, 30);

		JLabel label5 = new JLabel("Page de decryptage: ");
		label5.setFont(new Font("Georgia", Font.PLAIN, 60));
		label5.setForeground(new Color(100, 0, 0));
		label5.setBounds(20, -50, 1000, 175);

		JButton b = new JButton("Decrypter");
		b.setBounds(390, 300, 180, 40);

		JButton c = new JButton("Choisir fichier crypte");
		c.setBounds(10, 300, 180, 40);

		JButton d = new JButton("Choisir fichier destination");
		d.setBounds(200, 300, 180, 40);

		f.add(label3);
		f.add(label4);
		f.add(label5);

		f.add(b);
		f.add(c);
		f.add(d);
		f.add(text);
		f.add(textfin);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fr = new FileReader("C:\\Users\\maxim\\Documents\\PROSITS\\A3 cesi\\UE1 java\\test.txt");
					int i;
					while ((i = fr.read()) != -1)
						System.out.print((char) i);
					fr.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
	}
}