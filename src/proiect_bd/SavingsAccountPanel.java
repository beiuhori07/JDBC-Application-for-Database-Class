package proiect_bd;

import javax.swing.*;

import proiect_bd.MainMenuController.DepositListener;

import java.awt.*;
import java.awt.event.*;

public class SavingsAccountPanel extends JPanel {
    JPanel centralPanel = new JPanel();
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html><br/>Actiuni cont<br/>&nbsp;&nbsp;economii</html>", JLabel.CENTER);
    JLabel selectLabel = new JLabel("Selecteaza un cont pentru a realiza o actiune", JLabel.CENTER);
    JLabel badAccNrLabel = new JLabel("Ai deschis deja un numar maxim de conturi de economii!", JLabel.CENTER);
    JLabel goodLiqLabel = new JLabel("Lichidare realizata cu succes!", JLabel.CENTER);
    JLabel badLiqLabel = new JLabel("Nu ai selectat un cont!", JLabel.CENTER);
    JLabel badSumLabel = new JLabel("Suma incorecta!", JLabel.CENTER);
    JLabel goodDepositLabel = new JLabel("Depunere realizata cu succes!", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    JButton liquidationbtn = new JButton("Lichidare Cont");
    JButton crtbtn = new JButton("Creeaza Cont");
    JButton depositbtn = new JButton("Depunere in cont");
    JTextField sumField = new JTextField();
    String selectedIban = "";
   // int lastIterator;
    String username;

    SavingsAccountPanel(String user) {
        this.username = user;

        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        liquidationbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        crtbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        depositbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        selectLabel.setFont(new Font("Dialog", Font.BOLD, 16));
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
        crtbtn.setFocusPainted(false);
        liquidationbtn.setFocusPainted(false);
        depositbtn.setFocusPainted(false);
        
        badAccNrLabel.setBounds(200, 470, 350, 20);
        goodLiqLabel.setBounds(200, 470, 350, 20);
        badLiqLabel.setBounds(200, 470, 350, 20);
        badSumLabel.setBounds(200, 470, 350, 20);
        goodDepositLabel.setBounds(200, 470, 350, 20);
        sumField.setBounds(640, 500, 130, 30);
        badAccNrLabel.setVisible(false);
        goodLiqLabel.setVisible(false);
        badLiqLabel.setVisible(false);
        goodDepositLabel.setVisible(false);
        this.add(badAccNrLabel);
        this.add(goodLiqLabel);
        this.add(badLiqLabel);
        this.add(badSumLabel);
        this.add(sumField);
        this.add(goodDepositLabel);

        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(40, 100)));
        btnsPanel.add(backbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(liquidationbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(crtbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(depositbtn);
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
        centralParentPanel.add(selectLabel);
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
    public void addSvgDepositActionListener(ActionListener al) {
        depositbtn.addActionListener(al);
    }
    public void addLiquidationActionListener(ActionListener al) {
        liquidationbtn.addActionListener(al);
    }
    public void addCreateSvgActionListener(ActionListener al) {
        crtbtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SavingsAccountPanel panel = new SavingsAccountPanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
