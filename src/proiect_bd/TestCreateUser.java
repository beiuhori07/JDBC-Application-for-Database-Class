package proiect_bd;

public class TestCreateUser {
    public static void main(String[] args) {
        Model model = new Model();
        CreateUserView view = new CreateUserView();
		CreateUserController controller = new CreateUserController(model, view);
    }    
}
