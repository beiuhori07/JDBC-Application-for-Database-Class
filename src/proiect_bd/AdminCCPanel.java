package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminCCPanel extends JPanel {
    JLabel label = new JLabel("<html><br/><br/>Conturi curente</html>", JLabel.CENTER);
    JLabel ibanLabel = new JLabel("IBAN: RO123ZZZZ");
    JLabel balanceLabel = new JLabel("Sold curent: 00000");
    JLabel goodDepositLabel = new JLabel("Depunere realizata cu succes!");
    JLabel goodWithdrawLabel = new JLabel("Retragere realizata cu succes!");
    JLabel badSumLabel = new JLabel("Suma incorecta!");
    JLabel id = new JLabel("Id: ");
    JTextField idField = new JTextField();
    JButton backbtn = new JButton("Inapoi");
    JButton filterbtn = new JButton("Filtreaza");
    int selectedId = 0;
    String username;
    JPanel centerPanel = new JPanel();
    
    AdminCCPanel(String user) {
        this.username = user;
        JPanel additionalPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        additionalPanel.setLayout(new BoxLayout(additionalPanel, BoxLayout.X_AXIS));

        this.setLayout(new BorderLayout());

        label.setFont(new Font("Dialog", Font.BOLD, 30));
        ibanLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        balanceLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        id.setFont(new Font("Dialog", Font.BOLD, 18));
        backbtn.setFocusPainted(false);
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        filterbtn.setFocusPainted(false);
        filterbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        goodDepositLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        goodWithdrawLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        badSumLabel.setFont(new Font("Dialog", Font.BOLD, 15));

        goodDepositLabel.setForeground(Color.green);
        goodWithdrawLabel.setForeground(Color.green);
        badSumLabel.setForeground(Color.red);

        goodDepositLabel.setVisible(false);
        goodWithdrawLabel.setVisible(false);
        badSumLabel.setVisible(false);

        id.setBounds(290, 320, 70, 30);
        idField.setBounds(350, 320, 150, 30);
        // goodDepositLabel.setBounds(310, 420, 250, 35);
        // goodWithdrawLabel.setBounds(310, 420, 250, 35);
        // badSumLabel.setBounds(340, 420, 120, 35);
        filterbtn.setBounds(390, 375, 120, 32);
        backbtn.setBounds(260, 375, 120, 32);
        this.add(id);
        this.add(idField);
        this.add(goodDepositLabel);
        this.add(goodWithdrawLabel);
        this.add(badSumLabel);
        this.add(filterbtn);
        this.add(backbtn);

        centerPanel.add(Box.createRigidArea(new Dimension(200, 70)));
        centerPanel.add(ibanLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(balanceLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        // centerPanel.add(backbtn);
        // centerPanel.add(Box.createRigidArea(new Dimension(200, 0)));
        
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
    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addFilterActionListener(ActionListener al) {
        filterbtn.addActionListener(al);
    }
    public void initAccData(String iban, int sold, int id) {
        ibanLabel.setText("IBAN: " + iban);
        balanceLabel.setText("Sold curent: " + sold);
        //this.id.setText("ID Client: " + id);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        AdminCCPanel panel = new AdminCCPanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
