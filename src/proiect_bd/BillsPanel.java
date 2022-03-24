package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillsPanel extends JPanel{
    JLabel label = new JLabel("<html><br/><br/>Plata facturi<html/>", JLabel.CENTER);
    JLabel selectlabel = new JLabel("Selecteaza un tip de factura", JLabel.CENTER);
    JLabel noMoneylabel = new JLabel("Nu ai destui bani!", JLabel.CENTER);
    JLabel noBilllabel = new JLabel("Nu ai selectat o factura!", JLabel.CENTER);
    JButton backbtn = new JButton("Inapoi");
    JButton paybtn = new JButton("Plateste");
    
    JPanel[] panels = new JPanel[4];
    Integer[] values = new Integer[4];
    JLabel[] strings = new JLabel[4];

    int selectedValue = 0;
    String username;

    BillsPanel(String user) {
        this.username = user;

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        label.setFont(new Font("Dialog", Font.BOLD, 34));
        selectlabel.setFont(new Font("Dialog", Font.BOLD, 20));
        noBilllabel.setFont(new Font("Dialog", Font.BOLD, 13));
        noMoneylabel.setFont(new Font("Dialog", Font.BOLD, 13));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        backbtn.setFocusPainted(false);
        paybtn.setFont(new Font("Dialog", Font.BOLD, 16));
        paybtn.setFocusPainted(false);
        
        for(int i = 0; i < 4; i++) {
            panels[i] = new JPanel();
            panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
            strings[i] = new JLabel("");
            strings[i].setFont(new Font("Dialog", Font.BOLD, 18));
            panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.X_AXIS));
            
            values[0] = 70;
            values[1] = 30;
            values[2] = 40;
            values[3] = 100;

            int nr = values[i];
            int nr3 = i;
            panels[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panels[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(nr);
                        selectedValue = nr;
                        for(int j = 0; j < 4; j++) {
                            int nr2 = j;
                            panels[nr2].setBackground(Color.white); 
                        }
                        panels[nr3].setBackground(Color.green); 
                    }
                });
        }

        strings[0].setText("Curent - 70 ron");
        strings[1].setText("Apa si canalizare - 30 ron");
        strings[2].setText("Internet - 40 ron");
        strings[3].setText("Gaz - 100 ron");

        noBilllabel.setForeground(Color.red);
        noMoneylabel.setForeground(Color.red);

        noBilllabel.setVisible(false);
        noMoneylabel.setVisible(false);
        
        noBilllabel.setBounds(290, 425, 200, 25);
        noMoneylabel.setBounds(290, 425, 200, 25);
        selectlabel.setBounds(250, 150, 300, 40);
        backbtn.setBounds(290, 450, 100, 40);
        paybtn.setBounds(410, 450, 100, 40);

        this.add(noBilllabel);
        this.add(noMoneylabel);
        this.add(selectlabel);
        this.add(backbtn);
        this.add(paybtn);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 80)));
        for(int i = 0; i < 4; i++) {
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            panels[i].add(Box.createRigidArea(new Dimension(20, 30)));
            panels[i].add(strings[i]);
            panels[i].add(Box.createRigidArea(new Dimension(20, 30)));
            centerPanel.add(panels[i]);
        }

        this.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(label ,BorderLayout.NORTH);
    }


    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addPayActionListener(ActionListener al) {
        paybtn.addActionListener(al);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BillsPanel panel = new BillsPanel("beiuhori07");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
