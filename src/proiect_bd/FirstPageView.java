package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPageView extends JFrame{
    private JButton btnCrtUser = new JButton("Creeaza utilizator");
    private JButton btnCrtEmpl = new JButton("Creeaza angajat");
    private JButton btnLogUser = new JButton("Logare utilizator");
    private JButton btnLogEmpl = new JButton("Logare angajat");
    private JButton btnLogAdmin = new JButton("Logare admin");
    
    FirstPageView() {
        JLabel label = new JLabel("Bine ai venit!", JLabel.CENTER);
        btnCrtUser.setBounds(80, 170, 150, 30);
        btnCrtEmpl.setBounds(80, 220, 150, 30);
        btnLogUser.setBounds(260, 170, 150, 30);
        btnLogEmpl.setBounds(260, 220, 150, 30);
        btnLogAdmin.setBounds(170, 270, 150, 30);
        label.setBounds(120, 70, 250, 50);
        label.setFont(new Font("Dialog", Font.BOLD, 24));

        btnCrtEmpl.setFocusPainted(false);
        btnCrtUser.setFocusPainted(false);
        btnLogAdmin.setFocusPainted(false);
        btnLogEmpl.setFocusPainted(false);
        btnLogUser.setFocusPainted(false);

        this.add(label);
        this.add(btnCrtUser);
        this.add(btnCrtEmpl);
        this.add(btnLogUser);
        this.add(btnLogEmpl);
        this.add(btnLogAdmin);

        this.setLocation(380, 110);
		this.setSize(520, 440);
		this.setLayout(null);
		this.setResizable(false);
		
		this.setTitle("mare titlu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addLoginUserListener(ActionListener lal) {
		btnLogUser.addActionListener(lal);
	}
    public void addLoginEmplListener(ActionListener lal) {
		btnLogEmpl.addActionListener(lal);
	}
    public void addLoginAdminListener(ActionListener lal) {
		btnLogAdmin.addActionListener(lal);
	}
    public void addCrtEmplListener(ActionListener lal) {
		btnCrtEmpl.addActionListener(lal);
	}
    public void addCrtUserListener(ActionListener lal) {
		btnCrtUser.addActionListener(lal);
	}
    public static void main(String[] args) {
        FirstPageView view = new FirstPageView();
    }
}
