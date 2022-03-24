package proiect_bd;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AdminMainMenuView extends JFrame{
    private JLabel mainmenuLabel = new JLabel("<html><br/><br/>Meniu Principal</html>", JLabel.CENTER);
    JButton ccbtn = new JButton("Conturi curente");
    JButton scbtn = new JButton("Conturi economii");
    JButton actccbtn = new JButton("Actiuni cont curent");
    JButton actscbtn = new JButton("Actiuni cont economii");
    JButton clientDatabtn = new JButton("Date clienti");
    JButton personalDatabtn = new JButton("Date personale");
    JButton statsDatabtn = new JButton("Date statistice");
    JButton employeeListbtn = new JButton("Lista anagajati");
    JButton clientListbtn = new JButton("Lista clienti");

    JButton logoutbtn = new JButton("Delogare");
    JPanel cards = new JPanel(new CardLayout());
    AdminPersonalDataPanel personalDataPanel;
    ClientDataPanel clientDataPanel;
    AdminViewActionsCCPanel adminViewActionsCCPanel;
    AdminViewActionsSCPanel adminViewActionsSCPanel;
    AdminCCPanel adminCCpanel;
    AdminSCPanel adminSCpanel;
    AdminClientList adminClientList;
    AdminEmployeeList adminEmployeeList;
    StatsPanel statsPanel;
    CardLayout cl = (CardLayout)(cards.getLayout());
    private String user;
    
    AdminMainMenuView(String username) {
        this.user = username;
        this.personalDataPanel = new AdminPersonalDataPanel(this.user);
        this.clientDataPanel = new ClientDataPanel(this.user);
        this.adminViewActionsCCPanel = new AdminViewActionsCCPanel(this.user);
        this.adminViewActionsSCPanel = new AdminViewActionsSCPanel(this.user);
        this.adminCCpanel = new AdminCCPanel(this.user);
        this.adminSCpanel = new AdminSCPanel(this.user);
        this.adminClientList = new AdminClientList(this.user);
        this.adminEmployeeList = new AdminEmployeeList(this.user);
        this.statsPanel = new StatsPanel();

        JPanel parentPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel centerVertLPanel = new JPanel();
        JPanel centerVertRPanel = new JPanel();
        JPanel southBoxPanel = new JPanel();
        JPanel westBoxPanel = new JPanel();
        
        parentPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        centerVertLPanel.setLayout(new BoxLayout(centerVertLPanel, BoxLayout.Y_AXIS));
        centerVertRPanel.setLayout(new BoxLayout(centerVertRPanel, BoxLayout.Y_AXIS));
        southBoxPanel.setLayout(new BoxLayout(southBoxPanel, BoxLayout.Y_AXIS));
        westBoxPanel.setLayout(new BoxLayout(westBoxPanel, BoxLayout.Y_AXIS));
        
        westBoxPanel.add(Box.createRigidArea(new Dimension(180, 0)));

        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertLPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertRPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        
        mainmenuLabel.setFont(new Font("Dialog", Font.BOLD, 28));
        mainmenuLabel.setPreferredSize(new Dimension(200, 100));

        logoutbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        logoutbtn.setFocusPainted(false);

        southBoxPanel.add(Box.createRigidArea(new Dimension(150, 30)));
        southBoxPanel.add(logoutbtn);
        southBoxPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        ccbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        ccbtn.setFocusPainted(false);

        scbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        scbtn.setFocusPainted(false);

        actccbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        actccbtn.setFocusPainted(false);

        actscbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        actscbtn.setFocusPainted(false);

        clientDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        clientDatabtn.setFocusPainted(false);

        statsDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        statsDatabtn.setFocusPainted(false);

        employeeListbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        employeeListbtn.setFocusPainted(false);

        clientListbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        clientListbtn.setFocusPainted(false);

        personalDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        personalDatabtn.setFocusPainted(false);
        
        parentPanel.add(mainmenuLabel, BorderLayout.NORTH);
        parentPanel.add(centerPanel, BorderLayout.CENTER);
        parentPanel.add(southBoxPanel, BorderLayout.SOUTH);
        parentPanel.add(westBoxPanel, BorderLayout.WEST);
        
        centerVertLPanel.add(clientListbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(ccbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(actccbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(clientDatabtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(statsDatabtn);
        
        centerVertRPanel.add(employeeListbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(scbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(actscbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(personalDatabtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        // centerVertRPanel.add(Box.createHorizontalBox());

        cards.add(parentPanel, "ParentPanel");
        cards.add(personalDataPanel, "personalDataPanel");
        cards.add(clientDataPanel, "clientDataPanel");
        cards.add(adminViewActionsCCPanel, "adminViewActionsCCPanel");
        cards.add(adminViewActionsSCPanel, "adminViewActionsSCPanel");
        cards.add(adminCCpanel, "adminCCpanel");
        cards.add(adminSCpanel, "adminSCpanel");
        cards.add(adminClientList, "adminClientList");
        cards.add(adminEmployeeList, "adminEmployeeList");
        cards.add(statsPanel, "statsPanel");
        
        cl.show(cards, "ParentPanel");
        
        this.setContentPane(cards);
        this.setLocation(380, 110);
		this.setSize(800, 600);
		this.setResizable(false);
		
		this.setTitle("mare titlu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void addLogoutListener(ActionListener al) {
        logoutbtn.addActionListener(al);
    }
    public void addPersonalDataListener(ActionListener al) {
        personalDatabtn.addActionListener(al);
    }
    public void addClientDataListener(ActionListener al) {
        clientDatabtn.addActionListener(al);
    }
    public void addViewActionsCCListener(ActionListener al) {
        actccbtn.addActionListener(al);
    }
    public void addViewActionsSCListener(ActionListener al) {
        actscbtn.addActionListener(al);
    }
    public void addAdminCCListener(ActionListener al) {
        ccbtn.addActionListener(al);
    }
    public void addAdminSCListener(ActionListener al) {
        scbtn.addActionListener(al);
    }
    public void addClientListListener(ActionListener al) {
        clientListbtn.addActionListener(al);
    }
    public void addEmployeeListListener(ActionListener al) {
        employeeListbtn.addActionListener(al);
    }
    public void addStatsListener(ActionListener al) {
        statsDatabtn.addActionListener(al);
    }
    public static void main(String[] args) {
        AdminMainMenuView view = new AdminMainMenuView("admin");
    }
}

