package proiect_bd;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.*;

public class AdminMainMenuController {
    Model model;
    AdminMainMenuView view;
    AdminMainMenuController(Model model, AdminMainMenuView view) {
        this.model = model;
        this.view = view;

        view.addLogoutListener(new LogoutListener());
        view.addPersonalDataListener(new PersonalDataListener()); 
        view.addClientDataListener(new ClientDataListener()); 
        view.addClientListListener(new ClientListListener()); 
        view.addEmployeeListListener(new EmployeeListListener()); 
        view.addStatsListener(new StatsListener()); 
        view.personalDataPanel.addBackActionListener(new BackListener());
        view.personalDataPanel.addModifyActionListener(new ModifyListener());
        view.clientDataPanel.addFilterActionListener(new FilterClientDataListener());
        view.clientDataPanel.addBackActionListener(new BackListener());
        view.clientDataPanel.addModifyActionListener(new ModifyClientDataListener());
        view.addViewActionsCCListener(new ViewActionsCCListener());
        view.addViewActionsSCListener(new ViewActionsSCListener());
        view.adminViewActionsCCPanel.addBackActionListener(new BackListener());
        view.adminViewActionsSCPanel.addBackActionListener(new BackListener());
        view.addAdminCCListener(new AdminCCListener());
        view.addAdminSCListener(new AdminSCListener());
        view.adminCCpanel.addBackActionListener(new BackListener());
        view.adminCCpanel.addFilterActionListener(new AdminCCFilterListener());
        view.adminSCpanel.addBackActionListener(new BackListener());
        view.adminSCpanel.addFilterActionListener(new AdminSCFilterListener());
        view.adminClientList.addBackActionListener(new BackListener());
        view.adminEmployeeList.addBackActionListener(new BackListener());
        view.statsPanel.addBackActionListener(new BackListener());
    }
    
    class ModifyListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            try {
                model.pStmt = model.con.prepareStatement("update administrator set nume = ?,  prenume = ?, cnp = ?, adresa = ?, nr = ?, email = ? where numeUtilizator = ?");
                model.pStmt.setString(1, view.personalDataPanel.nume.getText());
                model.pStmt.setString(2, view.personalDataPanel.prenume.getText());
                model.pStmt.setString(3, view.personalDataPanel.cnp.getText());
                model.pStmt.setString(4, view.personalDataPanel.adress.getText());
                model.pStmt.setString(5, view.personalDataPanel.nr.getText());
                model.pStmt.setString(6, view.personalDataPanel.email.getText());
                model.pStmt.setString(7, view.personalDataPanel.username.getText());
                model.pStmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class ViewActionsCCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "adminViewActionsCCPanel");
            ActionsCCInit();
        }
    }
    class StatsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "statsPanel");
            StatsInit();
        }
    }
    class ClientListListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "adminClientList");
            ClientListInit();
        }
    }
    class EmployeeListListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "adminEmployeeList");
            EmployeeListInit();
        }
    }
    class AdminSCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "adminSCpanel");
            
        }
    }
    class AdminCCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "adminCCpanel");
            

        }
    }
    class AdminCCFilterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!view.adminCCpanel.idField.equals("")) {
                view.adminCCpanel.selectedId = Integer.valueOf(view.adminCCpanel.idField.getText());
                AdminCCFilterInit();
            }
            else {
                //id introdus incorect -> fa label
            }
        }
    }
    class AdminSCFilterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!view.adminSCpanel.idField.equals("")) {
                view.adminSCpanel.selectedId = Integer.valueOf(view.adminSCpanel.idField.getText());
                AdminSCFilterInit();
            }
            else {
                //id introdus incorect -> fa label
            }
        }
    }
    class ViewActionsSCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "adminViewActionsSCPanel");
            ActionsSCInit();
        }
    }
    class ClientDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "clientDataPanel");
        }
    }
    class ModifyClientDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //view.cl.show(view.cards, "clientDataPanel");
            try {
                model.pStmt = model.con.prepareStatement("update client set nume = ?,  prenume = ?, cnp = ?, adresa = ?, nr = ?, email = ?, banca = ?, dataNasterii = ? where numeUtilizator = ?");
                model.pStmt.setString(1, view.clientDataPanel.nume.getText());
                model.pStmt.setString(2, view.clientDataPanel.prenume.getText());
                model.pStmt.setString(3, view.clientDataPanel.cnp.getText());
                model.pStmt.setString(4, view.clientDataPanel.adress.getText());
                model.pStmt.setString(5, view.clientDataPanel.nr.getText());
                model.pStmt.setString(6, view.clientDataPanel.email.getText());
                model.pStmt.setString(7, view.clientDataPanel.bank.getText());
                model.pStmt.setString(8, view.clientDataPanel.date.getText());
                model.pStmt.setString(9, view.clientDataPanel.username.getText());
                model.pStmt.executeUpdate();
                System.out.println("client modificat");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class FilterClientDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //view.cl.show(view.cards, "clientDataPanel");
            if(!view.clientDataPanel.idField.equals("")) {
                view.clientDataPanel.selectedId = Integer.valueOf(view.clientDataPanel.idField.getText());
                FilterClientDataInit();
            }
            else {
                // fa ceva label 
            }
        }
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "ParentPanel");
        }
    }
    class PersonalDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "personalDataPanel");
            PersonalDataInit();
        }
    }
    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            FirstPageView newView = new FirstPageView();
            FirstPageController newController = new FirstPageController(model, newView);
        }
    }
    public void StatsInit() {
        try {
            model.cStmt = model.con.prepareCall("{call initializare_statistica()}");
            model.cStmt.execute();

            model.pStmt = model.con.prepareStatement("select * from statistica");
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                view.statsPanel.employeeLabel.setText("Angajati: " + model.rst.getString("nrAngajati"));
                view.statsPanel.clientLabel.setText("Clienti: " + model.rst.getString("nrClienti"));
                view.statsPanel.transferLabel.setText("Transferuri: " + model.rst.getString("nrTransferuri"));
                view.statsPanel.scLabel.setText("Conturi economii: " + model.rst.getString("nrConturiEconomii"));
                view.statsPanel.actccLabel.setText("Actiuni cont curent: " + model.rst.getString("nrActiuniContCurent"));
                view.statsPanel.actscLabel.setText("Actiuni cont economii: " + model.rst.getString("nrACtiuniContEconomii"));
            }
            System.out.println("stats loaded!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void EmployeeListInit() {
        try {

            view.adminEmployeeList.centralParentPanel.removeAll();
            view.adminEmployeeList.centralParentPanel.revalidate();
            view.adminEmployeeList.centralParentPanel.repaint();

            model.pStmt = model.con.prepareStatement("select * from angajat", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }

            String[][] data = new String[rowCount][14];
            String[] column = {"idAngajat","numeUtilizator", "parola", "cnp", "nume", "prenume", "adresa", "nr", "email", "salariu", "sucursala", "departament", "norma"};
            
            int gx = 0;
            while(model.rst.next()) {
                data[gx][0] = String.valueOf(model.rst.getInt("idAngajat"));
                data[gx][1] = model.rst.getString("numeUtilizator");
                data[gx][2] = model.rst.getString("parola");
                data[gx][3] = model.rst.getString("cnp");
                data[gx][4] = model.rst.getString("nume");
                data[gx][5] = model.rst.getString("prenume");
                data[gx][6] = model.rst.getString("adresa");
                data[gx][7] = model.rst.getString("nr");
                data[gx][8] = model.rst.getString("email");
                data[gx][9] = model.rst.getString("dataNasterii");
                data[gx][10] = String.valueOf(model.rst.getString("salariu"));
                data[gx][11] = model.rst.getString("sucursala");
                data[gx][12] = model.rst.getString("departament");
                data[gx][13] = model.rst.getString("norma");

                gx++;
            }

            JTable table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);
            view.adminEmployeeList.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ClientListInit() {
        try {

            view.adminClientList.centralParentPanel.removeAll();
            view.adminClientList.centralParentPanel.revalidate();
            view.adminClientList.centralParentPanel.repaint();

            model.pStmt = model.con.prepareStatement("select * from client", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }

            String[][] data = new String[rowCount][11];
            String[] column = {"idClient","numeUtilizator", "parola", "cnp", "nume", "prenume", "adresa", "nr", "email", "banca", "dataNasterii"};
            
            int gx = 0;
            while(model.rst.next()) {
                data[gx][0] = String.valueOf(model.rst.getInt("idClient"));
                data[gx][1] = model.rst.getString("numeUtilizator");
                data[gx][2] = model.rst.getString("parola");
                data[gx][3] = model.rst.getString("cnp");
                data[gx][4] = model.rst.getString("nume");
                data[gx][5] = model.rst.getString("prenume");
                data[gx][6] = model.rst.getString("adresa");
                data[gx][7] = model.rst.getString("nr");
                data[gx][8] = model.rst.getString("email");
                data[gx][9] = model.rst.getString("banca");
                data[gx][10] = model.rst.getString("dataNasterii");

                gx++;
            }

            JTable table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);
            view.adminClientList.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void AdminSCFilterInit() {
        try {
            view.adminSCpanel.centralPanel.removeAll();
            view.adminSCpanel.centralPanel.revalidate();
            view.adminSCpanel.centralPanel.repaint();

            model.pStmt = model.con.prepareStatement("SELECT * from contEconomii where idClient = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.pStmt.setInt(1, view.adminSCpanel.selectedId);
            model.rst = model.pStmt.executeQuery();
            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }
            
            JLabel[] balanceLabels = new JLabel[rowCount];
            JLabel[] nameLabel = new JLabel[rowCount];
            JLabel[] ibanLabels = new JLabel[rowCount];
            JLabel[] interestLabels = new JLabel[rowCount];
            JLabel[] dateLabels = new JLabel[rowCount];
            JLabel[] ibanCrtAccLabels = new JLabel[rowCount];
            JPanel[] panels = new JPanel[rowCount];
            JPanel[] firstLinePanels = new JPanel[rowCount];

            view.adminSCpanel.centralPanel.setPreferredSize(new Dimension(140 * rowCount, 210 * rowCount));
            
            int gx = 0;
            while(model.rst.next()) {
                balanceLabels[gx] = label("Sold curent: " + String.valueOf(model.rst.getInt("soldCurent")));
                String ib = new String(model.rst.getString("iban"));
                ibanLabels[gx] = label(" -   IBAN: " + ib);
                ibanCrtAccLabels[gx] = label("IBAN cont curent: " + model.rst.getString("ibanContCurent"));
                interestLabels[gx] = label("Dobanda curenta: " + model.rst.getString("dobandaCurenta"));
                dateLabels[gx] = label("Data deschiderii: " + model.rst.getString("dataDeschiderii"));

                balanceLabels[gx].setFont(new Font("Dialog", Font.PLAIN, 15));
                ibanCrtAccLabels[gx].setFont(new Font("Dialog", Font.PLAIN, 15));
                interestLabels[gx].setFont(new Font("Dialog", Font.PLAIN, 15));
                dateLabels[gx].setFont(new Font("Dialog", Font.PLAIN, 15));
                
                panels[gx] = new JPanel();
                panels[gx].setBorder(BorderFactory.createLineBorder(Color.black));
                firstLinePanels[gx] = new JPanel();
                panels[gx].setLayout(new BoxLayout(panels[gx], BoxLayout.Y_AXIS));
                firstLinePanels[gx].setLayout(new BoxLayout(firstLinePanels[gx], BoxLayout.X_AXIS));
                
                nameLabel[gx] = new JLabel("", JLabel.CENTER);
                nameLabel[gx].setText("Cont economii #" + (gx+1));
                nameLabel[gx].setFont(new Font("Dialog", Font.BOLD, 18));
                firstLinePanels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                firstLinePanels[gx].add(nameLabel[gx]);
                firstLinePanels[gx].add(ibanLabels[gx]);
                firstLinePanels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(firstLinePanels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(balanceLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(interestLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(dateLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(ibanCrtAccLabels[gx]);

                view.adminSCpanel.centralPanel.add(panels[gx]);
                view.adminSCpanel.centralPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                gx++;
            }
            System.out.println("sc filtered!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void AdminCCFilterInit() {
        try {

            model.pStmt = model.con.prepareStatement("SELECT * from contcurent where idClient = ?");
            model.pStmt.setInt(1, view.adminCCpanel.selectedId);
            model.rst = model.pStmt.executeQuery();

            while(model.rst.next()) {
                view.adminCCpanel.ibanLabel.setText("IBAN: " + model.rst.getString("iban"));
                view.adminCCpanel.balanceLabel.setText("Sold: " + String.valueOf(model.rst.getInt("soldCurent")));
            }
            System.out.println("cc filtered!");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void FilterClientDataInit() {
        try {
            model.pStmt = model.con.prepareStatement("SELECT numeUtilizator, cnp, nume, prenume, adresa, nr, email, banca, dataNasterii from client where idClient = ?");
            model.pStmt.setInt(1, view.clientDataPanel.selectedId);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                view.clientDataPanel.nume.setText(model.rst.getString("nume"));
                view.clientDataPanel.prenume.setText(model.rst.getString("prenume"));
                view.clientDataPanel.cnp.setText(model.rst.getString("cnp"));
                //view.clientDataPanel.username.setText(view.personalDataPanel.user);
                view.clientDataPanel.adress.setText(model.rst.getString("adresa"));
                view.clientDataPanel.nr.setText(model.rst.getString("nr"));
                view.clientDataPanel.email.setText(model.rst.getString("email"));
                view.clientDataPanel.username.setText(model.rst.getString("numeUtilizator"));
                view.clientDataPanel.bank.setText(model.rst.getString("banca"));
                view.clientDataPanel.date.setText(model.rst.getString("dataNasterii"));
                view.clientDataPanel.id.setText(String.valueOf(view.clientDataPanel.selectedId));
                System.out.println("good");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void PersonalDataInit() {
        try {
            model.pStmt = model.con.prepareStatement("SELECT cnp, nume, prenume, adresa, nr, email from administrator where numeUtilizator = ?");
            model.pStmt.setString(1, view.personalDataPanel.user);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                view.personalDataPanel.nume.setText(model.rst.getString("nume"));
                view.personalDataPanel.prenume.setText(model.rst.getString("prenume"));
                view.personalDataPanel.cnp.setText(model.rst.getString("cnp"));
                view.personalDataPanel.username.setText(view.personalDataPanel.user);
                view.personalDataPanel.adress.setText(model.rst.getString("adresa"));
                view.personalDataPanel.nr.setText(model.rst.getString("nr"));
                view.personalDataPanel.email.setText(model.rst.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ActionsSCInit() {
        try {

            view.adminViewActionsSCPanel.centralParentPanel.removeAll();
            view.adminViewActionsSCPanel.centralParentPanel.revalidate();
            view.adminViewActionsSCPanel.centralParentPanel.repaint();

            model.pStmt = model.con.prepareStatement("select * from actiuneconteconomii", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }

            String[][] data = new String[rowCount][5];
            String[] column = {"idActiuneContEconomii", "iban", "suma", "tipActiune", "data"};
            
            int gx = 0;
            while(model.rst.next()) {
                data[gx][0] = String.valueOf(model.rst.getInt("idActiuneContEconomii"));
                data[gx][1] = model.rst.getString("iban");
                data[gx][2] = String.valueOf(model.rst.getInt("suma"));
                data[gx][3] = model.rst.getString("tipActiune");
                data[gx][4] = model.rst.getString("datatimp");

                gx++;
            }

            JTable table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);
            view.adminViewActionsSCPanel.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ActionsCCInit() {
        try {

            view.adminViewActionsCCPanel.centralParentPanel.removeAll();
            view.adminViewActionsCCPanel.centralParentPanel.revalidate();
            view.adminViewActionsCCPanel.centralParentPanel.repaint();

            model.pStmt = model.con.prepareStatement("select * from actiunecontcurent", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }

            String[][] data = new String[rowCount][5];
            String[] column = {"idActiuneContCurent", "iban", "suma", "tipActiune", "data"};
            
            int gx = 0;
            while(model.rst.next()) {
                data[gx][0] = String.valueOf(model.rst.getInt("idActiuneContCurent"));
                data[gx][1] = model.rst.getString("iban");
                data[gx][2] = String.valueOf(model.rst.getInt("suma"));
                data[gx][3] = model.rst.getString("tipActiune");
                data[gx][4] = model.rst.getString("datatimp");

                gx++;
            }

            JTable table = new JTable(data, column);
            JScrollPane sp = new JScrollPane(table);
            view.adminViewActionsCCPanel.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JLabel label(String x){
        final JLabel l;
            l = new JLabel(x, JLabel.CENTER);
            l.setFont(new java.awt.Font("Tahoma", 0, 16));
            l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            l.setOpaque(true);
            l.setBorder(null);
            return l;
        }
}
