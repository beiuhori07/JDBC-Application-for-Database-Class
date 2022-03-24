package proiect_bd;

public class TestLoginUser {
	public static void main(String[] args) {
		Model model = new Model();
		LoginUserView view = new LoginUserView();
		LoginUserController controller = new LoginUserController(model, view);
		//view.setVisible(true);	
	}
}
