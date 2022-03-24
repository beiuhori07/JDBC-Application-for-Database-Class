package proiect_bd;

public class TestLoginEmployee {
    public static void main(String[] args) {
		Model model = new Model();
		LoginEmployeeView view = new LoginEmployeeView();
		LoginEmployeeController controller = new LoginEmployeeController(model, view);
	}
}
