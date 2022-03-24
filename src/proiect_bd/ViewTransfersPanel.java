package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewTransfersPanel extends JPanel {
    JPanel centralPanel = new JPanel();
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html><br/><br/>Vizualizare transferuri</html>", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    String username;

    ViewTransfersPanel(String user) {
        this.username = user;

        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        backbtn.setFocusPainted(false);

        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(350, 100)));
        btnsPanel.add(backbtn);


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
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ViewTransfersPanel panel = new ViewTransfersPanel("hori");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
