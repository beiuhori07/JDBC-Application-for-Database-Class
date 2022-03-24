package proiect_bd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MainMenuClientView extends JFrame{
    private JLabel mainmenuLabel = new JLabel("<html><br/><br/>Meniu Principal</html>", JLabel.CENTER);
    JButton crtAccbtn = new JButton("<html>Actiuni cont <br/> &nbsp;&nbsp; curent</html>");
    JButton svgAccbtn = new JButton("<html>Actiuni conturi <br/> &nbsp;&nbsp; economii</html>");
    JButton trsfbtn = new JButton("Transferuri");
    JButton notifbtn = new JButton("Notificari");
    JButton favoritebtn = new JButton("Contacte favorite");
    JButton personalDatabtn = new JButton("Date personale");
    JButton logoutbtn = new JButton("Delogare");
    JButton billsbtn = new JButton("Facturi");
    JPanel cards = new JPanel(new CardLayout());
    CardLayout cl = (CardLayout)(cards.getLayout());
    CurrentAccountPanel crtAccPanel;
    TransferPanel trasnferPanel;
    PersonalDataPanel personalDataPanel;
    FavoritePanel favoritePanel;
    SavingsAccountPanel svgAccPanel;
    NotificationPanel notificationPanel;
    BillsPanel billsPanel;
    private String user;
    
    MainMenuClientView(String username) {
        this.user = username;
        this.crtAccPanel = new CurrentAccountPanel(this.user);
        this.trasnferPanel = new TransferPanel(this.user);
        this.personalDataPanel = new PersonalDataPanel(this.user);
        this.favoritePanel = new FavoritePanel(this.user);
        this.svgAccPanel = new SavingsAccountPanel(this.user);
        this.notificationPanel = new NotificationPanel(this.user);
        this.billsPanel = new BillsPanel(this.user);

        JPanel parentPanel = new JPanel();
        JPanel nextPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel centerVertLPanel = new JPanel();
        JPanel centerVertRPanel = new JPanel();
        JPanel southBoxPanel = new JPanel();

        JLabel label = new JLabel("<html><br/><br/>Hey man</html>", JLabel.CENTER);
        nextPanel.add(label);
        
        parentPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        centerVertLPanel.setLayout(new BoxLayout(centerVertLPanel, BoxLayout.Y_AXIS));
        centerVertRPanel.setLayout(new BoxLayout(centerVertRPanel, BoxLayout.Y_AXIS));
        southBoxPanel.setLayout(new BoxLayout(southBoxPanel, BoxLayout.Y_AXIS));
        
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertLPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertRPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        
        mainmenuLabel.setFont(new Font("Dialog", Font.BOLD, 28));
        mainmenuLabel.setPreferredSize(new Dimension(200, 100));
        
        crtAccbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        crtAccbtn.setFocusPainted(false);
        crtAccbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        svgAccbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        svgAccbtn.setFocusPainted(false);
        svgAccbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        trsfbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        trsfbtn.setFocusPainted(false);

        billsbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        billsbtn.setFocusPainted(false);

        logoutbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        logoutbtn.setFocusPainted(false);
        
        notifbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        notifbtn.setFocusPainted(false);
        favoritebtn.setFont(new Font("Dialog", Font.BOLD, 16));
        favoritebtn.setFocusPainted(false);
        
        personalDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        personalDatabtn.setFocusPainted(false);

        southBoxPanel.add(Box.createRigidArea(new Dimension(150, 30)));
        southBoxPanel.add(logoutbtn);
        southBoxPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        
        parentPanel.add(mainmenuLabel, BorderLayout.NORTH);
        parentPanel.add(centerPanel, BorderLayout.CENTER);
        parentPanel.add(southBoxPanel, BorderLayout.SOUTH);
        
        centerVertLPanel.add(crtAccbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(trsfbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(favoritebtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(billsbtn);
        
        centerVertRPanel.add(svgAccbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(notifbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(personalDatabtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        
        cards.add(parentPanel, "ParentPanel");
        cards.add(crtAccPanel, "CurrentAccount");
        cards.add(trasnferPanel, "Transfer");
        cards.add(personalDataPanel, "PersonalData");
        cards.add(favoritePanel, "favoritePanel");
        cards.add(svgAccPanel, "savingsPanel");
        cards.add(notificationPanel, "notificationPanel");
        cards.add(billsPanel, "billsPanel");

        cl.show(cards, "ParentPanel");
        
        this.setContentPane(cards);
        this.setLocation(380, 110);
		this.setSize(800, 600);
		this.setResizable(false);
		
		this.setTitle("mare titlu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void addBillsActionListener(ActionListener al) {
        billsbtn.addActionListener(al);
    }
    public void addLogoutListener(ActionListener al) {
        logoutbtn.addActionListener(al);
    }
    public void addCrtAccListener(ActionListener al) {
        crtAccbtn.addActionListener(al);
    }
    public void addSvgAccListener(ActionListener al) {
        svgAccbtn.addActionListener(al);
    }
    public void addTransferListener(ActionListener al) {
        trsfbtn.addActionListener(al);
    }
    public void addNotificationListener(ActionListener al) {
        notifbtn.addActionListener(al);
    }
    public void addFavoriteListener(ActionListener al) {
        favoritebtn.addActionListener(al);
    }
    public void addPersonalDataListener(ActionListener al) {
        personalDatabtn.addActionListener(al);
    }

    public static void main(String[] args) {
        MainMenuClientView view = new MainMenuClientView("user");
    }
}
