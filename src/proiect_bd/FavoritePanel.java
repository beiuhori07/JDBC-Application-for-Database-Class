package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FavoritePanel extends JPanel{
    JLabel[] l;
    JPanel centralPanel = new JPanel();
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html><br/><br/>Contacte Favorite</html>", JLabel.CENTER);
    JLabel selectLabel = new JLabel("Selecteaza un contact pentru a realiza un transfer", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    JButton addbtn = new JButton("Adauga contact");
    JTextField idField = new JTextField();
    JLabel wrongidLabel = new JLabel("id incorect!");
    String username;

    FavoritePanel(String user) {
        this.username = user;
        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        addbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        selectLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        wrongidLabel.setFont(new Font("Dialog", Font.BOLD, 13));

        wrongidLabel.setForeground(Color.red);
        wrongidLabel.setBounds(350, 470, 150, 25);
        wrongidLabel.setVisible(false);
        this.add(wrongidLabel);

        backbtn.setFocusPainted(false);
        addbtn.setFocusPainted(false);
        
        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(200, 100)));
        btnsPanel.add(backbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(addbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(0, 100)));

        idField.setBounds(480, 500, 150, 30);
        this.add(idField);

        JScrollPane sp = new JScrollPane(centralPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getVerticalScrollBar().setUnitIncrement(100);
        sp.setBorder(null);

        centralPanel.add(Box.createRigidArea(new Dimension(150, 50)));

        //ar trebui sa fie dimension proportional cu rowCount??
        centralPanel.setPreferredSize(new Dimension(400, 600));

        centralParentPanel.add(Box.createRigidArea(new Dimension(80, 50)));
        centralParentPanel.add(selectLabel);
        centralParentPanel.add(sp);
        // centralParentPanel.add(Box.createRigidArea(new Dimension(150, 0)));
        
        this.add(label,BorderLayout.NORTH);
        this.add(centralParentPanel, BorderLayout.CENTER);
        this.add(btnsPanel, BorderLayout.SOUTH);

        //LoadLabels();
    }
    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addAddFavActionListener(ActionListener al) {
        addbtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        FavoritePanel panel = new FavoritePanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
