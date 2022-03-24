package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrentAccountPanel extends JPanel {
    JLabel label = new JLabel("<html><br/><br/>Actiuni cont curent</html>", JLabel.CENTER);
    JLabel ibanLabel = new JLabel("IBAN: 12413235132");
    JLabel balanceLabel = new JLabel("Sold curent: 0");
    JLabel goodDepositLabel = new JLabel("Depunere realizata cu succes!");
    JLabel goodWithdrawLabel = new JLabel("Retragere realizata cu succes!");
    JLabel badSumLabel = new JLabel("Suma incorecta!");
    JLabel sum = new JLabel("Suma: ");
    JTextField sumField = new JTextField();
    JButton trsfbtn = new JButton("Fa un transfer");
    JButton backbtn = new JButton("Inapoi");
    JButton depositbtn = new JButton("Depunere");
    JButton withdrawbtn = new JButton("Retragere");
    String username;

    CurrentAccountPanel(String user) {
        this.username = user;
        JPanel centerPanel = new JPanel();
        JPanel additionalPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        additionalPanel.setLayout(new BoxLayout(additionalPanel, BoxLayout.X_AXIS));

        this.setLayout(new BorderLayout());

        label.setFont(new Font("Dialog", Font.BOLD, 30));
        ibanLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        balanceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        sum.setFont(new Font("Dialog", Font.BOLD, 18));
        trsfbtn.setFocusPainted(false);
        trsfbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        backbtn.setFocusPainted(false);
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        depositbtn.setFocusPainted(false);
        depositbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        withdrawbtn.setFocusPainted(false);
        withdrawbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        goodDepositLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        goodWithdrawLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        badSumLabel.setFont(new Font("Dialog", Font.BOLD, 15));

        goodDepositLabel.setForeground(Color.green);
        goodWithdrawLabel.setForeground(Color.green);
        badSumLabel.setForeground(Color.red);

        goodDepositLabel.setVisible(false);
        goodWithdrawLabel.setVisible(false);
        badSumLabel.setVisible(false);

        sum.setBounds(290, 280, 70, 30);
        sumField.setBounds(360, 280, 150, 30);
        trsfbtn.setBounds(400, 390, 160, 35);
        withdrawbtn.setBounds(420, 330, 120, 35);
        goodDepositLabel.setBounds(310, 420, 250, 35);
        goodWithdrawLabel.setBounds(310, 420, 250, 35);
        badSumLabel.setBounds(340, 420, 120, 35);
        this.add(sum);
        this.add(sumField);
        this.add(trsfbtn);
        this.add(withdrawbtn);
        this.add(goodDepositLabel);
        this.add(goodWithdrawLabel);
        this.add(badSumLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(200, 70)));
        centerPanel.add(ibanLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerPanel.add(balanceLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 35)));
        //centerPanel.add(additionalPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerPanel.add(depositbtn);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerPanel.add(backbtn);
        centerPanel.add(Box.createRigidArea(new Dimension(200, 0)));
        
        this.add(label, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);        
    }
    public void setGoodDepositLabelVisible(boolean bool) {
        goodDepositLabel.setVisible(bool);
    }
    public void setGoodWithdrawLabelVisible(boolean bool) {
        goodWithdrawLabel.setVisible(bool);
    }
    public void setBadSumLabelVisible(boolean bool) {
        badSumLabel.setVisible(bool);
    }
    public void addTrsfActionListener(ActionListener al) {
        trsfbtn.addActionListener(al);
    }
    public void addDepositActionListener(ActionListener al) {
        depositbtn.addActionListener(al);
    }
    public void addWithdrawActionListener(ActionListener al) {
        withdrawbtn.addActionListener(al);
    }
    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void initAccData(String iban, int sold, int id) {
        ibanLabel.setText("IBAN: " + iban);
        balanceLabel.setText("Sold curent: " + sold);
        //this.id.setText("ID Client: " + id);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        CurrentAccountPanel panel = new CurrentAccountPanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
