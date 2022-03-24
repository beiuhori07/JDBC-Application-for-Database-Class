package proiect_bd;

import java.awt.event.*;
import java.sql.SQLException;

public class CreateUserController {
    private Model model;
	private CreateUserView view;
	
	CreateUserController(Model model, CreateUserView view) {
		this.model = model;
		this.view = view;
		
		view.addCreateUserListener(new CreateUserListener());
		view.addBackListener(new BackListener());
	}
    class CreateUserListener implements ActionListener {
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
                        model.pStmt = model.con.prepareStatement("select Nume from client where NumeUtilizator = ?");
                        model.pStmt.setString(1, view.getUsername());
                        model.rst = model.pStmt.executeQuery();
                        if(model.rst.next()) {
                            System.out.println(" exista deja un user cu acel username!");
                            view.labelUsernameWrong.setVisible(true);
                            view.setVisDateWrongLabel(false);
                            view.setVisIncompleteLabel(false);
                        }
                        else {
                            System.out.println("nu exista deja un user cu acel username!");
                            view.labelUsernameWrong.setVisible(false);
                            model.cStmt = model.con.prepareCall("{call createUserAcc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
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
                            model.cStmt.execute();
                            view.dispose();
                            MainMenuClientView newView = new MainMenuClientView(view.getUsername());
                            MainMenuController newController = new MainMenuController(model, newView);
                            System.out.println("user created successfully!");
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
