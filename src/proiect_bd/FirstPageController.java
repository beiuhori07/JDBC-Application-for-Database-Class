package proiect_bd;

import java.awt.event.*;

public class FirstPageController {
    Model model;
    FirstPageView view;
    FirstPageController(Model model, FirstPageView view) {
        this.model = model;
        this.view = view;

        view.addLoginAdminListener(new LoginAdminListener());
        view.addLoginEmplListener(new LoginEmplListener());
        view.addLoginUserListener(new LoginUserListener());
        view.addCrtUserListener(new CrtUserListener());
        view.addCrtEmplListener(new CrtEmplListener());
    }
    class LoginAdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            view.dispose();
            LoginAdminView newView = new LoginAdminView();    
            LoginAdminController newController = new LoginAdminController(model, newView);
        }
    }
    class LoginUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            view.dispose();
            LoginUserView newView = new LoginUserView();
            LoginUserController newController = new LoginUserController(model, newView);
        }
    }
    class LoginEmplListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            view.dispose();
            LoginEmployeeView newView = new LoginEmployeeView();
            LoginEmployeeController newController = new LoginEmployeeController(model, newView);
        }
    }
    class CrtUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            view.dispose();
            CreateUserView newView = new CreateUserView();
            CreateUserController newController = new CreateUserController(model, newView);
        }
    }
    class CrtEmplListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            view.dispose();
            CreateEmployeeView newView = new CreateEmployeeView();
            CreateEmployeeController newController = new CreateEmployeeController(model, newView);
        }
    }
}
