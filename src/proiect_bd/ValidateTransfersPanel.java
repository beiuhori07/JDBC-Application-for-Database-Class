package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ValidateTransfersPanel extends JPanel {
    JPanel centralPanel = new JPanel();
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html><br/><br/>Validare transferuri</html>", JLabel.CENTER);
    JLabel badAccNrLabel = new JLabel("Ai deschis deja un numar maxim de conturi de economii!", JLabel.CENTER);
    JLabel goodLiqLabel = new JLabel("Lichidare realizata cu succes!", JLabel.CENTER);
    JLabel badLiqLabel = new JLabel("Nu ai selectat un cont!", JLabel.CENTER);
    JButton validatebtn = new JButton("Accepta transfer");
    JButton rejectbtn = new JButton("Refuza transfer");
    JButton backbtn = new JButton("Inapoi");
    int selectedTrid = 0;
    String username;

    ValidateTransfersPanel(String user) {
        this.username = user;

        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        validatebtn.setFont(new Font("Dialog", Font.BOLD, 16));
        rejectbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        badAccNrLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        goodLiqLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        badLiqLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        badAccNrLabel.setForeground(Color.red);
        badLiqLabel.setForeground(Color.red);
        goodLiqLabel.setForeground(Color.green);
        backbtn.setFocusPainted(false);
        
        badAccNrLabel.setBounds(200, 470, 350, 20);
        goodLiqLabel.setBounds(200, 470, 350, 20);
        badLiqLabel.setBounds(200, 470, 350, 20);
        badAccNrLabel.setVisible(false);
        goodLiqLabel.setVisible(false);
        badLiqLabel.setVisible(false);
        this.add(badAccNrLabel);
        this.add(goodLiqLabel);
        this.add(badLiqLabel);

        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(160, 100)));
        btnsPanel.add(backbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        btnsPanel.add(validatebtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        btnsPanel.add(rejectbtn);


        JScrollPane sp = new JScrollPane(centralPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getVerticalScrollBar().setUnitIncrement(100);
        sp.setBorder(null);

        centralPanel.add(Box.createRigidArea(new Dimension(150, 50)));

        //ar trebui sa fie dimension proportional cu rowCount??
        centralPanel.setPreferredSize(new Dimension(400, 600));

        centralParentPanel.add(Box.createRigidArea(new Dimension(80, 30)));
        centralParentPanel.add(sp);
        
        this.add(label,BorderLayout.NORTH);
        this.add(centralParentPanel, BorderLayout.CENTER);
        this.add(btnsPanel, BorderLayout.SOUTH);
    }

    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addValidateActionListener(ActionListener al) {
        validatebtn.addActionListener(al);
    }
    public void addRejectActionListener(ActionListener al) {
        rejectbtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ValidateTransfersPanel panel = new ValidateTransfersPanel("hori");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
