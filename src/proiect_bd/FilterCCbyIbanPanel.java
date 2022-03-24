package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FilterCCbyIbanPanel extends JPanel{
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html>Actiuni Cont Curent<br/>filtrate prin IBAN</htm>", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    JPanel btnsPanel = new JPanel();
    JButton filterBtn = new JButton("Filtreaza");
    JTextField ibanField = new JTextField();
    String selectedIban = "";
    String username;
    
    FilterCCbyIbanPanel(String user) {
        this.username = user;
        
        JPanel rigidareaWest = new JPanel();
        rigidareaWest.setLayout(new BoxLayout(rigidareaWest, BoxLayout.X_AXIS));
        JPanel rigidareaEast = new JPanel();
        rigidareaEast.setLayout(new BoxLayout(rigidareaEast, BoxLayout.X_AXIS));

        rigidareaEast.add(Box.createRigidArea(new Dimension(50, 0)));
        rigidareaWest.add(Box.createRigidArea(new Dimension(50, 0)));

        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        backbtn.setFocusPainted(false);
        
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(250, 100)));
        btnsPanel.add(backbtn);
        
        centralParentPanel.add(Box.createRigidArea(new Dimension(80, 30)));
        
        filterBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        filterBtn.setFocusPainted(false);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(filterBtn);
        ibanField.setBounds(470, 500, 170, 30);
        this.add(ibanField);
        
        this.add(label,BorderLayout.NORTH);
        this.add(centralParentPanel, BorderLayout.CENTER);
        this.add(btnsPanel, BorderLayout.SOUTH);
        this.add(rigidareaWest, BorderLayout.WEST);
        this.add(rigidareaEast, BorderLayout.EAST);
    }

    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addFilterActionListener(ActionListener al) {
        filterBtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        FilterCCbyIbanPanel panel = new FilterCCbyIbanPanel("hori");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }   
}

