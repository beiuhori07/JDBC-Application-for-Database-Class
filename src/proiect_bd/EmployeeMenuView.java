package proiect_bd;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class EmployeeMenuView extends JFrame{
    private JLabel mainmenuLabel = new JLabel("<html><br/><br/>Meniu Principal</html>", JLabel.CENTER);
    JButton validationbtn = new JButton("Validare transferuri");
    JButton viewActCCbtn = new JButton("Vizualizare actiuni cont curent");
    JButton viewActSCbtn = new JButton("Vizualizare actiuni cont economii");
    JButton viewTRbtn = new JButton("Vizualizare transferuri");
    JButton filtActCCId = new JButton("Filtrare actiuni cont curent prin id client");
    JButton filtActSCId = new JButton("Filtrare actiuni cont economii prin id client");
    JButton filtActCCIban = new JButton("Filtrare actiuni cont curent prin iban");
    JButton filtActSCIban = new JButton("Filtrare actiuni cont economii prin iban");
    JButton personalDatabtn = new JButton("Date personale");
    JButton clientDatabtn = new JButton("Date clienti");
    JButton statsDatabtn = new JButton("Date statistice");
    JButton logoutbtn = new JButton("Delogare");
    JPanel cards = new JPanel(new CardLayout());
    CardLayout cl = (CardLayout)(cards.getLayout());
    EmPersonalDataPanel personalDataPanel;
    ViewTransfersPanel viewTransfersPanel;
    ViewActionsCCPanel viewActionsCCPanel;
    ViewActionsSCPanel viewActionsSCPanel;
    ValidateTransfersPanel validateTransfersPanel;
    FilterCCbyIdPanel filterCCbyId;
    FilterCCbyIbanPanel filterCCbyIban;
    FilterSCbyIdPanel filterSCbyId;
    FilterSCbyIBANPanel filterSCbyIban;
    EmClientData clientDataPanel;
    StatsPanel statsPanel;

    private String user;
    
    EmployeeMenuView(String username) {
        this.user = username;
        this.personalDataPanel = new EmPersonalDataPanel(this.user);
        this.viewTransfersPanel = new ViewTransfersPanel(this.user);
        this.validateTransfersPanel = new ValidateTransfersPanel(this.user);
        this.viewActionsCCPanel = new ViewActionsCCPanel(this.user);
        this.viewActionsSCPanel = new ViewActionsSCPanel(this.user);
        this.filterCCbyId = new FilterCCbyIdPanel(this.user);
        this.filterCCbyIban = new FilterCCbyIbanPanel(this.user);
        this.filterSCbyId = new FilterSCbyIdPanel(this.user);
        this.filterSCbyIban = new FilterSCbyIBANPanel(this.user);
        this.clientDataPanel = new EmClientData(this.user);
        this.statsPanel = new StatsPanel();

        JPanel parentPanel = new JPanel();
        JPanel nextPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel centerVertLPanel = new JPanel();
        JPanel centerVertRPanel = new JPanel();

        JLabel label = new JLabel("<html><br/><br/>Hey man</html>", JLabel.CENTER);
        nextPanel.add(label);
        
        parentPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        centerVertLPanel.setLayout(new BoxLayout(centerVertLPanel, BoxLayout.Y_AXIS));
        centerVertRPanel.setLayout(new BoxLayout(centerVertRPanel, BoxLayout.Y_AXIS));
        
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertLPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        centerPanel.add(centerVertRPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        
        mainmenuLabel.setFont(new Font("Dialog", Font.BOLD, 28));
        mainmenuLabel.setPreferredSize(new Dimension(200, 100));
        
        validationbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        validationbtn.setFocusPainted(false);

        clientDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        clientDatabtn.setFocusPainted(false);

        statsDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        statsDatabtn.setFocusPainted(false);

        personalDatabtn.setFont(new Font("Dialog", Font.BOLD, 16));
        personalDatabtn.setFocusPainted(false);

        logoutbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        logoutbtn.setFocusPainted(false);
        
        viewTRbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        viewTRbtn.setFocusPainted(false);
        
        viewActCCbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        viewActCCbtn.setFocusPainted(false);
        
        viewActSCbtn.setFont(new Font("Dialog", Font.BOLD, 16));
        viewActSCbtn.setFocusPainted(false);

        filtActCCId.setFont(new Font("Dialog", Font.BOLD, 16));
        filtActCCId.setFocusPainted(false);
        
        filtActSCId.setFont(new Font("Dialog", Font.BOLD, 16));
        filtActSCId.setFocusPainted(false);

        filtActCCIban.setFont(new Font("Dialog", Font.BOLD, 16));
        filtActCCIban.setFocusPainted(false);

        filtActSCIban.setFont(new Font("Dialog", Font.BOLD, 16));
        filtActSCIban.setFocusPainted(false);
        
        parentPanel.add(mainmenuLabel, BorderLayout.NORTH);
        parentPanel.add(centerPanel, BorderLayout.CENTER);
        
        centerVertLPanel.add(validationbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(viewActCCbtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(filtActCCId);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(filtActCCIban);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(clientDatabtn);
        centerVertLPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertLPanel.add(personalDatabtn);
        
        centerVertRPanel.add(viewTRbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(viewActSCbtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(filtActSCId);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(filtActSCIban);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(statsDatabtn);
        centerVertRPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerVertRPanel.add(logoutbtn);
        
        cards.add(parentPanel, "ParentPanel");
        cards.add(personalDataPanel, "PersonalData");
        cards.add(viewTransfersPanel, "viewTransfer");
        cards.add(validateTransfersPanel, "validateTransfer");
        cards.add(viewActionsCCPanel, "viewActionsCC");
        cards.add(viewActionsSCPanel, "viewActionsSC");
        cards.add(filterCCbyId, "filterCCbyId");
        cards.add(filterCCbyIban, "filterCCbyIban");
        cards.add(filterSCbyId, "filterSCbyId");
        cards.add(filterSCbyIban, "filterSCbyIban");
        cards.add(clientDataPanel, "clientDataPanel");
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
    public void addStatsListener(ActionListener al) {
        statsDatabtn.addActionListener(al);
    }
    public void addClientDataListener(ActionListener al) {
        clientDatabtn.addActionListener(al);
    }
    public void addValidationListener(ActionListener al) {
        validationbtn.addActionListener(al);
    }
    public void addViewTransferListener(ActionListener al) {
        viewTRbtn.addActionListener(al);
    }
    public void addViewActCCListener(ActionListener al) {
        viewActCCbtn.addActionListener(al);
    }
    public void addViewActSCListener(ActionListener al) {
        viewActSCbtn.addActionListener(al);
    }
    public void addFilterActCCIdListener(ActionListener al) {
        filtActCCId.addActionListener(al);
    }
    public void addFilterActSCIdListener(ActionListener al) {
        filtActSCId.addActionListener(al);
    }
    public void addFilterActCCIbanListener(ActionListener al) {
        filtActCCIban.addActionListener(al);
    }
    public void addFilterActSCIbanListener(ActionListener al) {
        filtActSCIban.addActionListener(al);
    }
    public void addPersonalDataListener(ActionListener al) {
        personalDatabtn.addActionListener(al);
    }
    public void addLogoutListener(ActionListener al) {
        logoutbtn.addActionListener(al);
    }
    public static void main(String[] args) {
        EmployeeMenuView view = new EmployeeMenuView("user");
    }
}

