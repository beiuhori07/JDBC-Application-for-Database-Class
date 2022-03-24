package proiect_bd;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransferPanel extends JPanel {
    JLabel label = new JLabel("<html><br/><br/>Transferuri</html>",JLabel.CENTER);
    JLabel ibanLabel = new JLabel("IBAN Destinatar: ",JLabel.RIGHT);
    JTextField iban = new JTextField(10);
    JLabel sumLabel = new JLabel("Suma: ",JLabel.RIGHT);
    JTextField sum = new JTextField();
    JButton trsfbtn = new JButton("Trimite");
    JButton backbtn = new JButton("Inapoi");
    JLabel badIBANlabel = new JLabel("IBAN Inexistent!");
    JLabel badSumlabel = new JLabel("Suma prea mare!");
    String username;
    TransferPanel(String user) {
        this.username = user;

        JPanel centerPanel = new JPanel();
        JPanel centerVertLPanel = new JPanel();
        JPanel centerVertRPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerVertLPanel.setLayout(new BoxLayout(centerVertLPanel, BoxLayout.Y_AXIS));
        centerVertRPanel.setLayout(new BoxLayout(centerVertRPanel, BoxLayout.Y_AXIS));
        // centerVertRPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        ibanLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        sumLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 15));
        trsfbtn.setFont(new Font("Dialog", Font.BOLD, 15));
        trsfbtn.setFocusPainted(false);
        backbtn.setFocusPainted(false);

        centerPanel.add(Box.createRigidArea(new Dimension(200, 0)));
        centerPanel.add(centerVertLPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertRPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(200, 0)));


        centerVertLPanel.add(ibanLabel);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(sumLabel);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(backbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));


        iban.setMaximumSize(new Dimension(330, 30));
        sum.setMaximumSize(new Dimension(330, 30));

        centerVertRPanel.add(iban);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerVertRPanel.add(sum);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerVertRPanel.add(trsfbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        badIBANlabel.setForeground(Color.RED);
        badSumlabel.setForeground(Color.RED);
        badIBANlabel.setBounds(300, 400, 150, 25);
        badSumlabel.setBounds(300, 400, 150, 25);
        badSumlabel.setFont(new Font("Dialog",Font.BOLD, 13));;
        badIBANlabel.setFont(new Font("Dialog",Font.BOLD, 13));;
        badIBANlabel.setVisible(false);
        badSumlabel.setVisible(false);

        this.add(badIBANlabel);
        this.add(badSumlabel);

        this.setLayout(new BorderLayout());

        this.add(label, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
    public void setBadIbanLabelVisible(boolean bool) {
        badIBANlabel.setVisible(bool);
    }
    public void setBadSumLabelVisible(boolean bool) {
        badSumlabel.setVisible(bool);
    }
    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addTrasnferActionListener(ActionListener al) {
        trsfbtn.addActionListener(al);
    }
    public String getIban() {
        return iban.getText();
    }
    public String getSum() {
        return sum.getText();
    }
    public static boolean isNumeric(String string) {
        int intValue;    
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    public int getIntSum() {
        if(isNumeric(getSum())) {
            int value = Integer.parseInt(getSum());
            return value;
        }
        return 0;
    }
    public void reset() {
        iban.setText("");
        sum.setText("");
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        TransferPanel panel = new TransferPanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
