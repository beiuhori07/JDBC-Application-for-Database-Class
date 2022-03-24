package proiect_bd;

import java.awt.event.*;
import java.sql.SQLException;

public class CreateEmployeeController {
    Model model;
    CreateEmployeeView view;

    CreateEmployeeController(Model model, CreateEmployeeView view) {
        this.model = model;
        this.view = view;

        view.addCreateEmployeeListener(new CreateEmployeeListener());
        view.addBackListener(new BackListener());
    }
    class CreateEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(view.areTextFieldsIncomplete()) {
                System.out.println("date incomplete!");
                view.setVisIncompleteLabel(true);
            }
            else {
                view.setVisIncompleteLabel(false);
                if(view.isDateFormatGood()) {
                    view.setVisDateWrongLabel(false);
                    System.out.println("all good !");
                    try {
                        model.pStmt = model.con.prepareStatement("select Nume from angajat where NumeUtilizator = ?");
                        model.pStmt.setString(1, view.getUsername());
                        model.rst = model.pStmt.executeQuery();
                        if(model.rst.next()) {
                            System.out.println(" exista deja un angajat cu acel username!");
                            view.labelUsernameWrong.setVisible(true);
                            view.setVisDateWrongLabel(false);
                            view.setVisIncompleteLabel(false);
                        }
                        else {
                            System.out.println("nu exista deja un angajat cu acel username!");
                            view.labelUsernameWrong.setVisible(false);
                            model.cStmt = model.con.prepareCall("{call createEmployeeAcc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?, ?)}");
                            model.cStmt.setString(1, view.getUsername());
                            model.cStmt.setString(2, view.getPassword());
                            model.cStmt.setString(3, view.getCNP());
                            model.cStmt.setString(4, view.getNume());
                            model.cStmt.setString(5, view.getPrenume());
                            model.cStmt.setString(6, view.getAdresa());
                            model.cStmt.setString(7, view.getNr());
                            model.cStmt.setString(8, view.getEmail());
                            model.cStmt.setString(9, view.getBanca());
                            model.cStmt.setString(10, view.getDate());
                            model.cStmt.setInt(11, view.getIntSalariu());
                            model.cStmt.setString(12, view.getDepartament());
                            model.cStmt.setString(13, view.getNorma());
                            
                            model.cStmt.execute();
                            
                            view.dispose();
                            EmployeeMenuView newView = new EmployeeMenuView(view.getUsername());
                            EmployeeMenuController newController = new EmployeeMenuController(model, newView);
                            System.out.println("employee created successfully!");
                        }
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    System.out.println("formata data incorect!");
                    view.setVisDateWrongLabel(true);
                }
            }
        }
    }
    class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.dispose();
			FirstPageView newView = new FirstPageView();
			FirstPageController newController = new FirstPageController(model, newView);
		}
	}
}
