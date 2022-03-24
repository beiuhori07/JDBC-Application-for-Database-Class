package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class LoginAdminView extends JFrame{
	JTextField tf1 = new JTextField(15);
	private JPasswordField tf2 = new JPasswordField(15);
	private JButton btn1 = new JButton("Logare");
	private JButton btn2 = new JButton("Inapoi");
	private JLabel labelResult = new JLabel("incorrect username/password!", JLabel.CENTER);
	JLabel label = new JLabel("Logare Admin");

	
	LoginAdminView() {
		JLabel labelUser = new JLabel("Nume Utilizator", JLabel.CENTER);
		JLabel labelPass = new JLabel("Parola", JLabel.CENTER);
		labelResult.setForeground(Color.red);
		
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(120, 50, 250, 25);
		labelUser.setBounds(20, 150 , 150, 25);
		labelPass.setBounds(50, 190 , 75, 25);
		labelResult.setBounds(105, 215, 180, 25);
		tf1.setBounds(150, 150, 200, 25);
		tf2.setBounds(150, 190, 200, 25);
		btn1.setBounds(110, 240, 75, 35);
		btn2.setBounds(200, 240, 75, 35);

		labelResult.setVisible(false);
		
		this.add(labelResult);
		this.add(btn1);
		this.add(btn2);
		this.add(tf1);
		this.add(tf2);
		this.add(label);
		this.add(labelUser);
		this.add(labelPass);
		
		this.setLocation(600, 180);
		this.setSize(420, 420);
		this.setLayout(null);
		this.setResizable(false);
		
		this.setTitle("mare titlu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void removeThisFrame() {
		String username = tf1.getText();
		this.dispose();
		
	}

	public void setVisResultLabel(Boolean bool) {
		labelResult.setVisible(bool);
	}
	
	public void addLoginListener(ActionListener lal) {
		btn1.addActionListener(lal);
	}

	public void addBackListener(ActionListener bal) {
		btn2.addActionListener(bal);
	}
	
	public List<String> getUserInput() {
		List<String> list = new ArrayList<String>();
		list.add(tf1.getText());
		list.add(tf2.getText());
		return list;
	}
}
