package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NotificationPanel extends JPanel {
    JPanel centralPanel = new JPanel();
    JPanel centralParentPanel = new JPanel();
    JLabel label = new JLabel("<html><br/><br/>Notificari</html>", JLabel.CENTER);
    JLabel selectLabel = new JLabel("Selecteaza o notificare pentru a o elimina", JLabel.CENTER);
    JLabel badNotifLabel = new JLabel("Nu ai selectat o notificare!", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    JButton deletebtn = new JButton("Elimina notificare");
    int selectedId = 0;
    String username;

    NotificationPanel(String user) {
        this.username = user;

        this.setLayout(new BorderLayout());
        centralParentPanel.setLayout(new BoxLayout(centralParentPanel, BoxLayout.Y_AXIS));
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        deletebtn.setFont(new Font("Dialog", Font.BOLD, 16));
        selectLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        badNotifLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        badNotifLabel.setForeground(Color.red);
        backbtn.setFocusPainted(false);
        deletebtn.setFocusPainted(false);
        
        badNotifLabel.setBounds(200, 470, 350, 20);
        badNotifLabel.setVisible(false);
        this.add(badNotifLabel);

        JPanel btnsPanel = new JPanel();
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createRigidArea(new Dimension(260, 100)));
        btnsPanel.add(backbtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(deletebtn);
        btnsPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        btnsPanel.add(Box.createRigidArea(new Dimension(0, 100)));


        JScrollPane sp = new JScrollPane(centralPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.getVerticalScrollBar().setUnitIncrement(100);
        sp.setBorder(null);

        centralPanel.add(Box.createRigidArea(new Dimension(150, 50)));

        //ar trebui sa fie dimension proportional cu rowCount??
        centralPanel.setPreferredSize(new Dimension(400, 600));

        centralParentPanel.add(Box.createRigidArea(new Dimension(80, 30)));
        centralParentPanel.add(selectLabel);
        centralParentPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centralParentPanel.add(sp);
        // centralParentPanel.add(Box.createRigidArea(new Dimension(150, 0)));
        
        this.add(label,BorderLayout.NORTH);
        this.add(centralParentPanel, BorderLayout.CENTER);
        this.add(btnsPanel, BorderLayout.SOUTH);
    }

    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addDeleteActionListener(ActionListener al) {
        deletebtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        NotificationPanel panel = new NotificationPanel("beiuhori07");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
