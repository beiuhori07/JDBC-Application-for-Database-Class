package proiect_bd;


import javax.swing.*;
import javax.swing.plaf.BorderUIResource;

import java.awt.*;
import java.awt.event.*;

public class StatsPanel extends JPanel {
    JLabel label = new JLabel("<html><br/>Date statistice</html>");
    JLabel employeeLabel = new JLabel("Angajati : ZZ");
    JLabel clientLabel = new JLabel("Clienti : ZZ");
    JLabel transferLabel = new JLabel("Transferuri : ZZ");
    JLabel scLabel = new JLabel("Conturi economii : ZZ");
    JLabel actccLabel = new JLabel("Actiuni cont curent : ZZ");
    JLabel actscLabel = new JLabel("Actiuni cont economii : ZZ");
    JButton backbtn = new JButton("Inapoi");
    JPanel ypanel = new JPanel();
    JPanel southpanel = new JPanel();
    JPanel northpanel = new JPanel();
    
    StatsPanel() {
        this.setLayout(new BorderLayout());
        ypanel.setLayout(new BoxLayout(ypanel, BoxLayout.Y_AXIS));
        southpanel.setLayout(new BoxLayout(southpanel, BoxLayout.X_AXIS));
        northpanel.setLayout(new BoxLayout(northpanel, BoxLayout.X_AXIS));

        label.setFont(new Font("Dialog", Font.BOLD, 34));
        employeeLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        clientLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        transferLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        scLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        actccLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        actscLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));

        backbtn.setFocusPainted(false);

        ypanel.add(Box.createRigidArea(new Dimension(250, 70)));
        ypanel.add(employeeLabel);
        ypanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ypanel.add(clientLabel);
        ypanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ypanel.add(transferLabel);
        ypanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ypanel.add(scLabel);
        ypanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ypanel.add(actccLabel);
        ypanel.add(Box.createRigidArea(new Dimension(0, 30)));
        ypanel.add(actscLabel);

        southpanel.add(Box.createRigidArea(new Dimension(350, 0)));
        southpanel.add(backbtn);
        southpanel.add(Box.createRigidArea(new Dimension(0, 100)));
        
        northpanel.add(Box.createRigidArea(new Dimension(270, 0)));
        northpanel.add(label);

        this.add(southpanel, BorderLayout.SOUTH);
        this.add(northpanel, BorderLayout.NORTH);
        this.add(ypanel, BorderLayout.CENTER);
    }
    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        StatsPanel panel = new StatsPanel();
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
