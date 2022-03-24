package proiect_bd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PersonalDataPanel extends JPanel{
    JLabel label = new JLabel("<html><br/><br/>Date personale</html>", JLabel.CENTER);
    JLabel numeLabel = new JLabel("Nume: ", JLabel.RIGHT);
    JLabel prenumeLabel = new JLabel("Prenume: ", JLabel.RIGHT);
    JLabel cnpLabel = new JLabel("CNP: ", JLabel.RIGHT);
    JLabel usernameLabel = new JLabel("Nume utilizator: ", JLabel.RIGHT);
    JLabel idLabel = new JLabel("ID Client: ", JLabel.RIGHT);
    JLabel adressLabel = new JLabel("Adresa: ", JLabel.RIGHT);
    JLabel nrLabel = new JLabel("Numar telefon: ", JLabel.RIGHT);
    JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);
    JLabel bankLabel = new JLabel("Banca: ", JLabel.RIGHT);
    JLabel dateLabel = new JLabel("Data nasterii: ", JLabel.RIGHT);

    JTextField nume = new JTextField(10);
    JTextField prenume = new JTextField(10);
    JTextField cnp = new JTextField(10);
    JTextField username = new JTextField(10);
    JTextField id = new JTextField(10);
    JTextField adress = new JTextField(10);
    JTextField nr = new JTextField(10);
    JTextField email = new JTextField(10);
    JTextField bank = new JTextField(10);
    JTextField date = new JTextField(10);

    JButton modifybtn = new JButton("Modifica datele");
    JButton backbtn = new JButton("Inapoi");
    String user;

    PersonalDataPanel(String username) {
        this.user = username;
        id.setEditable(false);
        bank.setEditable(false);
        this.username.setEditable(false);
        
        JPanel centerPanel = new JPanel();
        JPanel centerparentPanel = new JPanel();
        JPanel rigidarea1 = new JPanel();
        JPanel rigidarea0 = new JPanel();

        JScrollPane sp = new JScrollPane(centerPanel);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getVerticalScrollBar().setUnitIncrement(100);
        sp.setBorder(null);

        label.setFont(new Font("Dialog", Font.BOLD, 26));
        numeLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        prenumeLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        cnpLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        usernameLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        idLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        adressLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        nrLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        emailLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        bankLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        dateLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        modifybtn.setFont(new Font("Dialog", Font.BOLD, 14));
        backbtn.setFont(new Font("Dialog", Font.BOLD, 14));

        rigidarea1.setLayout(new BoxLayout(rigidarea1, BoxLayout.X_AXIS));
        rigidarea0.setLayout(new BoxLayout(rigidarea0, BoxLayout.Y_AXIS));
        centerparentPanel.setLayout(new BoxLayout(centerparentPanel, BoxLayout.X_AXIS));
        //centerparentPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        JPanel rigidarea2 = new JPanel();
        rigidarea2.setLayout(new BoxLayout(rigidarea2, BoxLayout.Y_AXIS));
        rigidarea1.add(Box.createRigidArea(new Dimension(0, 100)));
        rigidarea1.add(Box.createRigidArea(new Dimension(270, 0)));
        rigidarea1.add(modifybtn);
        rigidarea1.add(Box.createRigidArea(new Dimension(20, 0)));
        rigidarea1.add(backbtn);
        rigidarea1.add(Box.createRigidArea(new Dimension(0, 30)));

        rigidarea2.add(Box.createRigidArea(new Dimension(220, 0)));

        centerPanel.setLayout(new GridLayout(0, 2, 5, 25));

        this.setLayout(new BorderLayout());
        // centerPanel.setMaximumSize(new Dimension(400, 400));
        centerPanel.setPreferredSize(new Dimension(400, 600));
        centerPanel.add(numeLabel);
        centerPanel.add(nume);
        centerPanel.add(prenumeLabel);
        centerPanel.add(prenume);
        centerPanel.add(cnpLabel);
        centerPanel.add(cnp);
        centerPanel.add(usernameLabel);
        centerPanel.add(this.username);
        centerPanel.add(idLabel);
        centerPanel.add(id);
        centerPanel.add(adressLabel);
        centerPanel.add(adress);
        centerPanel.add(nrLabel);
        centerPanel.add(nr);
        centerPanel.add(emailLabel);
        centerPanel.add(email);
        centerPanel.add(bankLabel);
        centerPanel.add(bank);
        centerPanel.add(dateLabel);
        centerPanel.add(date);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 300)));

        centerparentPanel.add(sp);

        
        rigidarea0.add(label);
        rigidarea0.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(rigidarea0, BorderLayout.NORTH);
        this.add(rigidarea1, BorderLayout.SOUTH);
        this.add(centerparentPanel, BorderLayout.CENTER);   
        this.add(rigidarea2, BorderLayout.EAST);
    }
    public void addBackActionListener(ActionListener al) {
        backbtn.addActionListener(al);
    }
    public void addModifyActionListener(ActionListener al) {
        modifybtn.addActionListener(al);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PersonalDataPanel panel = new PersonalDataPanel("user");
        frame.setContentPane(panel);

        frame.setLocation(380, 110);
		frame.setSize(800, 600);
		frame.setResizable(false);
		
		frame.setTitle("mare titlu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
