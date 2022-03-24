package proiect_bd;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class LoginUserController {
	private Model model;
	private LoginUserView view;
	
	LoginUserController(Model model, LoginUserView view) {
		this.model = model;
		this.view = view;
		
		view.addLoginListener(new LoginListener());
		view.addBackListener(new BackListener());
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				List<String> list = view.getUserInput();
			    model.cStmt = model.con.prepareCall("{? = call verifyUserLogin(?, ?)}");
				model.cStmt.registerOutParameter(1, java.sql.Types.BOOLEAN);
				model.cStmt.setString(2, list.get(0));
				model.cStmt.setString(3, list.get(1));
				model.cStmt.execute();
				Boolean outputValue = model.cStmt.getBoolean(1);
				model.loginResult = ( outputValue == false ) ? 1 : 2 ;
				if(model.loginResult == 1)
					view.setVisResultLabel(true);
				else {
					view.removeThisFrame();
					MainMenuClientView wp = new MainMenuClientView(view.tf1.getText());
					MainMenuController wpc = new MainMenuController(model, wp);
				}
				System.out.println(list.get(0) + " " + list.get(1) + " " + outputValue);
			} catch (SQLException ex) {
				ex.printStackTrace();
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
