package proiect_bd;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.*;

public class MainMenuController {
    Model model;
    MainMenuClientView view;
    MainMenuController(Model model, MainMenuClientView view) {
        this.model = model;
        this.view = view;

        view.addCrtAccListener(new CrtAccListener());
        view.addSvgAccListener(new SvgAccListener());
        view.addTransferListener(new TransferListener());
        view.addNotificationListener(new NotificationListener());
        view.addFavoriteListener(new FavoriteListener());
        view.addPersonalDataListener(new PersonalDataListener());
        view.addLogoutListener(new LogoutListener());
        view.addBillsActionListener(new BillsPanelListener());
        view.crtAccPanel.addTrsfActionListener(new TransferListener());
        view.crtAccPanel.addBackActionListener(new BackListener());
        view.crtAccPanel.addDepositActionListener(new DepositListener());
        view.crtAccPanel.addWithdrawActionListener(new WithdrawListener());
        view.trasnferPanel.addBackActionListener(new BackListener());
        view.personalDataPanel.addBackActionListener(new BackListener());
        view.personalDataPanel.addModifyActionListener(new ModifyListener());
        view.trasnferPanel.addTrasnferActionListener(new SendTransferListener());
        view.favoritePanel.addBackActionListener(new BackListener());
        view.favoritePanel.addAddFavActionListener(new AddFavListener());
        view.svgAccPanel.addBackActionListener(new BackListener());
        view.svgAccPanel.addLiquidationActionListener(new LiquidationListener());
        view.svgAccPanel.addCreateSvgActionListener(new CreateSvgListener());
        view.svgAccPanel.addSvgDepositActionListener(new SvgDepositListener());
        view.notificationPanel.addBackActionListener(new BackListener());
        view.notificationPanel.addDeleteActionListener(new DeleteNotificationListener());
        view.billsPanel.addBackActionListener(new BackListener());
        view.billsPanel.addPayActionListener(new PayBillListener());
        
    }

    class SvgDepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(view.svgAccPanel.selectedIban.equals("")) {
                    view.svgAccPanel.setBadSumLabelVisible(false);
                    view.svgAccPanel.setBadAccNrLabelVisible(false);
                    view.svgAccPanel.setBadLiqLabelVisible(true);
                    view.svgAccPanel.setGoodLiqLabelVisible(false);
                    view.svgAccPanel.setGoodDepositLabelVisible(false);
                }
                else {

                    if(view.svgAccPanel.sumField.getText().equals("") || Integer.valueOf(view.svgAccPanel.sumField.getText()) <= 0) {
                        //suma incorecta
                        view.svgAccPanel.setBadSumLabelVisible(true);
                        view.svgAccPanel.setBadAccNrLabelVisible(false);
                        view.svgAccPanel.setBadLiqLabelVisible(false);
                    view.svgAccPanel.setGoodLiqLabelVisible(false);
                    view.svgAccPanel.setGoodDepositLabelVisible(false);
                    
                    }
                    else {
                        model.cStmt = model.con.prepareCall("{call depositSavingsAccount(?,?)}");
                        model.cStmt.setString(1, view.svgAccPanel.selectedIban);
                        model.cStmt.setInt(2, Integer.valueOf(view.svgAccPanel.sumField.getText()));
                        model.cStmt.executeQuery();
                        view.svgAccPanel.setBadSumLabelVisible(false);
                        view.svgAccPanel.setBadAccNrLabelVisible(false);
                        view.svgAccPanel.setBadLiqLabelVisible(false);
                        view.svgAccPanel.setGoodLiqLabelVisible(false);
                        view.svgAccPanel.setGoodDepositLabelVisible(true);
                        SvgAccInit();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
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
    class AddFavListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(!view.favoritePanel.idField.getText().equals("")) {
                    int id = 0;
                    int idpropriu = 0;

                    model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
                    model.pStmt.setString(1, view.favoritePanel.username);
                    model.rst = model.pStmt.executeQuery();
                    while(model.rst.next()) {
                        idpropriu = model.rst.getInt("idClient");
                        System.out.println(idpropriu);
                    }

                    try {
                        id =  Integer.parseInt(view.favoritePanel.idField.getText());

                        model.cStmt = model.con.prepareCall("{call savefavorite(?, ?)}");
                        model.cStmt.setInt(1, idpropriu);
                        model.cStmt.setInt(2, id);
                        model.cStmt.execute();
                        view.favoritePanel.wrongidLabel.setVisible(false);
                        LoadLabels();
                    } catch (NumberFormatException exe) {
                        // id incorect - nu e nr
                        view.favoritePanel.wrongidLabel.setVisible(true);
                        System.out.println("idfield nu e nr");
                        exe.printStackTrace();
                    }
                }
                else {
                    view.favoritePanel.wrongidLabel.setVisible(true);
                    System.out.println("id incorect");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class BillsPanelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "billsPanel");
            // BillsPanelInit();
        }
    }
    class PayBillListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(view.billsPanel.selectedValue != 0) {
                    model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
                    model.pStmt.setString(1, view.crtAccPanel.username);
                    model.rst = model.pStmt.executeQuery();
                    int id = 0;
                    while(model.rst.next()) {
                        id = model.rst.getInt("idClient");
                        System.out.println(id);
                    }

                    int soldcurent = 0;
                    model.pStmt = model.con.prepareStatement("select soldCurent from contcurent where idClient = ?");
                    model.pStmt.setInt(1, id);
                    model.rst = model.pStmt.executeQuery();
                    while(model.rst.next()) {
                        soldcurent = model.rst.getInt("soldCurent");
                    }
                    
                    if(soldcurent >= view.billsPanel.selectedValue) {

                        model.pStmt = model.con.prepareStatement("update contcurent set soldCurent = soldCurent - ? where idClient = ?");
                        model.pStmt.setInt(1, view.billsPanel.selectedValue);
                        model.pStmt.setInt(2, id);
                        model.pStmt.execute();
                        
                        String s = "Factura platita cu succes!";
                        model.pStmt = model.con.prepareStatement("insert into proiect.notificari values(?,false, curtime(),?,0)");
                        model.pStmt.setString(1, s);
                        model.pStmt.setInt(2, id);
                        model.pStmt.execute();

                        view.billsPanel.noBilllabel.setVisible(false);
                        view.billsPanel.noMoneylabel.setVisible(false);
                        System.out.println("bill payed");
                    }
                    else {
                        view.billsPanel.noBilllabel.setVisible(false);
                        view.billsPanel.noMoneylabel.setVisible(true);
                        // nu ai destui bani
                        // fa un label vizibil
                        System.out.println("not enough money");
                    }
                }
                else {
                    System.out.println("select bill");
                    view.billsPanel.noBilllabel.setVisible(true);
                    view.billsPanel.noMoneylabel.setVisible(false);
                    // factura neselectata
                    // fa label vizibl
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    class DepositListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(view.crtAccPanel.sumField.getText().equals("") || Integer.valueOf(view.crtAccPanel.sumField.getText()) <= 0) {
                    // suma incorecta
                    view.crtAccPanel.setGoodDepositLabelVisible(false);
                    view.crtAccPanel.setGoodWithdrawLabelVisible(false);
                    view.crtAccPanel.setBadSumLabelVisible(true);
                }
                else {
                    model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
                    model.pStmt.setString(1, view.crtAccPanel.username);
                    model.rst = model.pStmt.executeQuery();
                    int id = 0;
                    while(model.rst.next()) {
                        id = model.rst.getInt("idClient");
                        System.out.println(id);
                    }
                    
                    model.cStmt = model.con.prepareCall("{call depositCurrentAccount(?,?,0)}");
                    model.cStmt.setInt(1, id);
                    model.cStmt.setInt(2, Integer.valueOf(view.crtAccPanel.sumField.getText()));
                    model.cStmt.execute();
                    //model.cStmt.setInt(3, 0);
                    System.out.println(Integer.valueOf(view.crtAccPanel.sumField.getText()));
                    System.out.println("successful deposit!");
                    CrtAccInit();
                    view.crtAccPanel.sumField.setText("");
                    view.crtAccPanel.setGoodDepositLabelVisible(true);
                    view.crtAccPanel.setGoodWithdrawLabelVisible(false);
                    view.crtAccPanel.setBadSumLabelVisible(false);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class WithdrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(view.crtAccPanel.sumField.getText().equals("") || Integer.valueOf(view.crtAccPanel.sumField.getText()) <= 0) {
                    // suma incorecta
                    view.crtAccPanel.setGoodDepositLabelVisible(false);
                    view.crtAccPanel.setGoodWithdrawLabelVisible(false);
                    view.crtAccPanel.setBadSumLabelVisible(true);
                }
                else {
                    model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
                    model.pStmt.setString(1, view.crtAccPanel.username);
                    model.rst = model.pStmt.executeQuery();
                    int id = 0;
                    while(model.rst.next()) {
                        id = model.rst.getInt("idClient");
                        System.out.println(id);
                    }
                    
                    model.pStmt = model.con.prepareStatement("select soldCurent from contcurent where idClient = ?");
                    model.pStmt.setInt(1, id);
                    model.rst = model.pStmt.executeQuery();
                    int sold = 0;
                    while(model.rst.next()) {
                        sold = model.rst.getInt("soldCurent");
                    }
                    if(Integer.valueOf(view.crtAccPanel.sumField.getText()) > sold) {
                        view.crtAccPanel.setGoodDepositLabelVisible(false);
                        view.crtAccPanel.setGoodWithdrawLabelVisible(false);
                        view.crtAccPanel.setBadSumLabelVisible(true);
                        // suma prea mare
                        // fa un label vizibil
                    }
                    else {
                        model.cStmt = model.con.prepareCall("{call withdrawCurrentAccount(?,?,0)}");
                        model.cStmt.setInt(1, id);
                        model.cStmt.setInt(2, Integer.valueOf(view.crtAccPanel.sumField.getText()));
                        model.cStmt.execute();
                        //model.cStmt.setInt(3, 0);
                        System.out.println(Integer.valueOf(view.crtAccPanel.sumField.getText()));
                        System.out.println("successful deposit!");
                        CrtAccInit();
                        view.crtAccPanel.sumField.setText("");

                        view.crtAccPanel.setGoodDepositLabelVisible(false);
                        view.crtAccPanel.setGoodWithdrawLabelVisible(true);
                        view.crtAccPanel.setBadSumLabelVisible(false);
                        // fa vizibil label de succes
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    class LiquidationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MakeLiquidation();
        }
    }
    class DeleteNotificationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(view.notificationPanel.selectedId != 0) {
                    model.pStmt = model.con.prepareStatement("update notificari set vizionat = true where idNotificare = ?");
                    model.pStmt.setInt(1, view.notificationPanel.selectedId);
                    model.pStmt.execute();
                    NotificationsInit();
                    view.notificationPanel.badNotifLabel.setVisible(false);
                }
                else {
                    // fa label vizivil
                    // view.notificationPanel
                    view.notificationPanel.badNotifLabel.setVisible(true);
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            
        }
    }
    class CreateSvgListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AddSavingsAccount();
        }
    }
    class CrtAccListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "CurrentAccount");
            CrtAccInit();
        }
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "ParentPanel");
        }
    }
    class SvgAccListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "savingsPanel");
            SvgAccInit();
        }
    }
    class TransferListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "Transfer");
            view.trasnferPanel.setBadIbanLabelVisible(false);
            view.trasnferPanel.setBadSumLabelVisible(false);
        }
    }
    class NotificationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "notificationPanel");
            NotificationsInit();
        }
    }
    class FavoriteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "favoritePanel");
            LoadLabels();
        }
    }
    class PersonalDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.cl.show(view.cards, "PersonalData");
            PersonalDataInit();
        }
    }
    class SendTransferListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
                model.pStmt.setString(1, view.crtAccPanel.username);
                model.rst = model.pStmt.executeQuery();
                int id = 0;
                while(model.rst.next()) {
                    id = model.rst.getInt("idClient");
                }

                model.pStmt = model.con.prepareStatement("SELECT iban, soldCurent from contCurent where idClient = ?");
                model.pStmt.setInt(1, id);
                model.rst = model.pStmt.executeQuery();
                String iban = "";
                int sold = 0;
                while(model.rst.next()) {
                    iban = model.rst.getString("iban");
                    sold = model.rst.getInt("soldCurent");
                }
                if(sold < view.trasnferPanel.getIntSum()) {
                    System.out.println("sold prea mare");
                    view.trasnferPanel.setBadSumLabelVisible(true);
                    view.trasnferPanel.setBadIbanLabelVisible(false);
                    // fa un label visibil care indica eroarea
                }
                else {
                    model.pStmt = model.con.prepareStatement("SELECT idClient from contCurent where iban = ?");
                    model.pStmt.setString(1, view.trasnferPanel.getIban());
                    model.rst = model.pStmt.executeQuery();
                    int idDestinatar = 0;
                    while(model.rst.next()) {
                        idDestinatar = model.rst.getInt("idClient");
                    }
                    if(idDestinatar == 0) {
                        System.out.println("nu exista acel iban");
                        view.trasnferPanel.setBadIbanLabelVisible(true);
                        view.trasnferPanel.setBadSumLabelVisible(false);
                        // nu exista acel iban => fa un label visibil cu eroarea
                    }
                    else {
                        view.trasnferPanel.setBadSumLabelVisible(false);
                        view.trasnferPanel.setBadIbanLabelVisible(false);
                        // sold valid si iban valid => putem face transferul
                        model.cStmt = model.con.prepareCall("{call transfer(?, ?, ?)}");
                        model.cStmt.setString(1, iban);
                        model.cStmt.setString(2, view.trasnferPanel.getIban());
                        model.cStmt.setInt(3, view.trasnferPanel.getIntSum());
                        model.cStmt.execute();
                        System.out.println("successfull transfer!");
                        view.trasnferPanel.reset();
                    }
                }


            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    class ModifyListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            try {
                model.pStmt = model.con.prepareStatement("update client set nume = ?,  prenume = ?, cnp = ?, adresa = ?, nr = ?, email = ?, dataNasterii = ? where numeUtilizator = ?");
                model.pStmt.setString(1, view.personalDataPanel.nume.getText());
                model.pStmt.setString(2, view.personalDataPanel.prenume.getText());
                model.pStmt.setString(3, view.personalDataPanel.cnp.getText());
                // model.pStmt.setString(4, view.personalDataPanel.username.getText());
                model.pStmt.setString(4, view.personalDataPanel.adress.getText());
                model.pStmt.setString(5, view.personalDataPanel.nr.getText());
                model.pStmt.setString(6, view.personalDataPanel.email.getText());
                model.pStmt.setString(7, view.personalDataPanel.date.getText());
                model.pStmt.setString(8, view.personalDataPanel.user);
                model.pStmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void MakeLiquidation() {
        try {
            if(view.svgAccPanel.selectedIban.equals("")) {
                // not selected
                // fa vizibil un label de eroare
                view.svgAccPanel.setGoodLiqLabelVisible(false);
                view.svgAccPanel.setBadLiqLabelVisible(true);
                view.svgAccPanel.setBadAccNrLabelVisible(false);
                view.svgAccPanel.setGoodDepositLabelVisible(false);
                view.svgAccPanel.setBadSumLabelVisible(false);
            }
            else {
                model.cStmt = model.con.prepareCall("{call liquidationSavingsAccount(?)}");
                model.cStmt.setString(1, view.svgAccPanel.selectedIban);
                model.cStmt.execute();
                model.pStmt = model.con.prepareStatement("DELETE from contEconomii where iban = ?");
                model.pStmt.setString(1, view.svgAccPanel.selectedIban);
                model.pStmt.execute();
                view.svgAccPanel.selectedIban = "";
                SvgAccInit();
                view.svgAccPanel.setBadAccNrLabelVisible(false);
                view.svgAccPanel.setGoodLiqLabelVisible(true);
                view.svgAccPanel.setBadLiqLabelVisible(false);
                view.svgAccPanel.setGoodDepositLabelVisible(false);
                view.svgAccPanel.setBadSumLabelVisible(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void NotificationsInit() {
        try {
            // fa o alta functie pt id
            view.notificationPanel.centralPanel.removeAll();
            view.notificationPanel.centralPanel.revalidate();
            view.notificationPanel.centralPanel.repaint();

            model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
            model.pStmt.setString(1, view.notificationPanel.username);
            model.rst = model.pStmt.executeQuery();
            int id = 0;
            while(model.rst.next()) {
                id = model.rst.getInt("idClient");
            }
            
            model.pStmt = model.con.prepareStatement("SELECT * from notificari where vizionat = false and idClient = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.pStmt.setInt(1, id);
            model.rst = model.pStmt.executeQuery();
            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }
            
            JLabel[] textLabels = new JLabel[rowCount];
            JLabel[] dateLabels = new JLabel[rowCount];
            JPanel[] panels = new JPanel[rowCount];
            int idNotif = 0;

            view.notificationPanel.centralPanel.setPreferredSize(new Dimension(400, 120 * rowCount));
            
            int gx = 0;
            while(model.rst.next()) {
                idNotif = model.rst.getInt("idNotificare");
                dateLabels[gx] = label("[" + model.rst.getString("datatimp") + "]: ");
                dateLabels[gx].setFont(new Font("Dialog", Font.PLAIN, 15));

                textLabels[gx] = label(model.rst.getString("textNotificare"));
                
                panels[gx] = new JPanel();
                panels[gx].setBorder(BorderFactory.createLineBorder(Color.black));
                panels[gx].setLayout(new BoxLayout(panels[gx], BoxLayout.X_AXIS));
                
                panels[gx].add(Box.createRigidArea(new Dimension(0, 10)));
                panels[gx].add(dateLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(10, 0)));
                panels[gx].add(textLabels[gx]);
                panels[gx].add(Box.createRigidArea(new Dimension(0, 40)));

                int nr = gx;
                int nr3 = rowCount;
                int id1 = idNotif;
                panels[gx].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panels[gx].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(id1);
                        view.notificationPanel.selectedId = id1;
                        for(int i = 0; i < nr3; i++) {
                            int nr2 = i;
                            panels[nr2].setBackground(Color.white); 
                            dateLabels[nr2].setBackground(Color.white);
                            textLabels[nr2].setBackground(Color.white);
                        }
                        panels[nr].setBackground(Color.green); 
                        dateLabels[nr].setBackground(Color.green);
                        textLabels[nr].setBackground(Color.green);
                    }
                });
                
                view.notificationPanel.centralPanel.add(panels[gx]);
                view.notificationPanel.centralPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                gx++;
            }
            
            System.out.println("good3");
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void AddSavingsAccount() {
        try{
            model.pStmt = model.con.prepareStatement("SELECT idClient, banca from client where numeUtilizator = ?");
            model.pStmt.setString(1, view.crtAccPanel.username);
            model.rst = model.pStmt.executeQuery();
            int id = 0;
            //int lastindex = view.svgAccPanel.lastIterator;
            String bank = "";
            while(model.rst.next()) {
                id = model.rst.getInt("idClient");
                bank = model.rst.getString("banca");
            }

            model.pStmt = model.con.prepareStatement("SELECT count(*) from contEconomii where idClient = ?");
            model.pStmt.setInt(1, id);
            model.rst = model.pStmt.executeQuery();
            int accnr = 0;
            while(model.rst.next()) {
                accnr = model.rst.getInt(1);
            }
            if(accnr == 5) {
                System.out.println("ai deja nr maxim de conturi de economii");
                view.svgAccPanel.setBadAccNrLabelVisible(true);
                view.svgAccPanel.setGoodLiqLabelVisible(false);
                view.svgAccPanel.setBadLiqLabelVisible(false);
                view.svgAccPanel.setBadSumLabelVisible(false);
                view.svgAccPanel.setGoodDepositLabelVisible(false);
                // fa vizibil un label de eroare
            }
            else {
                view.svgAccPanel.setBadAccNrLabelVisible(false);
                view.svgAccPanel.setGoodLiqLabelVisible(false);
                view.svgAccPanel.setBadLiqLabelVisible(false);
                view.svgAccPanel.setBadSumLabelVisible(false);
                view.svgAccPanel.setGoodDepositLabelVisible(false);
                model.cStmt = model.con.prepareCall("{call createSavingsAccount(?,?)}");
                model.cStmt.setInt(1,id);
                model.cStmt.setString(2, bank);
                //model.cStmt.setInt(3,view.svgAccPanel.lastIterator + 1);
                model.cStmt.execute();
                //view.svgAccPanel.lastIterator++;
                SvgAccInit();
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void PersonalDataInit() {
        try {
            model.pStmt = model.con.prepareStatement("SELECT cnp, nume, prenume, adresa, nr, email, banca, idClient,  dataNasterii from client where numeUtilizator = ?");
            model.pStmt.setString(1, view.trasnferPanel.username);
            model.rst = model.pStmt.executeQuery();
            while(model.rst.next()) {
                view.personalDataPanel.nume.setText(model.rst.getString("nume"));
                view.personalDataPanel.prenume.setText(model.rst.getString("prenume"));
                view.personalDataPanel.cnp.setText(model.rst.getString("cnp"));
                view.personalDataPanel.username.setText(view.personalDataPanel.user);
                view.personalDataPanel.id.setText(model.rst.getString("idClient"));
                view.personalDataPanel.adress.setText(model.rst.getString("adresa"));
                view.personalDataPanel.nr.setText(model.rst.getString("nr"));
                view.personalDataPanel.email.setText(model.rst.getString("email"));
                view.personalDataPanel.bank.setText(model.rst.getString("banca"));
                view.personalDataPanel.date.setText(model.rst.getString("dataNasterii"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void SvgAccInit() {
        try {
            // fa o alta functie pt id
            view.svgAccPanel.centralPanel.removeAll();
            view.svgAccPanel.centralPanel.revalidate();
            view.svgAccPanel.centralPanel.repaint();

            view.svgAccPanel.setBadAccNrLabelVisible(false);
            view.svgAccPanel.setBadSumLabelVisible(false);
            model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
            model.pStmt.setString(1, view.crtAccPanel.username);
            model.rst = model.pStmt.executeQuery();
            int id = 0;
            while(model.rst.next()) {
                id = model.rst.getInt("idClient");
            }
            
            model.pStmt = model.con.prepareStatement("SELECT * from contEconomii where idClient = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.pStmt.setInt(1, id);
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

            view.svgAccPanel.centralPanel.setPreferredSize(new Dimension(140 * rowCount, 210 * rowCount));
            
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

                int nr = gx;
                int nr3 = rowCount;
                panels[gx].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panels[gx].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(ib);
                        view.svgAccPanel.selectedIban = ib;
                        for(int i = 0; i < nr3; i++) {
                            int nr2 = i;
                            panels[nr2].setBackground(Color.white); 
                            firstLinePanels[nr2].setBackground(Color.white); 
                            balanceLabels[nr2].setBackground(Color.white);
                            nameLabel[nr2].setBackground(Color.white);
                            ibanLabels[nr2] .setBackground(Color.white);
                            ibanCrtAccLabels[nr2].setBackground(Color.white);
                            interestLabels[nr2].setBackground(Color.white);
                            dateLabels[nr2].setBackground(Color.white);
                        }
                        panels[nr].setBackground(Color.green); 
                        firstLinePanels[nr].setBackground(Color.green); 
                        balanceLabels[nr].setBackground(Color.green);
                        nameLabel[nr].setBackground(Color.green);
                        ibanLabels[nr] .setBackground(Color.green);
                        ibanCrtAccLabels[nr].setBackground(Color.green);
                        interestLabels[nr].setBackground(Color.green);
                        dateLabels[nr].setBackground(Color.green);
                    }
                });
                
                view.svgAccPanel.centralPanel.add(panels[gx]);
                view.svgAccPanel.centralPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                gx++;
            }
            
            System.out.println("good3");
            
            
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void CrtAccInit() {
        try {
            model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
            model.pStmt.setString(1, view.crtAccPanel.username);
            model.rst = model.pStmt.executeQuery();
            int id = 0;
            while(model.rst.next()) {
                id = model.rst.getInt("idClient");
                System.out.println("good");
            }
            
            model.pStmt = model.con.prepareStatement("SELECT iban, soldCurent from contCurent where idClient = ?");
            model.pStmt.setInt(1, id);
            model.rst = model.pStmt.executeQuery();
            String iban = "";
            int sold = 0;
            while(model.rst.next()) {
                iban = model.rst.getString("iban");
                sold = model.rst.getInt("soldCurent");
            }
            view.crtAccPanel.initAccData(iban, sold, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void LoadLabels(){
        try {
            JPanel centralPanel = view.favoritePanel.centralPanel;

            centralPanel.removeAll();
            centralPanel.revalidate();
            centralPanel.repaint();
            centralPanel.add(Box.createRigidArea(new Dimension(0, 50)));
            JLabel[] favLabels = view.favoritePanel.l;

            model.pStmt = model.con.prepareStatement("SELECT idClient from client where numeUtilizator = ?");
            model.pStmt.setString(1, view.crtAccPanel.username);
            model.rst = model.pStmt.executeQuery();
            int id = 0;
            while(model.rst.next()) {
                id = model.rst.getInt("idClient");
            }

            model.pStmt = model.con.prepareStatement("SELECT contactFavorit, ibanFavorit from favorite where idClient = ?", ResultSet.TYPE_SCROLL_SENSITIVE, 
            ResultSet.CONCUR_UPDATABLE);
            model.pStmt.setInt(1, id);
            model.rst = model.pStmt.executeQuery();
            int rowCount = 0;
            if (model.rst.last()) {
                rowCount = model.rst.getRow();
                // Move to beginning
                model.rst.beforeFirst();
            }

            favLabels = new JLabel[rowCount];
            JLabel[] ibanLabels = new JLabel[rowCount];
            String[] ibans = new String[rowCount];
            JPanel[] panels = new JPanel[rowCount];
            Integer[] ids = new Integer[rowCount];

            int gx = 0;
            while(model.rst.next()) {
                ids[gx] = model.rst.getInt("contactFavorit");
                ibans[gx] = new String(model.rst.getString("ibanFavorit"));
                gx++;
            }
            String nume,prenume;
            for(gx = 0; gx < rowCount; gx++) {
                panels[gx] = new JPanel();
                panels[gx].setLayout(new BoxLayout(panels[gx], BoxLayout.X_AXIS));
                panels[gx].setBorder(BorderFactory.createLineBorder(Color.black));

                

                model.pStmt = model.con.prepareStatement("SELECT nume, prenume from client where idClient = ?");
                model.pStmt.setInt(1, ids[gx]);
                model.rst = model.pStmt.executeQuery();
                while(model.rst.next()) {
                    nume = model.rst.getString("nume");
                    prenume = model.rst.getString("prenume");
                    favLabels[gx] = label(nume + " " + prenume);
                    ibanLabels[gx] = label(" -     " + ibans[gx]);
                    favLabels[gx].setBorder(null);
                    ibanLabels[gx].setBorder(null);
                    favLabels[gx].setFont(new Font("Dialog", Font.BOLD, 22));
                    ibanLabels[gx].setFont(new Font("Dialog", Font.BOLD, 18));

                    panels[gx].add(Box.createRigidArea(new Dimension(0, 50)));
                    panels[gx].add(Box.createRigidArea(new Dimension(20, 0)));
                    panels[gx].add(favLabels[gx]);
                    panels[gx].add(Box.createRigidArea(new Dimension(20, 0)));
                    panels[gx].add(ibanLabels[gx]);
                    panels[gx].add(Box.createRigidArea(new Dimension(20, 0)));
                    panels[gx].add(Box.createRigidArea(new Dimension(0, 50)));

                }
                String ib = new String(ibans[gx]);
                panels[gx].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panels[gx].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(ib);
                        view.cl.show(view.cards, "Transfer");
                        view.trasnferPanel.iban.setText(ib);
                    }
                });

                centralPanel.add(panels[gx]);
                centralPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            }            
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
