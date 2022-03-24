package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminSCPanel extends JPanel {
    JPanel centralPanel = new JPanel();
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html><br/>Conturi economii</html>", JLabel.CENTER);
    JLabel badAccNrLabel = new JLabel("Ai deschis deja un numar maxim de conturi de economii!", JLabel.CENTER);
    JLabel goodLiqLabel = new JLabel("Lichidare realizata cu succes!", JLabel.CENTER);
    JLabel badLiqLabel = new JLabel("Nu ai selectat un cont!", JLabel.CENTER);
    JLabel badSumLabel = new JLabel("Suma incorecta!", JLabel.CENTER);
    JLabel goodDepositLabel = new JLabel("Depunere realizata cu succes!", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    JButton filterbtn = new JButton("Filtreaza");
    JTextField idField = new JTextField();
    int selectedId = 0;
    String username;

    AdminSCPanel(String user) {
        this.username = user;

        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        filterbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        badAccNrLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        goodLiqLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        badLiqLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        badSumLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        goodDepositLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        badAccNrLabel.setForeground(Color.red);
        badLiqLabel.setForeground(Color.red);
        badSumLabel.setForeground(Color.red);
        goodLiqLabel.setForeground(Color.green);
        goodDepositLabel.setForeground(Color.green);
        backbtn.setFocusPainted(false);
        filterbtn.setFocusPainted(false);
        
        badAccNrLabel.setBounds(200, 470, 350, 20);
        goodLiqLabel.setBounds(200, 470, 350, 20);
        badLiqLabel.setBounds(200, 470, 350, 20);
        badSumLabel.setBounds(200, 470, 350, 20);
        goodDepositLabel.setBounds(200, 470, 350, 20);
        idField.setBounds(470, 500, 130, 30);
        badAccNrLabel.setVisible(false);
        goodLiqLabel.setVisible(false);
        badLiqLabel.setVisible(false);
        goodDepositLabel.setVisible(false);
        badSumLabel.setVisible(false);

        this.add(badAccNrLabel);
        this.add(goodLiqLabel);
        this.add(badLiqLabel);
        this.add(badSumLabel);
        this.add(idField);
        this.add(goodDepositLabel);

        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(240, 100)));
        btnsPanel.add(backbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(filterbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(Box.createRigidArea(new Dimension(0, 100)));


        JScrollPane sp = new JScrollPane(centralPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getVerticalScrollBar().setUnitIncrement(100);
        sp.setBorder(null);

        centralPanel.add(Box.createRigidArea(new Dimension(150, 50)));

        //ar trebui sa fie dimension proportional cu rowCount??
        centralPanel.setPreferredSize(new Dimension(400, 600));

        centralParentPanel.add(Box.createRigidArea(new Dimension(80, 30)));
        centralParentPanel.add(sp);
        // centralParentPanel.add(Box.createRigidArea(new Dimension(150, 0)));
        
        this.add(label,BorderLayout.NORTH);
        this.add(centralParentPanel, BorderLayout.CENTER);
        this.add(btnsPanel, BorderLayout.SOUTH);
    }
    public void setBadAccNrLabelVisible(boolean bool) {
        badAccNrLabel.setVisible(bool);
    }
    public void setGoodDepositLabelVisible(boolean bool) {
        goodDepositLabel.setVisible(bool);
    }
    public void setGoodLiqLabelVisible(boolean bool) {
        goodLiqLabel.setVisible(bool);
    }
    public void setBadLiqLabelVisible(boolean bool) {
        badLiqLabel.setVisible(bool);
    }
    public void setBadSumLabelVisible(boolean bool) {
        badSumLabel.setVisible(bool);
    }

    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addFilterActionListener(ActionListener al) {
        filterbtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        AdminSCPanel panel = new AdminSCPanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
