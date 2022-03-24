package proiect_bd;

import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.List;
import javax.swing.*;

public class EmployeeMenuController {
    Model model;
    EmployeeMenuView view;
    EmployeeMenuController(Model model, EmployeeMenuView view) {
        this.view = view;
        this.model = model;

        view.addValidationListener(new ValidationListener());
        view.addViewTransferListener(new ViewTRListener());
        view.addViewActCCListener(new ViewActCCListener());
        view.addViewActSCListener(new ViewActSCListener());
        view.addFilterActCCIdListener(new FilterActCCIdListener());
        view.addFilterActSCIdListener(new FilterActSCIdListener());
        view.addFilterActCCIbanListener(new FilterActCCIbanListener());
        view.addFilterActSCIbanListener(new FilterActSCIbanListener());
        view.addPersonalDataListener(new PersonalDataListener());
        view.addLogoutListener(new LogoutListener());
        view.addClientDataListener(new ClientDataListener());
        view.addStatsListener(new StatsListener());
        view.clientDataPanel.addFilterActionListener(new FilterClientDataListener());
        view.clientDataPanel.addBackActionListener(new BackListener());
        view.personalDataPanel.addBackActionListener(new BackListener());
        view.personalDataPanel.addModifyActionListener(new ModifyListener());
        view.viewTransfersPanel.addBackActionListener(new BackListener());
        view.validateTransfersPanel.addBackActionListener(new BackListener());
        view.validateTransfersPanel.addValidateActionListener(new ValidateListener());
        view.validateTransfersPanel.addRejectActionListener(new RejectListener());
        view.viewActionsCCPanel.addBackActionListener(new BackListener());
        view.viewActionsSCPanel.addBackActionListener(new BackListener());
        view.filterCCbyId.addFilterActionListener(new FilterCCIDListener());
        view.filterCCbyId.addBackActionListener(new BackListener());
        view.filterCCbyIban.addBackActionListener(new BackListener());
        view.filterCCbyIban.addFilterActionListener(new FilterCCIBANListener());
        view.filterSCbyId.addBackActionListener(new BackListener());
        view.filterSCbyId.addFilterActionListener(new FilterSCIDListener());
        view.filterSCbyIban.addBackActionListener(new BackListener());
        view.filterSCbyIban.addFilterActionListener(new FilterSCIBANListener());
        view.statsPanel.addBackActionListener(new BackListener());
    }
    class FilterClientDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //view.cl.show(view.cards, "clientDataPanel");
            if(!view.clientDataPanel.idField.getText().equals("")) {
                view.clientDataPanel.selectedId = Integer.valueOf(view.clientDataPanel.idField.getText());
                FilterClientDataInit();
                view.clientDataPanel.badIdlabel.setVisible(false);
            }
            else {
                view.clientDataPanel.badIdlabel.setVisible(true);

                // fa ceva label 
            }
        }
    }
    class ClientDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "clientDataPanel");
        }
    }
    class FilterCCIBANListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!view.filterCCbyIban.ibanField.getText().equals("")) {
                view.filterCCbyIban.selectedIban = view.filterCCbyIban.ibanField.getText();
                FilterActionsCcbyIbanInit();
            }
            else {
                // fa label vizibil -> nu este introdus iban
            }
        }
    }
    class FilterSCIBANListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!view.filterSCbyIban.ibanField.getText().equals("")) {
                view.filterSCbyIban.selectedIban = view.filterSCbyIban.ibanField.getText();
                FilterActionsScbyIbanInit();
            }
            else {
                System.out.println("iban incorect");
                // fa label vizibil -> nu este introdus iban
            }
        }
    }
    class FilterSCIDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!view.filterSCbyId.idField.getText().equals("")) {
                view.filterSCbyId.selectedId = Integer.valueOf(view.filterSCbyId.idField.getText());
                System.out.println(view.filterSCbyId.selectedId);
                FilterActionsScbyIdInit();
            }
            else {
                System.out.println("id incorect");
                // fa label vizibil -> nu este introdus id
            }
        }
    }
    class FilterCCIDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!view.filterCCbyId.idField.getText().equals("")) {
                view.filterCCbyId.selectedId = Integer.valueOf(view.filterCCbyId.idField.getText());
                FilterActionsCcbyIdInit();
            }
            else {
                // fa label vizibil -> nu este introdus id
            }
        }
    }
    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            FirstPageView newView = new FirstPageView();
            FirstPageController newController = new FirstPageController(model, newView);
        }
    }
    class StatsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "statsPanel");
            StatsInit();
        }
    }
    class ModifyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                
                model.pStmt = model.con.prepareStatement("update angajat set nume = ?,  prenume = ?, cnp = ?, adresa = ?, nr = ?, email = ? where numeUtilizator = ?");
                model.pStmt.setString(1, view.personalDataPanel.nume.getText());
                model.pStmt.setString(2, view.personalDataPanel.prenume.getText());
                model.pStmt.setString(3, view.personalDataPanel.cnp.getText());
                // model.pStmt.setString(4, view.personalDataPanel.username.getText());
                model.pStmt.setString(4, view.personalDataPanel.adress.getText());
                model.pStmt.setString(5, view.personalDataPanel.nr.getText());
                model.pStmt.setString(6, view.personalDataPanel.email.getText());
                model.pStmt.setString(7, view.personalDataPanel.user);
                model.pStmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            PersonalDataInit();
        }
    }
    class ValidateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ValidateATransfer("SUCCESSFUL");
            ValidateTransferInit();
        }
    }
    class RejectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ValidateATransfer("REJECTED");
            ValidateTransferInit();
        }
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "ParentPanel");
        }
    }
    class PersonalDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "PersonalData");
            PersonalDataInit();
        }
    }
    class ValidationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "validateTransfer"); 
            ValidateTransferInit();
        }
    }
    class ViewTRListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "viewTransfer");
            ViewTransfersInit();
        }
    }
    class ViewActCCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // JTable table = new jTAB
            view.cl.show(view.cards, "viewActionsCC");
            ActionsCCInit();
        }
    }
    class ViewActSCListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "viewActionsSC");
            ActionsSCInit();
        }
    }
    class FilterActCCIdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "filterCCbyId");
            FilterActionsCcbyIdInit();    
        }
    }
    class FilterActSCIdListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "filterSCbyId");
            FilterActionsScbyIdInit();
        }
    }
    class FilterActCCIbanListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "filterCCbyIban");
            FilterActionsCcbyIbanInit();
        }
    }
    class FilterActSCIbanListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "filterSCbyIban");
            FilterActionsScbyIbanInit();
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
    public void FilterActionsScbyIbanInit() {
        try {

            view.filterSCbyIban.centralParentPanel.removeAll();
            view.filterSCbyIban.centralParentPanel.revalidate();
            view.filterSCbyIban.centralParentPanel.repaint();

            String iban = view.filterSCbyIban.selectedIban;
            
            model.pStmt = model.con.prepareStatement("select * from actiuneconteconomii where iban = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            System.out.println("good2");
            model.pStmt.setString(1, iban);
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
            view.filterSCbyIban.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void FilterActionsScbyIdInit() {
        try {

            view.filterSCbyId.centralParentPanel.removeAll();
            view.filterSCbyId.centralParentPanel.revalidate();
            view.filterSCbyId.centralParentPanel.repaint();

            String ibansc1 = "";
            String ibansc2 = "";
            String ibansc3 = "";
            String ibansc4 = "";
            String ibansc5 = "";
            String ibancc = "";

            model.pStmt = model.con.prepareStatement("select iban from contcurent where idClient = ?");
            model.pStmt.setInt(1, view.filterSCbyId.selectedId);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                ibancc = model.rst.getString("iban");
            }

            model.pStmt = model.con.prepareStatement("select iban from conteconomii where ibanContCurent = ? limit 1");
            model.pStmt.setString(1, ibancc);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                ibansc1 = model.rst.getString("iban");
            }
            model.pStmt = model.con.prepareStatement("select iban from conteconomii where ibanContCurent = ? limit 1, 1");
            model.pStmt.setString(1, ibancc);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                ibansc2 = model.rst.getString("iban");
            }
            model.pStmt = model.con.prepareStatement("select iban from conteconomii where ibanContCurent = ? limit 2, 1");
            model.pStmt.setString(1, ibancc);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                ibansc3 = model.rst.getString("iban");
            }
            model.pStmt = model.con.prepareStatement("select iban from conteconomii where ibanContCurent = ? limit 3, 1");
            model.pStmt.setString(1, ibancc);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                ibansc4 = model.rst.getString("iban");
            }
            model.pStmt = model.con.prepareStatement("select iban from conteconomii where ibanContCurent = ? limit 4, 1");
            model.pStmt.setString(1, ibancc);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                ibansc5 = model.rst.getString("iban");
            }
            model.pStmt = model.con.prepareStatement("select * from actiuneconteconomii where iban in (?, ?, ?, ?, ?)", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.pStmt.setString(1, ibansc1);
            model.pStmt.setString(2, ibansc2);
            model.pStmt.setString(3, ibansc3);
            model.pStmt.setString(4, ibansc4);
            model.pStmt.setString(5, ibansc5);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
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
            view.filterSCbyId.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void FilterActionsCcbyIbanInit() {
        try {

            view.filterCCbyIban.centralParentPanel.removeAll();
            view.filterCCbyIban.centralParentPanel.revalidate();
            view.filterCCbyIban.centralParentPanel.repaint();

            String iban = view.filterCCbyIban.selectedIban;
            
            model.pStmt = model.con.prepareStatement("select * from actiunecontcurent where iban = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            System.out.println("good2");
            model.pStmt.setString(1, iban);
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
            view.filterCCbyIban.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void FilterActionsCcbyIdInit() {
        try {

            view.filterCCbyId.centralParentPanel.removeAll();
            view.filterCCbyId.centralParentPanel.revalidate();
            view.filterCCbyId.centralParentPanel.repaint();

            model.pStmt = model.con.prepareStatement("select iban from contcurent where idClient = ?");
            model.pStmt.setInt(1, view.filterCCbyId.selectedId);
            model.rst = model.pStmt.executeQuery();
            String iban = "";
            System.out.println("good0");
            while(model.rst.next()) {
                iban = model.rst.getString("iban");
                System.out.println("good1");
            }
            
            model.pStmt = model.con.prepareStatement("select * from actiunecontcurent where iban = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            System.out.println("good2");
            model.pStmt.setString(1, iban);
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
            view.filterCCbyId.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ActionsSCInit() {
        try {

            view.viewActionsSCPanel.centralParentPanel.removeAll();
            view.viewActionsSCPanel.centralParentPanel.revalidate();
            view.viewActionsSCPanel.centralParentPanel.repaint();

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
            view.viewActionsSCPanel.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ActionsCCInit() {
        try {

            view.viewActionsCCPanel.centralParentPanel.removeAll();
            view.viewActionsCCPanel.centralParentPanel.revalidate();
            view.viewActionsCCPanel.centralParentPanel.repaint();

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
            view.viewActionsCCPanel.centralParentPanel.add(sp);

            System.out.println("table done");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void PersonalDataInit() {
        try {
            model.pStmt = model.con.prepareStatement("SELECT cnp, nume, prenume, adresa, nr, email, idAngajat, salariu ,sucursala, departament, norma from angajat where numeUtilizator = ?");
            model.pStmt.setString(1, view.personalDataPanel.user);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                view.personalDataPanel.nume.setText(model.rst.getString("nume"));
                view.personalDataPanel.prenume.setText(model.rst.getString("prenume"));
                view.personalDataPanel.cnp.setText(model.rst.getString("cnp"));
                view.personalDataPanel.username.setText(view.personalDataPanel.user);
                view.personalDataPanel.id.setText(model.rst.getString("idAngajat"));
                view.personalDataPanel.adress.setText(model.rst.getString("adresa"));
                view.personalDataPanel.nr.setText(model.rst.getString("nr"));
                view.personalDataPanel.email.setText(model.rst.getString("email"));
                view.personalDataPanel.wage.setText(model.rst.getString("salariu"));
                view.personalDataPanel.branch.setText(model.rst.getString("sucursala"));
                view.personalDataPanel.department.setText(model.rst.getString("departament"));
                view.personalDataPanel.norm.setText(model.rst.getString("norma"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ViewTransfersInit() {
        try {

            view.viewTransfersPanel.centralPanel.removeAll();
            view.viewTransfersPanel.centralPanel.revalidate();
            view.viewTransfersPanel.centralPanel.repaint();

            model.pStmt = model.con.prepareStatement("select * from transfer", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }
            JPanel[] panels = new JPanel[rowCount];
            JLabel[] ibanSLabels = new JLabel[rowCount];
            JLabel[] ibanDLabels = new JLabel[rowCount];
            JLabel[] idSLabels = new JLabel[rowCount];
            JLabel[] idDLabels = new JLabel[rowCount];
            JLabel[] statusLabels = new JLabel[rowCount];
            JLabel[] sumLabels = new JLabel[rowCount];
            JLabel[] dateLabels = new JLabel[rowCount];
            JLabel[] employeeIdLabels = new JLabel[rowCount];
            JLabel[] transferIdLabels = new JLabel[rowCount];

            view.viewTransfersPanel.centralPanel.setPreferredSize(new Dimension(400, 250 * rowCount));

            int gx = 0;
            while(model.rst.next()) {
                panels[gx] = new JPanel();
                panels[gx].setLayout(new BoxLayout(panels[gx], BoxLayout.Y_AXIS));
                panels[gx].setBorder(BorderFactory.createLineBorder(Color.black));
                JPanel firstLinePanels = new JPanel();
                firstLinePanels.setLayout(new BoxLayout(firstLinePanels, BoxLayout.X_AXIS));
                // JPanel secondLinePanels = new JPanel();
                // secondLinePanels.setLayout(new BoxLayout(secondLinePanels, BoxLayout.X_AXIS));
                // panels[gx].setPreferredSize(new Dimension(300, 100));

                transferIdLabels[gx] = label("Transfer Id#" + String.valueOf(model.rst.getInt("idTransfer")));
                statusLabels[gx] = label(" - Status: " + model.rst.getString("statusTr"));
                ibanSLabels[gx] = label("IBAN Sursa: " + model.rst.getString("ibanSursa"));
                ibanDLabels[gx] = label("IBAN Destinatie: " + model.rst.getString("ibanDestinatie"));
                idSLabels[gx] = label("ID sursa: " + model.rst.getString("idClientSursa"));
                idDLabels[gx] = label("ID destinatie: " + model.rst.getString("idClientDestinatie"));
                sumLabels[gx] = label("Suma: " + String.valueOf(model.rst.getInt("suma")));
                dateLabels[gx] = label("Data: " + model.rst.getString("datatimp"));
                employeeIdLabels[gx] = label("Id Angajat Responsabil: " + model.rst.getString("angajatResponsabil"));


                transferIdLabels[gx].setFont(new Font("Dialog", Font.BOLD, 18));
                statusLabels[gx].setFont(new Font("Dialog", Font.BOLD, 18));

                firstLinePanels.add(transferIdLabels[gx]);
                firstLinePanels.add(statusLabels[gx]);

                // secondLinePanels.add(ibanSLabels[gx]);
                // secondLinePanels.add(Box.createGlue());
                
                panels[gx].add(firstLinePanels);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(ibanSLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(ibanDLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(idSLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(idDLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(sumLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(dateLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(employeeIdLabels[gx]);

                view.viewTransfersPanel.centralPanel.add(panels[gx]);
                view.viewTransfersPanel.centralPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                gx++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ValidateTransferInit() {
        try {

            view.validateTransfersPanel.centralPanel.removeAll();
            view.validateTransfersPanel.centralPanel.revalidate();
            view.validateTransfersPanel.centralPanel.repaint();

            String status = "CREATED";
            model.pStmt = model.con.prepareStatement("select * from transfer where statusTr = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.pStmt.setString(1, status);
            model.rst = model.pStmt.executeQuery();

            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }
            JPanel[] panels = new JPanel[rowCount];
            JLabel[] ibanSLabels = new JLabel[rowCount];
            JLabel[] ibanDLabels = new JLabel[rowCount];
            JLabel[] idSLabels = new JLabel[rowCount];
            JLabel[] idDLabels = new JLabel[rowCount];
            JLabel[] statusLabels = new JLabel[rowCount];
            JLabel[] sumLabels = new JLabel[rowCount];
            JLabel[] dateLabels = new JLabel[rowCount];
            JLabel[] employeeIdLabels = new JLabel[rowCount];
            JLabel[] transferIdLabels = new JLabel[rowCount];

            view.validateTransfersPanel.centralPanel.setPreferredSize(new Dimension(400, 250 * rowCount));

            int gx = 0;
            while(model.rst.next()) {
                panels[gx] = new JPanel();
                panels[gx].setLayout(new BoxLayout(panels[gx], BoxLayout.Y_AXIS));
                panels[gx].setBorder(BorderFactory.createLineBorder(Color.black));
                JPanel firstLinePanels = new JPanel();
                firstLinePanels.setLayout(new BoxLayout(firstLinePanels, BoxLayout.X_AXIS));

                String TrId = String.valueOf(model.rst.getInt("idTransfer"));
                transferIdLabels[gx] = label("Transfer Id#" + TrId);
                statusLabels[gx] = label(" - Status: " + model.rst.getString("statusTr"));
                ibanSLabels[gx] = label("IBAN Sursa: " + model.rst.getString("ibanSursa"));
                ibanDLabels[gx] = label("IBAN Destinatie: " + model.rst.getString("ibanDestinatie"));
                idSLabels[gx] = label("ID sursa: " + model.rst.getString("idClientSursa"));
                idDLabels[gx] = label("ID destinatie: " + model.rst.getString("idClientDestinatie"));
                sumLabels[gx] = label("Suma: " + String.valueOf(model.rst.getInt("suma")));
                dateLabels[gx] = label("Data: " + model.rst.getString("datatimp"));
                employeeIdLabels[gx] = label("Id Angajat Responsabil: " + model.rst.getString("angajatResponsabil"));


                transferIdLabels[gx].setFont(new Font("Dialog", Font.BOLD, 18));
                statusLabels[gx].setFont(new Font("Dialog", Font.BOLD, 18));

                firstLinePanels.add(transferIdLabels[gx]);
                firstLinePanels.add(statusLabels[gx]);
                
                panels[gx].add(firstLinePanels);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(ibanSLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(ibanDLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(idSLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(idDLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(sumLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(dateLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(employeeIdLabels[gx]);

                int nr = gx;
                int nr3 = rowCount;
                panels[gx].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panels[gx].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(Integer.valueOf(TrId));
                        view.validateTransfersPanel.selectedTrid = Integer.valueOf(TrId);
                        for(int i = 0; i < nr3; i++) {
                            int nr2 = i;
                            panels[nr2].setBackground(Color.white); 
                            transferIdLabels[nr2].setBackground(Color.white); 
                            statusLabels[nr2].setBackground(Color.white);
                            ibanDLabels[nr2].setBackground(Color.white);
                            ibanSLabels[nr2] .setBackground(Color.white);
                            idDLabels[nr2].setBackground(Color.white);
                            idSLabels[nr2].setBackground(Color.white);
                            dateLabels[nr2].setBackground(Color.white);
                            sumLabels[nr2].setBackground(Color.white);
                            employeeIdLabels[nr2].setBackground(Color.white);
                        }
                        panels[nr].setBackground(Color.green); 
                        transferIdLabels[nr].setBackground(Color.green); 
                        statusLabels[nr].setBackground(Color.green);
                        ibanDLabels[nr].setBackground(Color.green);
                        ibanSLabels[nr] .setBackground(Color.green);
                        idDLabels[nr].setBackground(Color.green);
                        idSLabels[nr].setBackground(Color.green);
                        dateLabels[nr].setBackground(Color.green);
                        sumLabels[nr].setBackground(Color.green);
                        employeeIdLabels[nr].setBackground(Color.green);
                    }
                });

                view.validateTransfersPanel.centralPanel.add(panels[gx]);
                view.validateTransfersPanel.centralPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                gx++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void ValidateATransfer(String status) {
        try {
            int TrId = view.validateTransfersPanel.selectedTrid;
            //String status = "SUCCESSFUL";
            // model.pStmt = model.con.prepareStatement("update transfer set statusTr = ? where idTransfer = ?");
            // model.pStmt.setString(1, status);
            // model.pStmt.setInt(2, TrId);
            // model.pStmt.execute();
            model.pStmt = model.con.prepareStatement("select idAngajat from angajat where NumeUtilizator = ?");
            model.pStmt.setString(1, view.validateTransfersPanel.username);
            model.rst = model.pStmt.executeQuery();
            int employeeId = 0;
            while(model.rst.next()) {
                employeeId = model.rst.getInt("idAngajat");
            }

            model.cStmt = model.con.prepareCall("{call validateTransfer(?, ?, ?)}");
            model.cStmt.setInt(1, employeeId);
            model.cStmt.setInt(2, TrId);
            model.cStmt.setString(3, status);
            model.cStmt.execute();

            view.validateTransfersPanel.selectedTrid = 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private JLabel label(String x){
        final JLabel l;
            l = new JLabel(x, JLabel.LEFT);
            l.setFont(new java.awt.Font("Tahoma", 0, 16));
            l.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            l.setOpaque(true);
            l.setBorder(null);
            return l;
        }
}
