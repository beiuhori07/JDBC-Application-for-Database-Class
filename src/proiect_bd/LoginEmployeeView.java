package proiect_bd;

public class LoginEmployeeView extends LoginUserView {
    LoginEmployeeView() {
        super();
        label.setText("Logare Angajat");
		label.setBounds(110, 50, 250, 25);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginEmployeeView view = new LoginEmployeeView();
    }
}
